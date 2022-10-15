import ballerina/io;

public function main() {
  string name = "tom";
  int age = 25;
  xml person = xml `<person>
  <name>${name}</name>
  <age>${age}</age>
</person>`;

  io:println(person);
}
