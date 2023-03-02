import ballerina/io;

public function main() {

    [int, string] person = [1, "John"];

    object {
        public isolated function next() returns record {|int|string value;|}?;
    } tupleIterator = person.iterator();

    record {|int|string value;|}? nextResult = tupleIterator.next();
    while (nextResult != null) {
        int|string value = nextResult.value;
        if value is int {
            io:println("Person ID: ", value);
        } else {
            io:println("Person Name: ", value);
        }
        nextResult = tupleIterator.next();
    }
}
