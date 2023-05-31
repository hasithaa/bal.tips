---
title: Floating Point Literal
description: Floating point values can be expressed in either Decimal (base 10) or Hexadecimal (base 16) systems
 | and come in two types, `float` and `decimal`, with slight differences in their representation using floating point literals.
date: 2023-01-01
weight: 6034
ballerina_type: [float, decimal]
ballerina_lang: [literal]
highlight: [float_literal_float_type.bal, float_literal_decimal_type.bal, ]
aliases : 
  - /examples/expr/literals/float-literal/
  - /examples/expr/literals/float-exp-literal/
  - /examples/expr/literals/float-hex-literal/
menu:
  main:
    parent: syntax
    name: 'Float Literal'
    params:
      group: "literals"
---

# Floating Point Literal

Floating point values can be expressed in either Decimal (base 10) or Hexadecimal (base 16) systems
and come in two types, `float` and `decimal`, with slight differences in their representation using floating point literals.

{{< cards >}}
{{<card header="✍ Syntax" title="Decimal Literal" url="#decimal-float-literal">}}

&lt;integer-part> `.` &lt;fractional-part> [`f`|`F`|`d`|`D`]
{.tip-syntax}

{{</card>}}
{{<card header="✍ Syntax" title="Hexadecimal Literal" url="#hex-float-literal">}}

`0`[`x`|`X`] hex-integer-part `.` hex-fractional-part
{.tip-syntax}

{{</card>}}
{{</ cards >}}


## Decimal Floating Point Literal{id="decimal-float-literal"}

You can write floating point values using a set of digits of the decimal system (Base 10 number) numbers, 
by using a dot `.` as the radix character to separate *integer-part* and *fractional-part*.

Optionally you can write *float-suffix* character `f` or `F` precisely to say the numerical literal is a float
value, Or *decimal-suffix* character `d` or `D` to say the numerical literal is a decimal value.

Digits are `0`, `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, and `9`. You can make a floating point number negative by
writing a minus (`-`) sign in front of the literal. See `Unary Expressions` for more details.

```ballerina {filename="float_literal_float_type.bal" lines="5-11" result="output" title="Floating point literal with the float type"}
import ballerina/io; //!
//!
public function main() {
//!
    float f1 = 12.345; //$
    float f2 = -5.678; //$
    float f3 = .5678; //$
    float f4 = 123.456f; //$
    float f5 = 567.8901F; //$
    float f6 = 505f; //$
    float f7 = 505.0f; //$
//!
    io:println(f1);  //!
    io:println(f2);  //!
    io:println(f3);  //!
    io:println(f4);  //!
    io:println(f5);  //!
    io:println(f6);  //!
    io:println(f7);  //!
}
```


```ballerina {filename="float_literal_decimal_type.bal" lines="5-11" result="output" title="Floating point literal with the decimal type"}
import ballerina/io; //!
//!
public function main() {
//!
    decimal f1 = 12.345; //$
    decimal f2 = -5.678; //$
    decimal f3 = .5678; //$
    decimal f4 = 123.456d; //$
    decimal f5 = 567.8901D; //$
    decimal f6 = 505d; //$
    decimal f7 = 505.0d; //$
//!
    io:println(f1);   //!
    io:println(f2);   //!
    io:println(f3);   //!
    io:println(f4);   //!
    io:println(f5);   //!
    io:println(f6);   //!
    io:println(f7);   //!
}
```

## Floating Point Literal With Exponent

You can write floating numbers using scientific notation. The Letter `e` or `E` is used as the exponent indicator.

```ballerina {filename="float_literal_exponent.bal" lines="5-12" result="output" title="Floating point literal with the exponent"}
import ballerina/io; //!
//!
public function main() {
//!
    float f1 = 12e4; //$
    float f2 = 543e-5; //$
    float f3 = 1.23e3; //$
    float f4 = 1.23e3f; //$
    decimal d1 = 12e4; //$
    decimal d2 = 543e-5; //$
    decimal d3 = 1.23e3; //$
    decimal d4 = 1.23e3d; //$
//!
    io:println(f1); //!
    io:println(f2); //!
    io:println(f3); //!
    io:println(f4); //!
    io:println(d1); //!
    io:println(d2); //!
    io:println(d3); //!
    io:println(d4); //!
}
```

## Hexadecimal Floating Point Literal{id="hex-float-literal"}

Hexadecimal numbers start with a Hex Indicator `0x` (Number zero and lowercase letter `x`) or `0X`
(Number zero and Uppercase letter `X`) Hex digits are `0`, `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, 
`9`, `a` or `A`, `b` or `B`, `c` or `C`, `d` or `D`, `e` or `E`, `f` or `F`

`0`[`x`|`X`] hex-integer-part `.` hex-fractional-part
{.tip-syntax}

💡 Hexadecimal floating point literal only supports the `float` type.
{.note .note-primary}

```ballerina {filename="float_literal_hex.bal" lines="5-9" result="output" title="Hexadecimal floating point literal"}
import ballerina/io; //!
//!
public function main() {
//!
    float f1 = 0x5.8; //$
    float f2 = -0x5.8; //$
    float f3 = 0x7b.74bc6a7ef9db22d; //$
    float f4 = 0X7B.74BC6A7EF9DB22D; //$
    float f5 = 0x1F9.A; //$
//!
    io:println(f1); //!
    io:println(f2); //!
    io:println(f3); //!
    io:println(f4); //!
    io:println(f5); //!
}
```
