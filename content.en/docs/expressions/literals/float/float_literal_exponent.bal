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
    float fh1 = 0x1.a2bp3;
    float fh2 = 0X1F3Dp3;
    float fh3 = 0xAB12CDP-3;

    io:println(f1);
    io:println(f2);
    io:println(f3);
    io:println(f4);
    io:println(d1);
    io:println(d2);
    io:println(d3);
    io:println(d4);
    io:println(fh1);
    io:println(fh2);
    io:println(fh3);
}
// Auto generated file from index.md, do not modify!
