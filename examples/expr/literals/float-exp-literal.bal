import ballerina/io;

public function main() {
    float f1 = 12e4; // 120000.0
    float f2 = 543e-5; // 0.00543
    float f3 = 1.23e3; // 1230.0
    float f4 = 1.23e3f; // 1230.0

    io:println(f1);
    io:println(f2);
    io:println(f3);
    io:println(f4);
}
