/*
 * MIT License
 *
 * Copyright (c) 2022 Hasitha Aravinda. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package tips.bal.verifier;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import static tips.bal.verifier.Consts.PATH_BAL_TIP;

/**
 * Load Ballerina Examples from content directory
 *
 * @since 1.0.0
 */
public class ExampleLoader {

    public static ArrayList<Path> loadExamples() throws IOException {

        ArrayList<Path> examples = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(PATH_BAL_TIP)) {
            paths.filter(Files::isRegularFile).forEach(examples::add);
        }
        return examples;
    }

    public static ArrayList<Example> filterBalFiles(ArrayList<Path> examples) {
        ArrayList<Example> examplesList = new ArrayList<>();

        for (Path path : examples) {
            final String fileName = path.getFileName().toString();
            if (!fileName.endsWith(".bal")) {
                continue;
            } else if (fileName.endsWith("-error.bal")) {
                final Example.Error err = new Example.Error(path);
                examplesList.add(err);
            } else if (fileName.endsWith("service-test.bal")) {
                continue;
            } else if (fileName.endsWith("service.bal")) {
                final Example.Service service = new Example.Service(path);
                service.test = path.resolve(Paths.get(path.toString().replace("service.bal", "service-test.bal")));
                examplesList.add(service);
            } else if (fileName.endsWith(".bal")) {
                final Example.Output output = new Example.Output(path);
                output.output = path.resolve(Paths.get(path.toString().replace(".bal", ".out")));
                examplesList.add(output);
            }
        }
        return examplesList;
    }

    public static String readTxtFile(Path txtFilePath) throws IOException {
        final File txtFile = txtFilePath.toFile();
        if (!txtFile.exists()) {
            return null;
        }
        StringBuilder txtBuilder = new StringBuilder();
        try (Scanner reader = new Scanner(txtFile)) {
            while (reader.hasNextLine()) {
                txtBuilder.append(reader.nextLine()).append("\n");
            }
        }
        return txtBuilder.toString();
    }
}
