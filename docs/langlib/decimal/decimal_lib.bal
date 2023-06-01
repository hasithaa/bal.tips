// Auto generated file from index.md, do not modify!
import ballerina/io;

public function main() {

    decimal x = 5.5;
    decimal y = -10.0;

    decimal maxVal = decimal:max(x, y);
    decimal minVal = decimal:min(x, y);
    decimal absY = y.abs();
    decimal roundVal = x.round();

    string output = string `ballerina/lang.decimal Functions:
    x: ${x}
    y: ${y}
    max(x, y): ${maxVal}
    min(x, y): ${minVal}
    abs(y): ${absY}
    round(x): ${roundVal}
    `;
    io:println(output);
}
