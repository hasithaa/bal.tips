import ballerina/io;

public function main() {
  () a = ();
  () b = null;
  null c = null; // Also valid

  io:println("a:", a);
  io:println("b:", b);
  io:println("c:", c);

  // Using JSON value as expr
  json tom = 
    {"name" : "tom", "job" : null};

  json bob = 
    {"name" : "bob", "job" : ()};
  io:println("person:", tom);
  io:println("person:", bob);
}