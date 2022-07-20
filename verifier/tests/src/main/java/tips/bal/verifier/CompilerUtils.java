/*
 * MIT License
 *
 * Copyright (c) 2022 Hasitha Aravinda. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package tips.bal.verifier;

import io.ballerina.projects.Project;
import io.ballerina.projects.ProjectEnvironmentBuilder;
import io.ballerina.projects.directory.ProjectLoader;
import io.ballerina.projects.environment.Environment;
import io.ballerina.projects.environment.EnvironmentBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static tips.bal.verifier.Consts.BALLERINA_HOME;
import static tips.bal.verifier.Consts.DIR_BAL_BUILD;
import static tips.bal.verifier.Consts.DIR_DISTRO;
import static tips.bal.verifier.Consts.DIR_EXAMPLES;
import static tips.bal.verifier.Consts.DOT_BAL;
import static tips.bal.verifier.Consts.DOT_JAR;
import static tips.bal.verifier.Consts.USER_DIR;

/**
 * Util Class to compile Ballerina source.
 * <p>
 * This will be used to verify error cases.
 *
 * @since 1.0.0
 */
public class CompilerUtils {

    public static Project compile(Path sourcePath) {
        return compile(sourcePath, getActiveDistribution());
    }

    public static Project compile(Path sourcePath, Path balHome) {

        Environment env = EnvironmentBuilder.getBuilder().setBallerinaHome(balHome).build();
        ProjectEnvironmentBuilder projEnvBuilder = ProjectEnvironmentBuilder.getBuilder(env);
        return ProjectLoader.loadProject(sourcePath, projEnvBuilder);
    }

    public static Path getActiveDistribution() {

        return getActiveDistribution(Paths.get((new File(System.getenv(BALLERINA_HOME))).toURI()));
    }

