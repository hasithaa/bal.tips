import ballerina/io;

public function main() {
  int i = 10;
  float f = 2.1;
  decimal d = 5.0;
  readonly r1 = i;
  readonly r2 = f;
  readonly r3 = d;

  io:println(i is readonly);
  io:println(f is readonly);
  io:println(d is readonly);
  io:println(r1);
  io:println(r2);
  io:println(r3);
}
