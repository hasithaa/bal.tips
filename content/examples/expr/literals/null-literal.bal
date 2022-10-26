import ballerina/io;

public function main() {
  //tip-start--
  () a = null;
  null b = null; // Also valid
  //tip-end
  io:println("a:", a);
  io:println("b:", b);
  //tip-start--

  // Using JSON value as expr
  json tom = 
   {"name" : "tom", "job" : null};

  json bob = 
   {"name" : "bob", "job" : ()};
  //tip-end
  io:println("person:", tom);
  io:println("person:", bob);
}