    public static Path getActiveDistribution(Path ballerinaHome) {

        final File dirBRE = ballerinaHome.resolve(Consts.DIR_BRE).toFile();
        if (dirBRE.isDirectory()) {
            return ballerinaHome;
        }

        final File dirDistro = ballerinaHome.resolve(DIR_DISTRO).toFile();
        if (!dirDistro.isDirectory()) {
            throw new IllegalArgumentException("Invalid Ballerina Home");
        }

        File balVersionFile = ballerinaHome.resolve(Paths.get(DIR_DISTRO, Consts.BALLERINA_VERSION)).toFile();
        if (!balVersionFile.exists()) {
            throw new IllegalStateException("No ballerina-version file found");
        }
        // Read current distribution
        StringBuilder sb = new StringBuilder();
        try (Scanner reader = new Scanner(balVersionFile)) {
            while (reader.hasNextLine()) {
                sb.append(reader.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) { // Ignore
        }

        String version = sb.toString().trim();
        final Path distro = ballerinaHome.resolve(Paths.get(DIR_DISTRO, version)).toAbsolutePath();
        if (distro.toFile().isDirectory()) {
            return distro;
        }
        throw new IllegalStateException("Can't find Ballerina Distribution");
    }

    /**
     * Represents result of the build command.
     *
     * @since 1.0.0
     */
    public static class BuildResult {
        public final BuildStatus status;
        public final String errorOut;
        public final Path jarFilePath;

        public BuildResult(BuildStatus status, String errorOut, Path jarFilePath) {
            this.status = status;
            this.errorOut = errorOut;
            this.jarFilePath = jarFilePath;
        }
    }

    /**
     * Represent build status.
     *
     * @since 1.0.0
     */
    public enum BuildStatus {
        SUCCESS, // Compilation success
        ERROR,  // Compilation contains errors
        FAILED, // Build crashed
        INVALID // Example broken
    }

    public static BuildResult build(Path sourcePath) throws IOException, InterruptedException {

        final BuildResult buildResult;
        String sourcePathStr = sourcePath.toString();
        String relSourcePath = sourcePathStr.substring(sourcePathStr.indexOf(DIR_EXAMPLES));
        Path jarFilePath = Path.of(System.getProperty(USER_DIR)).resolve(DIR_BAL_BUILD).toAbsolutePath().normalize()
                .resolve(Paths.get(relSourcePath.replace(DOT_BAL, DOT_JAR)));
        if (!sourcePath.toFile().exists()) {
            buildResult = new BuildResult(BuildStatus.INVALID, null, jarFilePath);
            return buildResult;
        }

        final ProcessBuilder balCommandBuilder = getBalCommandBuilder(sourcePath.getParent(),
                "bal", "build", "-o", jarFilePath.toString(), sourcePath.toString());
        Process buildCmd = balCommandBuilder.start();
        boolean waitFor = buildCmd.waitFor(1, TimeUnit.MINUTES);


        // Check for build failures
        if (!waitFor || buildCmd.exitValue() != 0 && !jarFilePath.toFile().exists()) {
            StringBuilder sb = new StringBuilder();
            try (BufferedReader errorReader = new BufferedReader(new InputStreamReader(buildCmd.getErrorStream()))) {
                String string;
                while ((string = errorReader.readLine()) != null) {
                    sb.append(string).append("\n");
                }
            }
            buildResult = new BuildResult(BuildStatus.ERROR, sb.toString(), jarFilePath);
        } else {
            buildResult = new BuildResult(jarFilePath.toFile().exists() ? BuildStatus.SUCCESS : BuildStatus.FAILED,
                    null, jarFilePath);
        }
        buildCmd.destroy();
        return buildResult;
    }

    public static String run(BuildResult buildResult) throws IOException, InterruptedException {

        return run(buildResult, 10, TimeUnit.SECONDS);
    }

    public static String run(BuildResult buildResult, int timeOut, TimeUnit unit)
            throws IOException, InterruptedException {

        final ProcessBuilder balCommandBuilder = getBalCommandBuilder(buildResult.jarFilePath.getParent(),
                "bal", "run", buildResult.jarFilePath.toString());
        Process runCmd = balCommandBuilder.start();
        runCmd.waitFor(timeOut, unit);

        StringBuilder runOutputSB = new StringBuilder();
        try (BufferedReader outReader = new BufferedReader(new InputStreamReader(runCmd.getInputStream()))) {
            String string;
            while ((string = outReader.readLine()) != null) {
                runOutputSB.append(string).append("\n");
            }
        }
        runCmd.destroy();
        return runOutputSB.toString();
    }

    public static String balVersion() throws IOException, InterruptedException {

        final ProcessBuilder balCommandBuilder = getBalCommandBuilder(
                Path.of(System.getProperty(USER_DIR)).resolve(DIR_BAL_BUILD).toAbsolutePath().normalize(),
                "bal", "version");
        Process runCmd = balCommandBuilder.start();
        runCmd.waitFor(10, TimeUnit.SECONDS);

        StringBuilder runOutputSB = new StringBuilder();
        try (BufferedReader outReader = new BufferedReader(
                new InputStreamReader(runCmd.getInputStream()))) {
            String string;
            while ((string = outReader.readLine()) != null) {
                runOutputSB.append(string).append("\n");
            }
        }
        runCmd.destroy();
        return runOutputSB.toString();
    }

    public static Process runAsync(BuildResult buildResult) throws IOException {
        final ProcessBuilder builder = getBalCommandBuilder(buildResult.jarFilePath.getParent(),
                "bal", "run", buildResult.jarFilePath.toString());
        return builder.start();
    }

    public static void killProcess(Process process) {
        process.destroyForcibly();
    }

    private static ProcessBuilder getBalCommandBuilder(Path dir, String... cmd) {
        final String os = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        ArrayList<String> balCommand = new ArrayList<>();
        ProcessBuilder balCmdBuilder;
        if (os.contains("nux") || os.contains("mac") || os.contains("darwin")) {
            balCommand.addAll(Arrays.asList(cmd));
        } else if (os.contains("win")) {
            balCommand.add("cmd");
            balCommand.add("/c");
            balCommand.addAll(Arrays.asList(cmd));
        } else {
            throw new IllegalStateException("Not supported OS.");
        }
        balCmdBuilder = new ProcessBuilder(balCommand);
        balCmdBuilder.directory(dir.toFile());
        return balCmdBuilder;
    }
}
