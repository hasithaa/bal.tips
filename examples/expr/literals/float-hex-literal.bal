import ballerina/io;

public function main() {

    float f1 = 0x5.8; // 5.5
    float f2 = -0x5.8; // -5.5
    float f3 = 0x7b.74bc6a7ef9db22d; // 123.456
    float f4 = 0X7B.74BC6A7EF9DB22D; // 123.456
    float f5 = 0x1F9.A; // 505.625

    io:println(f1);
    io:println(f2);
    io:println(f3);
    io:println(f4);
    io:println(f5);
}
