// Auto generated file from index.md, do not modify!
import ballerina/io;

public function main() {

    string name = "";
    int age = 30;
    object:RawTemplate tmp = `My name is ${name}. My age is ${age}.`;

    io:println(tmp.strings);
    io:println(tmp.insertions);
}
