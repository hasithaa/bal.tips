// Auto generated file from index.md, do not modify!
import ballerina/io;

public function main() {

    float x = 5.5;
    float y = 10.0;

    string output = string `Unary, Arithmetic, and Relational Operations:
    +x: ${+x}
    -x: ${-x}
    x + y: ${x + y}
    x - y: ${x - y}
    x * y: ${x * y}
    x / y: ${x / y}
    x % y: ${x % y}
    x < y: ${x < y}
    x <= y: ${x <= y}
    x > y: ${x > y}
    x >= y: ${x >= y}
    x == y: ${x == y}
    x != y: ${x != y}
    `;
    io:println(output);

    output = string `Type Cast Expressions:
    int(a): ${<int>x}
    decimal(a): ${<decimal>x}
    `;
    io:println(output);
}
