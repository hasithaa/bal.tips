/*
 * MIT License
 *
 * Copyright (c) 2022 Hasitha Aravinda. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package tips.bal.verifier;

import io.ballerina.projects.DiagnosticResult;
import io.ballerina.projects.PackageCompilation;
import io.ballerina.projects.Project;
import io.ballerina.tools.diagnostics.Diagnostic;
import io.ballerina.tools.diagnostics.Location;
import io.ballerina.tools.text.LineRange;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Test cases validating ballerina source files.
 *
 * @since 1.0.0
 */
public class VerifierTests {

    // Quick and Dirty Implementation, clean up this later.
    Example[] examples = new Example[0];

    @BeforeClass(groups = "output")
    public void setup() throws IOException {
        examples = ExampleLoader.filterBalFiles(ExampleLoader.loadExamples()).toArray(new Example[0]);
    }

    @DataProvider(parallel = true)
    public Object[] getExamples() {
        return examples;
    }

    @DataProvider(parallel = true)
    public Object[] getRunnableExamples() {
        return Arrays.stream(examples).filter(e -> e.kind != Example.Kind.Error).toArray();
    }

    @Test(groups = "output", dataProvider = "getExamples")
    public void testCompile(Example example) throws IOException {
        try {
            switch (example.kind) {
                case Output:
                    compileOutput((Example.Output) example);
                    break;
                case Error:
                    compileError((Example.Error) example);
                    break;
                case Service:
                    compileService((Example.Service) example);
                    break;
            }
        } catch (InterruptedException e) {
            throw new SkipException("Timeout");
        }
    }

    @Test(groups = "output", dataProvider = "getRunnableExamples", dependsOnMethods = "testCompile")
    public void verifyOutput(Example example) throws IOException {
        try {
            switch (example.kind) {
                case Output:
                    testOutput((Example.Output) example);
                    break;
                case Service:
                    testService((Example.Service) example);
                    break;
            }
        } catch (InterruptedException e) {
            throw new SkipException("Timeout");
        }
    }

    public void compileOutput(Example.Output example) throws IOException, InterruptedException {

        final CompilerUtils.BuildResult buildResult = CompilerUtils.build(example.path);
        example.buildResult = buildResult;
        if (buildResult.status != CompilerUtils.BuildStatus.SUCCESS) {
            Assert.fail(buildResult.status + " - " + buildResult.errorOut);
        }
    }

    public void testOutput(Example.Output example) throws IOException, InterruptedException {

        final String actual = CompilerUtils.run(example.buildResult);
        final String expected = ExampleLoader.readTxtFile(example.output);
        checkDifference(actual, expected);
    }

    public void compileError(Example.Error example) throws IOException {

        final Project project = CompilerUtils.compile(example.path);
        final PackageCompilation compilation = project.currentPackage().getCompilation();
        parseBalFileErrors(example);
        final DiagnosticResult diagnosticResult = compilation.diagnosticResult();
        if (diagnosticResult.errorCount() <= 0) {
            Assert.fail("No Compilation errors found");
        }
        if (diagnosticResult.errorCount() < example.errorCount) {
            Assert.fail(String.format("Too many errors, found %s, expected %s",
                    diagnosticResult.errorCount(), example.errorCount));
        }
        for (int[] pos : example.errorPos) {
            boolean anyMatch = false;
            for (Diagnostic diagnostic : diagnosticResult.errors()) {
                Location location = diagnostic.location();
                LineRange line = location.lineRange();
                if (line.startLine().line() == pos[0]
                        && line.startLine().offset() <= pos[1] && line.endLine().offset() >= pos[1]) {
                    anyMatch = true;
                    break;
                }
            }
            if (!anyMatch) {
                Assert.fail("No Matching Diagnostic at [" + (pos[0] + 2) + "," + (pos[1] + 1) + "]");
            }
        }
    }

    public void compileService(Example.Service service) throws IOException, InterruptedException {
        final CompilerUtils.BuildResult buildResult = CompilerUtils.build(service.path);
        service.buildResult = buildResult;
        if (buildResult.status != CompilerUtils.BuildStatus.SUCCESS) {
            Assert.fail(service + " [" + buildResult.status + "] - " + buildResult.errorOut);
        }

        final CompilerUtils.BuildResult buildTestResult = CompilerUtils.build(service.test);
        service.testBuildResult = buildTestResult;
        if (buildTestResult.status != CompilerUtils.BuildStatus.SUCCESS) {
            Assert.fail(service + "-test [" + buildTestResult.status + "] - " + buildTestResult.errorOut);
        }
    }

    public void testService(Example.Service service) throws IOException, InterruptedException {

        final Process srvProcess = CompilerUtils.runAsync(service.buildResult);
        final String testResult = CompilerUtils.run(service.testBuildResult);
        CompilerUtils.killProcess(srvProcess);
        checkDifference(testResult, "Done\n");
    }

    private void checkDifference(String actual, String expected) {
        if ((actual == null && expected == null) || (expected != null && expected.equals(actual))) {
            return;
        }
        Assert.fail(String.format("Output diff. Expected [[\n%s]] Actual [[\n%s]]", expected, actual));
    }

    private void parseBalFileErrors(Example.Error err) throws FileNotFoundException {
        final File outFile = err.path.toFile();
        int lineNumber = -1; // Line numbers are zero based
        try (Scanner reader = new Scanner(outFile)) {
            while (reader.hasNextLine()) {
                lineNumber++;
                final String line = reader.nextLine();
                if (line.trim().startsWith("//") && line.contains("Error")) {
                    err.errorCount += 1;
                    if (!line.contains("//~")) {    // Ignore Token
                        int column = line.indexOf("^");
                        err.errorPos.add(new int[]{lineNumber - 1, column}); // -1 because comments are in next line
                    }
                }
            }
        }
    }
}
