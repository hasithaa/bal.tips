import ballerina/io;

public function main() {
    decimal positiveDecimal = 10.5;
    decimal negativeDecimal = -5.25;

    decimal sum = positiveDecimal + negativeDecimal;
    decimal difference = positiveDecimal - negativeDecimal;
    decimal product = positiveDecimal * negativeDecimal;
    decimal quotient = positiveDecimal / negativeDecimal;

    io:println("Positive decimal:", positiveDecimal); //!
    io:println("Negative decimal:", negativeDecimal); //!
    io:println("Sum of decimals:", sum); //!
    io:println("Difference of decimals:", difference); //!
    io:println("Product of decimals:", product); //!
    io:println("Quotient of decimals:", quotient); //!
}
