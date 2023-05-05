import ballerina/io;

public function main() returns error? {

    boolean fromStringTrue = check boolean:fromString("TRUE");
    boolean fromStringFalse = check boolean:fromString("FALSE");

    string output = string `Boolean Lang Library Functions:
    fromString("TRUE"): ${fromStringTrue}
    fromString("FALSE"): ${fromStringFalse}
    `;
    io:println(output);
}
