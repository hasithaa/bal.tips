import ballerina/io;

public function main() {
    int[] numbers = [1, 2, 3, 4, 5];

    io:println("Numbers: ", numbers);
    numbers.push(6, 7);
    io:println("Numbers After Push: ", numbers);

    int last = numbers.pop();
    io:println("Numbers After Pop: ", numbers);
    io:println("Last: ", last);

    int first = numbers.shift();
    io:println("Numbers After Shift: ", numbers);
    io:println("First: ", first);

    numbers.unshift(-1, 0);
    io:println("Numbers After Unshift: ", numbers);
}
// Auto generated file from index.md, do not modify!
