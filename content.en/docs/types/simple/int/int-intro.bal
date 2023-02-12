import ballerina/io;

public function main() {
    int i1 = 10; //$
    int i2 = -5; //$

    int i3 = i1 + i2; //$

    int i4 = int:MAX_VALUE; //$
    int i5 = int:MIN_VALUE; //$

    io:println("i1:", i1);  //!
    io:println("i2:", i2);  //!
    io:println("i3:", i3);  //!
    io:println("i4:", i4);  //!
    io:println("i5:", i5);  //!
}
