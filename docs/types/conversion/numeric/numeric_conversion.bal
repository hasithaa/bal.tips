// Auto generated file from index.md, do not modify!
import ballerina/io;

public function main() {

    int intValue = 10;
    float floatValue = 2.1;
    decimal decimalValue = 5.0;

    int v1 = <int>floatValue;
    int v2 = <int>decimalValue;
    float v3 = <float>intValue;
    float v4 = <float>decimalValue;
    decimal v5 = <decimal>intValue;
    decimal v6 = <decimal>floatValue;

    io:println("v1:", v1);
    io:println("v2:", v2);
    io:println("v3:", v3);
    io:println("v4:", v4);
    io:println("v5:", v5);
    io:println("v6:", v6);
}
