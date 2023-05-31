// Auto generated file from index.md, do not modify!
import ballerina/io;

public function main() returns error? {

    string ts = 19467.toString();
    int fs = check int:fromString(ts);

    string hex = 19467.toHexString();
    int fhs = check int:fromHexString(hex);

    io:println(ts);
    io:println(fs);
    io:println(hex);
    io:println(fhs);
}
