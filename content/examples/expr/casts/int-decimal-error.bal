import ballerina/io;

public function main() {
  int i = 10;
  decimal d = 5.0;

  int i1 = d;
  //       ^ Error
  int i2 = <int> d; // OK
  
  decimal d1 = i;
  //           ^ Error
  decimal d2 = <decimal> i; // OK
}
