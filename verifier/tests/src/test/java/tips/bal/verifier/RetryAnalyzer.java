/*
 * MIT License
 *
 * Copyright (c) 2022 Hasitha Aravinda. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package tips.bal.verifier;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * RetryAnalyzer for test cases.
 *
 * @since 2.0.0
 */
public class RetryAnalyzer implements IRetryAnalyzer {

    int counter = 0;
    final int retryLimit = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (counter < retryLimit) {
            counter++;
            return true;
        }
        return false;
    }
}
