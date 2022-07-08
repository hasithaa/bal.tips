import ballerina/io;

public function main() {
  int i = 10;
  float f = 2.1;
  decimal d = 5.0;

  float fi = i; 
  //         ^ Error
  decimal di = i;
  //           ^ Error
  int 'if = f;
  //        ^ Error
  decimal df = f;
  //           ^ Error
  int id = d;
  //       ^ Error
  float fd = d;
  //         ^ Error

  int i1 = <int> f; // OK
  int i2 = <int> d; // OK
  float f1 = <float> i; // OK
  float f2 = <float> d; // OK
  decimal d1 = <decimal> i; // OK
  decimal d2 = <decimal> f; // OK
}
