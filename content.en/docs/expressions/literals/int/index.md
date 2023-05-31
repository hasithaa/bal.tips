---
title : Integer Literal
description : Integer values can be expressed in either common the Decimal system, known for its base 10 format, or the Hexadecimal system which uses the Base 16 format.
date: 2023-01-01
weight : 6033
type : docs
ballerina_type : [int]
ballerina_lang : [literal]
highlight : [int_literal.bal, int_literal_hex.bal, int_to_string.bal]
aliases : 
  - /examples/expr/literals/int-literal/
  - /examples/expr/literals/int-literal-hex/
menu:
  main:
    parent: syntax
    name: 'Integer Literal'
    params:
      group: "literals"
---

# Integer Literal

Integer values can be expressed in either common the Decimal system, known for its base 10 format, or the Hexadecimal system which uses the Base 16 format.

{{< cards >}}
{{<card header="✍ Syntax" title="Decimal Literal" url="#decimal-int-literal">}}

`0` | NonZeroDigit Digit*
{.tip-syntax}

{{</card>}}
{{<card header="✍ Syntax" title="Hexadecimal Literal" url="#hex-int-literal">}}

HexIndicator [HexDigit+]
{.tip-syntax}

Here

HexIndicator = `0x`|`0X`
{.tip-syntax}

{{</card>}}
{{</cards>}}

## ✍ Syntax

### Decimal Integer Literal{id="decimal-int-literal"}

`0` | NonZeroDigit Digit*
{.tip-syntax}

An Integer value can be written as a set of decimal digits. In the Decimal system, digits are 
`0`, `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, and `9`.

An Integer value can be made negative by writing a minus (`-`) sign in front of the literal.

```ballerina {filename="int_literal.bal" title="Decimal Integer Literal" result="output"}
import ballerina/io; //!
//!
public function main() {
//!
    int i1 = 34368; //$
    int i2 = -287; //$
    int i3 = 0; //$
    int i4 = 4798; //$
    int i5 = -510; //$
//!
    io:println(i1); //!
    io:println(i2); //!
    io:println(i3); //!
    io:println(i4); //!
    io:println(i5); //!
}
```

### Hexadecimal Integer Literal{id="hex-int-literal"}

HexIndicator [HexDigit+]
{.tip-syntax}

Here

HexIndicator = `0x`|`0X`
{.tip-syntax}

Hexadecimal numbers start with a Hex Indicator `0x` (Number zero and lowercase letter `x`) or `0X` 
(Number zero and Uppercase letter `X`).

Hex digits are `0`, `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `a` or `A`, `b` or `B`, `c` or `C`, `d` or `D`, `e` 
or `E`, `f`, or `F`. These digits stand for values from zero to fifteen in base sixteen. 
These digits can be represented using either lowercase or uppercase letters.

```ballerina {filename="int_literal_hex.bal" title="Hexadecimal Integer Literal" result="output" }
import ballerina/io; //!
//!
public function main() {
//!
    int ih1 = 0X4D3B; //$
    int ih2 = -0x6e1a; //$
    int ih3 = 0x0; //$
    int ih4 = -0x1B05; //$
    int ih5 = 0Xc8e9; //$
//!
    io:println(ih1); //!
    io:println(ih2); //!
    io:println(ih3); //!
    io:println(ih4); //!
    io:println(ih5); //!
}
```

The hexadecimal number system is a useful way to represent large numbers using fewer characters. 
For example, the decimal number `1048575` can be expressed as `FFFFF` in hexadecimal.
Hexadecimal is often used as a shorthand notation for binary data because it is easier to read and write.
It is also used in a variety of applications, such as networking, web development, and cryptography.

However, hexadecimal is not as widely understood or used as the decimal system, which can make it more difficult for
developers to work with in day-to-day operations. Unless there is a specific need, the decimal system is a better
choice for everyday use. Remember the underlying bit representation of a number remains the same,
regardless of whether it is represented in decimal or hexadecimal literals.

## Conversion Using `toString` and `fromString`

In Ballerina, Implicit conversion between numerical types and the string type is restricted. 
This means that you cannot use an `int` value in place of a `string` type is needed, unless it is done explicitly.

