import ballerina/io;

public function main() {
    float positiveFloat = 10.5;
    float negativeFloat = -5.25;

    float sum = positiveFloat + negativeFloat;

    float infinity = float:Infinity;
    float notANumber = float:NaN;

    io:println("Positive float:", positiveFloat); //!
    io:println("Negative float:", negativeFloat); //!
    io:println("Sum of floats:", sum); //!
    io:println("Infinity:", infinity); //!
    io:println("Not a number:", notANumber); //!
}
