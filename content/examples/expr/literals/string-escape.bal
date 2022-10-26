import ballerina/io;

public function main() {
  //tip-start--
  string tab = "tab :A\tB";
  string newline = "newline :A\nB";
  //tip-end--
  string carriageReturn = "carriageReturn :A\rB";
  string backSlash = "backSlash :A\\B";
  string doubleQuote = "doubleQuote :A\"B";

  io:println(tab);
  io:println(newline);
  io:println(carriageReturn);
  io:println(backSlash);
  io:println(doubleQuote);
}
