import ballerina/io;

public function main() returns error? {

    string s = true.toString(); //$
    boolean t1 = check boolean:fromString("true"); //$
    boolean f1 = check boolean:fromString("false"); //$

    io:println("s :", s);  //!
    io:println("t1:", t1); //!
    io:println("f1:", f1); //!
}
