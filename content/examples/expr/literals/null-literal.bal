import ballerina/io;

public function main() {
  () a = null;
  null b = null; // Also valid

  io:println("a:", a);
  io:println("b:", b);

  // Using JSON value as expr
  json tom = {"name" : "tom", "job" : null};

  json bob = {"name" : "bob", "job" : ()};
  io:println("person:", tom);
  io:println("person:", bob);
}