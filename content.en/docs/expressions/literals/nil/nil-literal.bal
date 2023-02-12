import ballerina/io;

public function main() {

    () a = ();
    () b = null;

    io:println("a:", a); //!
    io:println("b:", b); //!
}