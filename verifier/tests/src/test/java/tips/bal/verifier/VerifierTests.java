/*
 * MIT License
 *
 * Copyright (c) 2022 Hasitha Aravinda. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package tips.bal.verifier;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tips.bal.verifier.validators.OutputValidator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import static tips.bal.verifier.ExampleLoader.filterBalFiles;
import static tips.bal.verifier.ExampleLoader.loadExamples;

/**
 * Test cases validating ballerina source files.
 *
 * @since 1.0.0
 */
public class VerifierTests {

    LinkedHashMap<Example.Kind, ArrayList<? extends Example>> examples = null;

    @BeforeClass(groups = "output")
    public void setup() throws IOException {

        examples = filterBalFiles(loadExamples());
    }

    @Test(groups = "output", dataProvider = "validateOutputProvider")
    public void testOutput(Example.Output example) throws IOException, InterruptedException {

        final CompilerUtils.BuildResult buildResult = CompilerUtils.build(example.path);
        if (buildResult.status != CompilerUtils.BuildStatus.SUCCESS) {
            Assert.fail(buildResult.status + " - " + buildResult.errorOut);
        }
        final String actual = CompilerUtils.run(buildResult);
        final String expected = OutputValidator.readOutputFile(example.output);
        final String diff = OutputValidator.diff(actual, expected);
        if (diff != null) {
            Assert.fail(diff);
        }
    }

    @DataProvider(parallel = true)
    public Object[] validateOutputProvider() {

        final ArrayList<? extends Example> examples = this.examples.get(Example.Kind.Output);
        return examples.toArray();
    }
}
