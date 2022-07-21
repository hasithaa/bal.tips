import ballerina/io;

public function main() {
    decimal f1 = 12.345;
    decimal f2 = -5.678;
    decimal f3 = .5678;
    decimal f4 = 123.456d;
    decimal f5 = 567.8901D;
    decimal f6 = 505d;
    decimal f7 = 505.0d;

    io:println(f1);
    io:println(f2);
    io:println(f3);
    io:println(f4);
    io:println(f5);
    io:println(f6);
    io:println(f7);
}
