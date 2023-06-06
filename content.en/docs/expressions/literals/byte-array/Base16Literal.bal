import ballerina/io;

public function main() {

    byte[] a = base16 `11AB22CD`;
    byte[] b = base16 `c3 d4 e5 f6`;
    byte[] c = base16 ` 55 EE 66 FF
                      77 AB 88 CD
                      99 EF 00 AA
                    `;

    io:println(a);
    io:println(b);
    io:println(c);
}
// Auto generated file from index.md, do not modify!
