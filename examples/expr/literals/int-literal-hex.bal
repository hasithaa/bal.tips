import ballerina/io;

public function main() {
  //tip-start--
  int i1 = 0x0;
  int i2 = 0xa;
  int i3 = 0xA;
  int i4 = -0xa1b2;
  int i5 = 0XAb;
  //tip-end
  io:println(i1);
  io:println(i2);
  io:println(i3);
  io:println(i4);
  io:println(i5);
}
