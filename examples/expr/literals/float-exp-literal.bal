import ballerina/io;

public function main() {
    float f1 = 12e4; // 120000.0
    float f2 = 543e-5; // 0.00543
    float f3 = 1.23e3; // 1230.0
    float f4 = 1.23e3f; // 1230.0

    decimal d1 = 12e4; // 120000.0
    decimal d2 = 543e-5; // 0.00543
    decimal d3 = 1.23e3; // 1230.0
    decimal d4 = 1.23e3d; // 1230.0

    io:println(f1);
    io:println(f2);
    io:println(f3);
    io:println(f4);
    io:println(d1);
    io:println(d2);
    io:println(d3);
    io:println(d4);
}
