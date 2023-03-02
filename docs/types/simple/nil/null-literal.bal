import ballerina/io;

public function main() {

    () b = null; //$
    null c = null; // Also valid
    io:println("a:", b);
    io:println("b:", c);

    // Using JSON value as expr
    json tom = {"name": "tom", "job": null}; //$

    json bob = {"name": "bob", "job": ()};

    io:println("person:", tom);
    io:println("person:", bob);
}
