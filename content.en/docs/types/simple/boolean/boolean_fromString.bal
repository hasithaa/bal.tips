// Auto generated file from index.md, do not modify!
import ballerina/io;

public function main() returns error? {

    boolean fromStringTrue = check boolean:fromString("true");
    boolean fromStringFalse = check boolean:fromString("false");

    io:println(string `Boolean fromString - True: ${fromStringTrue}, False: ${fromStringFalse}`);
}
