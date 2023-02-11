import ballerina/io;

const int TEN = 10;

public function main() {

    var a1 = 10;
    TEN a2 = 10;
    float a3 = 10;
    decimal a4 = 10;
    float|decimal a5 = 10;
    var a6 = 10.0;

    io:println(a1 is int);
    io:println(a2 is TEN);
    io:println(a3);
    io:println(a4);
    io:println(a5 is float);
    io:println(a6 is float);
}
