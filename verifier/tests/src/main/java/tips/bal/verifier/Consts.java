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

    static final String BALLERINA_VERSION = "ballerina-version";
    static final String BALLERINA_HOME = "BALLERINA_HOME";
    static final String USER_DIR = "user.dir";

    static final String DIR_DISTRO = "distributions";
    static final String DIR_BRE = "bre";
    static final String DIR_CONTENT = "content";
    static final String DIR_BAL_TIP = "../../" + DIR_CONTENT + "/";
    static final String DIR_BAL_BUILD = "build/jars/";

    static final String ENV_BALLERINA_HOME = System.getenv(BALLERINA_HOME);
    static final String ENV_USER_DIR = System.getProperty(USER_DIR);

    static final Path PATH_BAL_HOME = Paths.get((new File(ENV_BALLERINA_HOME)).toURI()).toAbsolutePath().normalize();
    static final Path PATH_BAL_TIP = Path.of(ENV_USER_DIR).resolve(DIR_BAL_TIP).toAbsolutePath().normalize();
    static final Path PATH_BAL_BUILD = Path.of(ENV_USER_DIR).resolve(DIR_BAL_BUILD).toAbsolutePath().normalize();
    static final String EXAMPLES = "examples";
    static final String DOT_BAL = ".bal";
    static final String DOT_JAR = ".jar";
}
