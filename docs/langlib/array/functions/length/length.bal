import ballerina/io;

public function main() {
    // Array of strings
    string[] names = ["Alice", "Bob", "Charlie"];
    io:println("Length of names: ", names.length());

    // Tuple value
    [int, string] person = [25, "Alice"];
    io:println("Length of person: ", person.length());

    // Fixed length array
    int[3] ages = [25, 30, 35];
    io:println("Length of numbers: ", ages.length());

    // List of List
    [int, string][] people = [[25, "Alice"], [30, "Bob"], [35, "Charlie"]];
    io:println("Length of people: ", people.length());
    io:println("Length of person tuple: ", people[2].length());
}
