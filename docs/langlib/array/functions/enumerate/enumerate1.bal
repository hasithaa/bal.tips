import ballerina/io;

public function main() {

    string[] names = ["Alice", "Bob", "Charlie"];

    [int, string][] pairs = names.enumerate();

    foreach [int, string] pair in pairs {
        io:println(pair[0], ":", pair[1]);
    }
}
