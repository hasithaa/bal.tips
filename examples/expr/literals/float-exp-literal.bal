import ballerina/io;

public function main() {
  //tip-start--
  float f1 = 12e4;
  float f2 = 543e-5;
  float f3 = 1.23e3;
  float f4 = 1.23e3f;
  //tip-end
  io:println(f1);
  io:println(f2);
  io:println(f3);
  io:println(f4);
}