For this, you can use the `toString()` language library function. To construct an `int` value from a `string` value,
you can use the `int:fromString()`  language library function.

Additionally, if you want to get the hexadecimal version, you can use the `int:toHexString()` and `int:fromHexString()`
functions. These functions allow you to convert between hexadecimal and numerical values.

```ballerina {filename="int_to_string.bal" title="Converting an int to a string" result="output"}
import ballerina/io; //!
//!
public function main() returns error? {
//!
    string ts = 19467.toString();           //$
    int fs = check int:fromString(ts);      //$
//!
    string hex = 19467.toHexString();       //$
    int fhs = check int:fromHexString(hex); //$
//!
    io:println(ts);                         //!
    io:println(fs);                         //!
    io:println(hex);                        //!
    io:println(fhs);                        //!
}
```

## Understanding the Hexadecimal/Decimal Conversion

Here is a summary of the hexadecimal digits and their corresponding decimal and binary values.

| Digit | Decimal - Binary | Digit      | Decimal - Binary |
| ----- | ---------------- | ---------- | ---------------- |
| `0`   | 0 - `0000`       | `8`        | 8 - `1000`       |
| `1`   | 1 - `0001`       | `9`        | 9 - `1001`       |
| `2`   | 2 - `0010`       | `a` or `A` | 10 - `1010`      |
| `3`   | 3 - `0011`       | `b` or `B` | 11 - `1011`      |
| `4`   | 4 - `0100`       | `c` or `C` | 12 - `1100`      |
| `5`   | 5 - `0101`       | `d` or `D` | 13 - `1101`      |
| `6`   | 6 - `0110`       | `e` or `E` | 14 - `1110`      |
| `7`   | 7 - `0111`       | `f` or `F` | 15 - `1111`      |
{.tip-table}

Let us use the above table to convert Hexadecimal literal to Decimal. In a Hexadecimal literal,
the rightmost digit has a place value of 16⁰(=1), the second-rightmost digit has a place value of 16¹ (=16),
the third-rightmost digit has a place value of 16² (=256), and so on.
By multiplying each decimal value by its corresponding place value, and then by adding them all together,
the decimal value can be obtained. Here is an example.

| Hexadecimal Number | 16² (=256) | 16¹ (=16) | 16⁰ (=1) | Decimal Number                    |
| ------------------ | ---------- | --------- | --------- | --------------------------------- |
| D                  | -          | -         | D (13)    | 1 x 13 = 13                       |
| AD                 | -          | A (10)    | D (13)    | 16 x 10 + 1 x 13 = 173            |
| A3D                | A (10)     | 3 (3)     | D (13)    | 256 x 10 + 16 x 3 + 1 x 13 = 2621 |
{.tip-table}

Now let us try to do the reverse by converting the same decimal literals to hexadecimal.

1. Divide the decimal number by 16 and record the Quotient and the Remainder.
2. Repeat this process with the quotient from the earlier step until it becomes 0.
   The remainder of each step is equivalent to a hexadecimal digit, 
   where the least significant digit is the first remainder of the division. Here is an example.

| Decimal Number | Step | Divide by 16 | Quotient | Remainder | Hex Digit for remainder | Hexadecimal Number |
| -------------- | ---- | ------------ | -------- | --------- | ----------------------- | ------------------ |
| 13             | 1    | 13/16        | 0        | 13        | D                       | D                  |
|                |      |              |          |           |
| 173            | 1    | 173/16       | 10       | 13        | D                       | AD                 |
|                | 2    | 10/16        | 0        | 10        | A                       |                    |
|                |      |              |          |           |
| 2621           | 1    | 2621/16      | 163      | 13        | D                       | A3D                |
|                | 2    | 163/16       | 10       | 3         | 3                       |                    |
|                | 3    | 10/16        | 0        | 10        | A                       |                    |
{.tip-table}

# Conclusion

In this post, we have covered the basics of the Ballerina integer literal. 

* Integer literals are used to represent integer values in Ballerina.
* Decimal literals are used to represent integer values in base 10.
* Hexadecimal literals are used to represent integer values in base 16.
* Unless there is a specific need, the decimal system is a better choice for everyday use.
* Underlying bit representation of a number remains the same, regardless of whether it is represented in decimal or
  hexadecimal literals.