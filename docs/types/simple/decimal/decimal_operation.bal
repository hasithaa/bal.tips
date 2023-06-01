// Auto generated file from index.md, do not modify!
import ballerina/io;

public function main() {

    decimal x = 5.5;
    decimal y = 10.0;

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
    float(a): ${<float>x}
    `;
    io:println(output);
}
