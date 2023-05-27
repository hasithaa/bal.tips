// Auto generated file from index.md, do not modify!
import ballerina/io;
import ballerina/lang.array;

public function main() {
    int[] numbers = [5, -2, 9, 1, 0, 8];
    int length = numbers.length();
    int? index = array:indexOf(numbers, 9);
    int[] sortedNumbers = array:sort(numbers);

    io:println("length: ", length);
    io:println("index: ", index);
    io:println("sortedNumbers: ", sortedNumbers);
}
