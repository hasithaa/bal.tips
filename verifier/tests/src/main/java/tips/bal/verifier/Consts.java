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
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Consts.
 *
 * @since 1.0.0
 */
public abstract class Consts {

    public static final String DOT_BAL = ".bal";
    public static final String DOT_JAR = ".jar";
    public static final String BALLERINA_VERSION = "ballerina-version";
    public static final String BALLERINA_HOME = "BALLERINA_HOME";
    public static final String USER_DIR = "user.dir";
    public static final String OS_NAME = "os.name";

    public static final String DIR_EXAMPLES = "examples";
    public static final String DIR_DISTRO = "distributions";
    public static final String DIR_BRE = "bre";
    public static final String DIR_CONTENT = "content";
    public static final String DIR_BAL_TIP = "../../" + DIR_CONTENT + "/";
    public static final String DIR_BAL_BUILD = "build/jars/";
    public static final String TESTS_YAML = "../../data/tests.yaml";

    public static final String ENV_BALLERINA_HOME = System.getenv(BALLERINA_HOME);
    public static final String ENV_USER_DIR = System.getProperty(USER_DIR);
    public static final String ENV_OS_NAME = System.getProperty(OS_NAME, "generic");

    public static final Path PATH_BAL_HOME = Paths.get((new File(ENV_BALLERINA_HOME)).toURI()).toAbsolutePath().normalize();
    public static final Path PATH_BAL_TIP = Path.of(ENV_USER_DIR).resolve(DIR_BAL_TIP).toAbsolutePath().normalize();
    public static final Path PATH_BAL_BUILD = Path.of(ENV_USER_DIR).resolve(DIR_BAL_BUILD).toAbsolutePath().normalize();
    public static final Path PATH_TEST_YAML = Path.of(ENV_USER_DIR).resolve(Consts.TESTS_YAML);

}
