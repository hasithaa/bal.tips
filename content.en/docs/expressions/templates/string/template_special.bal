import ballerina/io;

public function main() {
    string s1 = string `\\ \n \t`;
    string s2 = string `backtick - ${"`"}`;

    int value = 100;
    string s3 = string `Price $${value}`;

    string s4 = string `Some long text, but you need to break the source code ${""
    } into multiple lines without affecting the string value.`;

    io:println(s1);
    io:println(s2);
    io:println(s3);
    io:println(s4);
}
// Auto generated file from index.md, do not modify!
