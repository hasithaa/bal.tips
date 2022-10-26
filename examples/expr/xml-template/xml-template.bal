import ballerina/io;

public function main() {
  //tip-start--
  string name = "tom";
  int age = 25;
  xml person = xml `<person>
  <name>${name}</name>
  <age>${age}</age>
</person>`;
  //tip-end
  io:println(person);
}
