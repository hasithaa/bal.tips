import ballerina/io;

public function main() {
  int i = 10;
  float f = 2.1;

  int i1 = f;
  //       ^ Error
  int i2 = <int> f; // OK

  float f1 = i; 
  //         ^ Error
  float f2 = <float> i; // OK
}
