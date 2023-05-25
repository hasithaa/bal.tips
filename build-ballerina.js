const fs = require('fs').promises; // Using promises version of fs
const path = require('path');

const contentDir = path.join(__dirname, 'content.en');
const buildStatements = new Set();

async function extractCodeFences(filePath) {
    const data = await fs.readFile(filePath, 'utf8');
    const regex = /```ballerina\s+\{\s*filename="([^"]+)".*}\n([\s\S]*?)```/gm;
    let matches;
    console.log(`Extracting code fences from ${filePath}`);

    while ((matches = regex.exec(data)) !== null) {
        const filename = matches[1];
        const content = matches[2];
        const outputFilePath = path.join(path.dirname(filePath), filename);

        await createBalfile(outputFilePath, content, filename, filePath);

        // Create build.gradle file
        const buildGradlePath = path.join(path.dirname(filePath), 'build.gradle');
        const buildGradleContent = `apply from: "$rootDir/buildTasks/build.gradle"\n`;

        await createGradleFile(buildGradlePath, buildGradleContent, filePath);

        // Append include statement to root settings.gradle file
        const includeName = path.dirname(filePath).replace(contentDir + '/', '').replace(/\\/g, '-').replace(/\//g, '-');
        const includeStatement = `include(':${includeName}')`;
        const projectStatement = `project(':${includeName}').projectDir = file('${path.relative(__dirname, path.dirname(filePath))}/')`;
        buildStatements.add(includeStatement);
        buildStatements.add(projectStatement);
    }
}

async function createGradleFile(buildGradlePath, buildGradleContent, filePath) {
    try {
        await fs.writeFile(buildGradlePath, buildGradleContent);
        console.log(`File build.gradle has been created in ${path.dirname(filePath)}`);
    } catch (err) {
        console.error(`Error writing file build.gradle: ${err.message}`);
    }
}

async function createBalfile(outputFilePath, content, filename, filePath) {
    try {
        await fs.writeFile(outputFilePath, content.replace(/\/\/\$(?=\s|$)|\/\/!(?=\s|$)/g, ''));
        console.log(`File ${filename} has been created with content from ${filePath}`);
    } catch (err) {
        console.error(`Error writing file ${filename}: ${err.message}`);
    }
}

async function traverseDirectory(dirPath) {
    const files = await fs.readdir(dirPath);

    const fileProcesses = files.map(async (file) => {
        const filePath = path.join(dirPath, file);
        const stats = await fs.stat(filePath);

        if (stats.isDirectory()) {
            await traverseDirectory(filePath);
        } else if (path.extname(filePath) === '.md') {
            await extractCodeFences(filePath);
        }
    });

    await Promise.all(fileProcesses);
}

async function createSettingGradle() {
    const rootSettingsGradlePath = path.join(__dirname, 'settings.gradle');
    const rootSettingsGradleContent = `/*\n * MIT License\n * \n * Copyright (c) 2023 Hasitha Aravinda. All rights reserved.\n * Generated File, Do not Modify!\n */ \n rootProject.name = 'Bal.tips Website'\ninclude('buildTasks')\n`;
    const includeStatements = Array.from(buildStatements).join('\n');
    const rootSettingsGradleContentWithIncludes = `${rootSettingsGradleContent}${includeStatements}`;

    try {
        await fs.writeFile(rootSettingsGradlePath, rootSettingsGradleContentWithIncludes);
        console.log(`New settings.gradle added.`);
    } catch (err) {
        console.error(`Error creating settings.gradle: ${err.message}`);
    }
}

// Start the process
async function main() {
    await traverseDirectory(contentDir);
    await createSettingGradle();
}

main().catch(console.error);
