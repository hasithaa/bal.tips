import ballerina/io;

public function main() returns error? {
  int sum = int:sum(1, 2, 3, 4, 5);
  io:println(sum);

  int max = int:max(1, 2, 3, 4, 5);
  io:println(max);

  int i = check int:fromString("123");
  io:println(i);
}
