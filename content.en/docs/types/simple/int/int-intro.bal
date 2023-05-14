import ballerina/io;

public function main() {
    int positiveInt = 10;
    int negativeInt = -5;

    int sum = positiveInt + negativeInt;

    int maxValue = int:MAX_VALUE;
    int minValue = int:MIN_VALUE;

    io:println("Positive integer:", positiveInt); //!
    io:println("Negative integer:", negativeInt); //!
    io:println("Sum of integers:", sum); //!
    io:println("Max integer value:", maxValue); //!
    io:println("Min integer value:", minValue); //!
}
