import ballerina/io;

public function main() {

    boolean trueValue = true;
    boolean falseValue = false;
    string trueString = trueValue.toString();
    string falseString = falseValue.toString();
    string trueJsonString = trueValue.toJsonString();
    string falseJsonString = falseValue.toJsonString();

    string output = string `ToString Behavior:
    True to String: ${trueString}
    False to String: ${falseString}
    True to Json String: ${trueJsonString}
    False to Json String: ${falseJsonString}
    `;
    io:println(output);
}
// Auto generated file from index.md, do not modify!
