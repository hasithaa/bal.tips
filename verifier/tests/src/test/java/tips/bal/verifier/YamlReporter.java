/*
 * MIT License
 *
 * Copyright (c) 2022 Hasitha Aravinda. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package tips.bal.verifier;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.SimpleTimeZone;

import static tips.bal.verifier.CompilerUtils.balVersion;
import static tips.bal.verifier.Consts.DIR_EXAMPLES;

/**
 * Yaml test report generator.
 *
 * @since 1.0.0
 */
public class YamlReporter extends TestListenerAdapter {

    final LinkedHashMap<String, ExampleTest> tests;

    public YamlReporter() {
        tests = new LinkedHashMap<>();
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        transformTestResult(tr, "Passed");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        transformTestResult(tr, "Failed");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        transformTestResult(tr, "Skipped");
    }

    @Override
    public void onFinish(ITestContext testContext) {
        TestResult result = new TestResult();
        result.pass = testContext.getPassedTests().size();
        result.fail = testContext.getFailedTests().size();
        result.skip = testContext.getSkippedTests().size();
        result.tests = tests;

        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.setTimeZone(new SimpleTimeZone(0, "GMT"));
        sdf.applyPattern("dd MMM yyyy HH:mm:ss z");

        result.startAt = sdf.format(testContext.getStartDate());
        result.endAt = sdf.format(testContext.getEndDate());
        try {
            result.balVersion = balVersion();
            result.balVersion = result.balVersion.substring(0, result.balVersion.indexOf("\n"));
        } catch (IOException | InterruptedException e) {
            throw new IllegalStateException(e);
        }
        result.os = Consts.ENV_OS_NAME;
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        try {
            om.writeValue(Consts.PATH_TEST_YAML.toFile(), result);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private void transformTestResult(ITestResult result, String status) {
        if (result.getParameters().length == 0 || !(result.getParameters()[0] instanceof Example)) {
            return;
        }
        final Example example = (Example) result.getParameters()[0];
        final String path = example.path.normalize().toString();

        final ExampleTest exampleTest = new ExampleTest();
        exampleTest.name = example.path.getFileName().toString();
        exampleTest.path = path.substring(path.lastIndexOf(DIR_EXAMPLES)).replace("\\", "/");
        exampleTest.kind = example.kind.name();
        exampleTest.status = status;
        exampleTest.time = result.getEndMillis() - result.getStartMillis();
        exampleTest.data = String.valueOf(result.getThrowable());
        tests.put(exampleTest.path, exampleTest);
    }

    public static class TestResult {

        public int pass = 0;
        public int fail = 0;
        public int skip = 0;
        public String startAt;
        public String endAt;
        public String balVersion;
        public String os;
        public LinkedHashMap<String, ExampleTest> tests;

        public TestResult() {
        }
    }

    public static class ExampleTest {
        public String name;
        public String path;
        public String kind;
        public String status;
        public String data;
        public long time;

        public ExampleTest() {
        }
    }
}
