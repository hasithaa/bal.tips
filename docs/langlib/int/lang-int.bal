import ballerina/io;

public function main() returns error? {

    int sum = int:sum(1, -2, 3, -4, 5);
    int max = int:max(1, -2, 3, -4, 5);
    int min = int:min(1, -2, 3, -4, 5); //$
    int abs = min.abs(); //$
    int fs = check int:fromString("123");
    int fhs = check int:fromHexString("1A");

    string hs = int:toHexString(26);
    string s = sum.toString();

    io:println("sum:", sum); //!
    io:println("max:", max); //!
    io:println("min:", min); //!
    io:println("abs:", abs); //!
    io:println("fs :", fs); //!
    io:println("fhs:", fhs); //!
    io:println("hs :", hs); //!
    io:println("s  :", s); //!
}
