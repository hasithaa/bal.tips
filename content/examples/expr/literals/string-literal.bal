import ballerina/io;

public function main() {
  //tip-start--
  string en = "Hello, World!";
  string zh = "你好世界！";
  string hi = "नमस्ते दुनिया!";
  string si = "හෙලෝ වර්ල්ඩ්!";
  string emoji = "👋🌏";
  //tip-end
  io:println(en);
  io:println(zh);
  io:println(hi);
  io:println(si);
  io:println(emoji);
}
