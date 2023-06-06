import ballerina/io;

const int TEN = 10;

public function main() {

    int a1 = 10;
    float a2 = 10;
    decimal a3 = 10;

    TEN a4 = 10;
    float|decimal a5 = 10; // float

    var a6 = 10; // int
    var a7 = 10.0; // float

    io:println(a1 is int);
    io:println(a2 is float);
    io:println(a3 is decimal);
    io:println(a4 is TEN);
    io:println(a5 is float);
    io:println(a6 is int);
    io:println(a7 is float);
}
// Auto generated file from index.md, do not modify!
