/*
 * MIT License
 *
 * Copyright (c) 2022 Hasitha Aravinda. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package tips.bal.verifier;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an example.
 *
 * @since 2.0.0
 */
public class Example {
    public Path path;
    public Kind kind;

    private Example() {
    }

    @Override
    public String toString() {
        return String.valueOf(path);
    }

    /**
     * Represents an output example.
     *
     * @since 1.0.0
     */
    public static class Output extends Example {
        public Path output;

        private Output() {
        }

        Output(Path path) {
            this.kind = Kind.Output;
            this.path = path;
        }
    }

    /**
     * Represents an error example.
     *
     * @since 1.0.0
     */
    public static class Error extends Example {
        public List<int[]> errorPos = new ArrayList<>();
        public int errorCount;

        private Error() {
        }

        Error(Path path) {
            this.kind = Kind.Error;
            this.path = path;
        }
    }

    /**
     * Represents a service example.
     *
     * @since 1.0.0
     */
    public static class Service extends Example {
        public Path test;

        private Service() {
        }

        Service(Path path) {
            this.kind = Kind.Service;
            this.path = path;
        }
    }

    enum Kind {
        Output,
        Error,
        Service,
    }
}
