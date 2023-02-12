import ballerina/io;

public function main() {
    float f1 = 12e4;
    float f2 = 543e-5;
    float f3 = 1.23e3;
    float f4 = 1.23e3f;
    decimal d1 = 12e4;
    decimal d2 = 543e-5;
    decimal d3 = 1.23e3;
    decimal d4 = 1.23e3d;

    io:println(f1); //!
    io:println(f2); //!
    io:println(f3); //!
    io:println(f4); //!
    io:println(d1); //!
    io:println(d2); //!
    io:println(d3); //!
    io:println(d4); //!
}
