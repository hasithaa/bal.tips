import ballerina/io;

public function main() returns error? {

    boolean t1 = check boolean:fromString("true");
    boolean t2 = check boolean:fromString("1");
    boolean t3 = check boolean:fromString("True");
    boolean t4 = check boolean:fromString("TruE");
    boolean t5 = check boolean:fromString("TRUE");

    boolean f1 = check boolean:fromString("false");
    boolean f2 = check boolean:fromString("0");
    boolean f3 = check boolean:fromString("False");
    boolean f4 = check boolean:fromString("FalSe");
    boolean f5 = check boolean:fromString("FALSE");

    boolean|error e1 = boolean:fromString("abc");
    boolean|error e2 = boolean:fromString("123");

    io:println("t1:", t1); //!
    io:println("t2:", t2); //!
    io:println("t3:", t3); //!
    io:println("t4:", t4); //!
    io:println("t5:", t5); //!
    io:println("f1:", f1); //!
    io:println("f2:", f2); //!
    io:println("f3:", f3); //!
    io:println("f4:", f4); //!
    io:println("f5:", f5); //!
    io:println("e1:", e1); //!
    io:println("e2:", e2); //!
}
