/*
 * MIT License
 *
 * Copyright (c) 2022 Hasitha Aravinda. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package tips.bal.verifier;

import tips.bal.verifier.validators.ErrorValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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

    public static LinkedHashMap<Example.Kind, ArrayList<? extends Example>> filterBalFiles(ArrayList<Path> examples) {
        LinkedHashMap<Example.Kind, ArrayList<? extends Example>> result = new LinkedHashMap<>();
        ArrayList<Example.Output> outputs = new ArrayList<>();
        ArrayList<Example.Error> errors = new ArrayList<>();
        ArrayList<Example.Service> services = new ArrayList<>();

        result.put(Example.Kind.Output, outputs);
        result.put(Example.Kind.Error, errors);
        result.put(Example.Kind.Service, services);

        for (Path path : examples) {
            final String fileName = path.getFileName().toString();
            if (!fileName.endsWith(".bal")) {
                continue;
            }
            if (fileName.endsWith("-error.bal")) {
                final Example.Error err = new Example.Error(path);
                errors.add(err);
                ErrorValidator.parseErrorBalFile(err);
            } else if (fileName.endsWith("service.bal")) {
                services.add(new Example.Service(path));
            } else if (fileName.endsWith(".bal")) {
                final Example.Output output = new Example.Output(path);
                output.output = path.resolve(Paths.get(path.toString().replace(".bal", ".out")));
                outputs.add(output);
            }
        }
        return result;
    }
}
