/*
 * MIT License
 *
 * Copyright (c) 2022 Hasitha Aravinda. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package tips.bal.verifier.validators;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Validate output of a example.
 *
 * @since 1.0.0
 */
public class OutputValidator {

    public static String readOutputFile(Path outFilePath) throws IOException {
        final File outFile = outFilePath.toFile();
        if (!outFile.exists()) {
            return null;
        }
        StringBuilder outTxtBuilder = new StringBuilder();
        try (Scanner reader = new Scanner(outFile)) {
            while (reader.hasNextLine()) {
                outTxtBuilder.append(reader.nextLine()).append("\n");
            }
        }
        return outTxtBuilder.toString();
    }

    public static String diff(String actual, String expected) {
        if ((actual == null && expected == null) || (expected != null && expected.equals(actual))) {
            return null;
        }
        return String.format("Output diff. Expected [[\n%s]] Actual [[\n%s]]", expected, actual);
    }
}
