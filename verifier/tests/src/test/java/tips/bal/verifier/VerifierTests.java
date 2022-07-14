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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

import static tips.bal.verifier.ExampleLoader.filterBalFiles;
import static tips.bal.verifier.ExampleLoader.loadExamples;
import static tips.bal.verifier.ExampleLoader.readTxtFile;

/**
 * Test cases validating ballerina source files.
 *
 * @since 1.0.0
 */
public class VerifierTests {

    @DataProvider(parallel = true)
    public Object[] validateOutputProvider() throws IOException {

        return filterBalFiles(loadExamples()).toArray();
    }

    @Test(groups = "output", dataProvider = "validateOutputProvider")
    public void verifyOutput(Example example) throws IOException, InterruptedException {
        switch (example.kind) {
            case Output:
                testOutput((Example.Output) example);
                break;
            case Error:
                testError((Example.Error) example);
                break;
            case Service:
                testService((Example.Service) example);
                break;
        }
    }

    public void testOutput(Example.Output example) throws IOException, InterruptedException {

        final CompilerUtils.BuildResult buildResult = CompilerUtils.build(example.path);
        if (buildResult.status != CompilerUtils.BuildStatus.SUCCESS) {
            Assert.fail(buildResult.status + " - " + buildResult.errorOut);
        }
        final String actual = CompilerUtils.run(buildResult);
        final String expected = readTxtFile(example.output);
        checkDifference(actual, expected);
    }

    public void testError(Example.Error example) throws IOException {

        final Project project = CompilerUtils.compile(example.path);
        final PackageCompilation compilation = project.currentPackage().getCompilation();
        parseBalFileErrors(example);
        final DiagnosticResult diagnosticResult = compilation.diagnosticResult();
        if (diagnosticResult.errorCount() <= 0) {
            Assert.fail("No Compilation errors found");
        }
        if (diagnosticResult.errorCount() < example.errorCount) {
            Assert.fail(String.format("Too many errors, found %1, expected %2",
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

    public void testService(Example.Service service) throws IOException, InterruptedException {

        final CompilerUtils.BuildResult buildResult = CompilerUtils.build(service.path);
        if (buildResult.status != CompilerUtils.BuildStatus.SUCCESS) {
            Assert.fail(service + " [" + buildResult.status + "] - " + buildResult.errorOut);
        }

        final CompilerUtils.BuildResult buildTestResult = CompilerUtils.build(service.test);
        if (buildTestResult.status != CompilerUtils.BuildStatus.SUCCESS) {
            Assert.fail(service + "-test [" + buildTestResult.status + "] - " + buildTestResult.errorOut);
        }

        final CompletableFuture<CompilerUtils.RunAsyncResult> async = CompilerUtils.runAsync(buildResult);
        final String testResult = CompilerUtils.run(buildTestResult);
        async.complete(new CompilerUtils.RunAsyncResult());
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
