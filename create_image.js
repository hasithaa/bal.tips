const fs = require('fs');
const path = require('path');
const { convertFile}  = require('convert-svg-to-png');

// Set the path to the "content.en" folder
const folderPath = 'content.en';

// Set the path to the SVG template file
const svgTemplatePath = 'image.svg';

// Read the "content.en" folder structure
function readFolderStructure(folderPath) {
  const files = fs.readdirSync(folderPath);
  files.forEach(file => {
    const filePath = path.join(folderPath, file);
    const stat = fs.statSync(filePath);
    if (stat.isDirectory()) {
      readFolderStructure(filePath);
    } else {
      if (path.extname(filePath) === '.md') {
        console.log(`${filePath} : Processing file`);
        processMarkdownFile(filePath);
      }
    }
  });
}

// Process each Markdown file
function processMarkdownFile(filePath) {
  try {
    const fileContent = fs.readFileSync(filePath, 'utf-8');
    const title = getFrontMatter(fileContent);
    if (title) {
      const fileName = path.basename(filePath, '.md');
      const svgFilePath = path.join(path.dirname(filePath), `${fileName}.svg`);
      replaceTitleInSVG(svgFilePath, title);
      console.log(`${svgFilePath} : Replaced title in SVG file for "${title}"`);
    } else {
      throw new Error(`${filePath} : No title Found:`);
    }
  } catch (error) {
    throw new(`${filePath} : Error processing file:`, error);
  }
}

// Extract YAML front matter from Markdown content
function getFrontMatter(content) {
  const regex = /^---\n([\s\S]+?)\n---\n/;
  const matches = content.match(regex);
  if (matches && matches[1]) {
    return parseTitle(matches[1]);
  }
  return null;
}

// Parse YAML front matter
function parseTitle(yamlString) {
  const lines = yamlString.split('\n');
  // take first and split using colon and take second part
  let title = lines[0].split(':')[1].trim();
  // remove quotes
  if (title.startsWith('"') && title.endsWith('"')) {
    title = title.substring(1, title.length - 1);
  }
  return title;
}

// Replace the title in the SVG file
function replaceTitleInSVG(svgFilePath, title) {
  const svgTemplate = fs.readFileSync(svgTemplatePath, 'utf-8');
  const wrappedTitle = wrapSvgText(title, 30);
  const replacedSVG = svgTemplate.replace('REPLACE_TITLE', createTspanElements(wrappedTitle));
  fs.writeFileSync(svgFilePath, replacedSVG);
  (async() => {
  const outputFilePath = convertFile(svgFilePath);
  console.log(`${outputFilePath} : Converted SVG to PNG`);
  })();
}

// Wrap text if it exceeds the specified width
function wrapSvgText(text, width) {
  const words = text.split(' ');
  const lines = [];
  let currentLine = words[0];

  for (let i = 1; i < words.length; i++) {
    if ((currentLine.length + words[i].length + 1) <= width) {
      currentLine += ' ' + words[i];
    } else {
      lines.push(currentLine);
      currentLine = words[i];
    }
  }

  lines.push(currentLine);
  return lines;
}

function createTspanElements(lines) {
  return lines.map((line, index) => `<tspan
  x="67.792046"
  y="${index * 15 + 30.436655}"
  id="tspan867">${line}</tspan>`).join('');
}

// Start reading the "content.en" folder structure
readFolderStructure(folderPath);
