import ballerina/io;

public function main() {
    int x = 5;
    int y = -10;

    int maxVal = int:max(x, y);
    int minVal = int:min(x, y);
    int absY = y.abs();

    string output = string `ballerina/lang.int Functions:
    x: ${x}
    y: ${y}
    max(x, y): ${maxVal}
    min(x, y): ${minVal}
    abs(y): ${absY}
    `;
    io:println(output);
}
