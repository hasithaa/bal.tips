// Auto generated file from index.md, do not modify!
import ballerina/io;

public function main() {

    float x = 5.5;
    float y = -10.0;

    float maxVal = float:max(x, y);
    float minVal = float:min(x, y);
    float absY = y.abs();
    float roundVal = x.round();

    string output = string `ballerina/lang.float Functions:
    x: ${x}
    y: ${y}
    max(x, y): ${maxVal}
    min(x, y): ${minVal}
    abs(y): ${absY}
    round(x): ${roundVal}
    `;
    io:println(output);
}
