import ballerina/io;

public function main() {
  decimal d1 = 12e4;
  decimal d2 = 543e-5;
  decimal d3 = 1.23e3;
  decimal d4 = 1.23e3d;

  io:println(d1);
  io:println(d2);
  io:println(d3);
  io:println(d4);
}
