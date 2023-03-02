import ballerina/io;

public function main() {

    string[] names = ["John", "Jane", "Joe"];

    object {
        public isolated function next() returns record {|string value;|}?;
    } arrayIterator = names.iterator();

    record {string value;}? next = arrayIterator.next();
    while (next != null) {
        string nextName = next.value;
        io:println("Name: ", nextName);
        next = arrayIterator.next();
    }
}
