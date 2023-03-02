import ballerina/io;

public function main() {

    byte[] a = base64 `AAAB`;
    byte[] b = base64 `ABB=`;
    byte[] c = base64 `BC==`;
    byte[] d = base64 `ABCD pqrs
                     5678 +/12`;

    io:println(a);  //!
    io:println(b);  //!
    io:println(c);  //!
    io:println(d);  //!
}
