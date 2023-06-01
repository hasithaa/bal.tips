// Auto generated file from index.md, do not modify!
import ballerina/io;

public function main() {
    string s1 = string `\\ \n \t`;
    string s2 = string `backtick - ${"`"}`;

    int value = 100;
    string s3 = string `Price $${value}`;

    io:println(s1);
    io:println(s2);
    io:println(s3);
}
