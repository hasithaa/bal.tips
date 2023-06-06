import ballerina/io;

public function main() {

    string tab = "tab :A\u{9}B";
    string newline = "newline :A\u{A}B";
    string carriageReturn = "carriageReturn :A\u{D}B";
    string backSlash = "backSlash :A\u{5C}B";
    string doubleQuote = "doubleQuote :A\u{22}B";

    io:println(tab);
    io:println(newline);
    io:println(carriageReturn);
    io:println(backSlash);
    io:println(doubleQuote);
}
// Auto generated file from index.md, do not modify!
