import ballerina/io;

public function main() {
  //tip-start--
  string name = "";
  int age = 30;
  object:RawTemplate tmp = `My name is ${name}. My age is ${age}.`;
  //tip-end
  io:println(tmp.strings);
  io:println(tmp.insertions);
}
