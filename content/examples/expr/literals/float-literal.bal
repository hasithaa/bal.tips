import ballerina/io;

public function main() {
    float f1 = 12.345;
    float f2 = -5.678;
    float f3 = .5678;

    float f4 = 123.456f;
    float f5 = 567.8901F;
    float f6 = 505f;

    io:println(f1);
    io:println(f2);
    io:println(f3);
    io:println(f4);
    io:println(f5);
    io:println(f6);
}
