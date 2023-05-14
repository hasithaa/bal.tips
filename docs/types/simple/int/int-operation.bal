import ballerina/io;

public function main() {
    int x = 5;
    int y = 10;

    string output = string `Unary, Arithmetic, Relational, and Bitwise Operations:
    +x: ${+x}
    -x: ${-x}
    ~x: ${~x}
    x * y: ${x * y}
    x / y: ${x / y}
    x % y: ${x % y}
    x + y: ${x + y}
    x - y: ${x - y}
    x < y: ${x < y}
    x <= y: ${x <= y}
    x > y: ${x > y}
    x >= y: ${x >= y}
    x == y: ${x == y}
    x != y: ${x != y}
    x === y: ${x === y}
    x !== y: ${x !== y}
    x << y: ${x << y}
    x >> y: ${x >> y}
    x >>> y: ${x >>> y}
    x & y: ${x & y}
    x ^ y: ${x ^ y}
    x | y: ${x | y}
    `;
    io:println(output);

    output = string `Type Cast Expressions:
    <float> a: ${<float>x}
    <decimal> a: ${<decimal>x}
    `;

    var range = x ... y;
    io:println("Range Expressions:");
    foreach int val in range {
        io:println(string `    Integer Range Value: ${val}`);
    }
}
