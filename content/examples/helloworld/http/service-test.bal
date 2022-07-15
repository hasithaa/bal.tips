import ballerina/http;
import ballerina/lang.runtime;
import ballerina/io;

public function main() returns error? {
  runtime:sleep(2);
  http:Client cl = check new ("http://localhost:8080/");

  json res1 = check cl->get("greeting");
  if res1 != {"content": "Hello, World!"} {
    io:println("Mismatch greeting ->", res1);
  }

  json res2 = check cl->get("greeting?name=Ballerina");
  if res2 != {"content": "Hello, Ballerina!"} {
    io:println("Mismatch greeting?name=Ballerina ->", res2);
  }

  io:print("Done");
}
