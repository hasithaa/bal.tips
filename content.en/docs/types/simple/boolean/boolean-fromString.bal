import ballerina/io;

public function main() returns error? {

    boolean fromStringTrue = check boolean:fromString("true");
    boolean fromStringFalse = check boolean:fromString("false");

    string output = string `Boolean fromString:
    True: ${fromStringTrue}
    False: ${fromStringFalse} 
    `;
    io:println(output);
}
