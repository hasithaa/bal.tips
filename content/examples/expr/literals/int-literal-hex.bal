import ballerina/io;

public function main() {
  int i1 = 0x0; // 0;
  int i2 = 0xa; // 10;
  int i3 = 0xA; // 10;
  int i4 = -0xa1b2; // -41394
  int i5 = 0XAb; // 171

  io:println(i1);
  io:println(i2);
  io:println(i3);
  io:println(i4);
  io:println(i5);
}
