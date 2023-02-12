import ballerina/io;

public function main() {
    int i = 10;
    float floatValue = 2.1;
    decimal decimalValue = 5.0;

    int v1 = <int>floatValue; //$
    int v2 = <int>decimalValue;
    float v3 = <float>i;
    decimal v4 = <decimal>i;

    io:println("v1:", v1);  //!
    io:println("v2:", v2);  //!
    io:println("v3:", v3);  //!
    io:println("v4:", v4);  //!
}
