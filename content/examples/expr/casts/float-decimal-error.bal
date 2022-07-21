import ballerina/io;

public function main() {
  float f = 2.1;
  decimal d = 5.0;

  float f1 = d;
  //         ^ Error
  float f2 = <float> d; // OK

  decimal d1 = f;
  //           ^ Error
  decimal d2 = <decimal> f; // OK
}
