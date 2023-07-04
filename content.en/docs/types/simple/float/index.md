---
title : Float Data Type
description : About type float
date: 2023-05-06
weight : 5025
ballerina_type : [float]
ballerina_lang : [type]
ballerina_module : [float]
highlight : [float_operation.bal, float_lib.bal, float_intro.bal]
aliases :
  - /types/simple/float/
menu: 
  main:
    parent: types
    name: 'Float'
    params:
      group: "simple"
---

# Float Data Type

The Float data type represents 64-bit IEEE 754-2008 binary floating point numbers. Floating point numbers are used to represent fractional values. They are suitable for scientific and engineering calculations.

Floating point values do not provide exact precision. Hence, they are not suitable for financial and monetary calculations. For such calculations, you can use the [Decimal]({{% relref "/docs/types/simple/decimal" %}}) type.

{{<cards>}}
{{<card header="✍ Syntax" >}}
`float`
{.tip-syntax}

{{</card>}}
{{</cards>}}

## ✍ Syntax{id=syntax}

The floating point type is written as `float`. You can use [Floating Point Literal]({{% relref "/docs/expressions/literals/float" %}}) to represent a float value.

Ballerina's float type provides several utility functions and constants through the `ballerina/lang.float` lang library module, such as `float:NaN`, `float:Infinity`, `isNaN()`, and `isFinite()`, to handle specific floating-point scenarios like infinity and "not a number" (NaN) values.

```ballerina {filename="float_intro.bal" lines="5 6 10-11" result="output" title="Float Literal"}
import ballerina/io; //!
//!
public function main() {
//!
    float positiveFloat = 10.5; //$
    float negativeFloat = -5.25; //$
//!
    float sum = positiveFloat + negativeFloat; //!

    float infinity = float:Infinity; //$
    float notANumber = float:NaN; //$

    io:println("Positive float:", positiveFloat); //!
    io:println("Negative float:", negativeFloat); //!
    io:println("Sum of floats:", sum); //!
    io:println("Infinity:", infinity); //!
    io:println("Not a number:", notANumber); //!
}
```
# Properties and Operations

The `float` type supports the following operations and many more language features. I will discuss these operations in detail in later posts.

* Unary expressions               - `+ x`, `- x`
* Multiplicative expressions      - `x * y`, `x / y`
* Additive expressions            - `x + y`, `x - y`
* Relational expressions          - `x < y`, `x > y`, `x <= y`, `x >= y`
* Equality expressions            - `x == y`, `x != y`
* Type Cast expression            - `<int> x`, `<decimal> x`

<i class="bi bi-exclamation-octagon text-warning"></i> Floating-point operations can produce NaN, infinity, and negative zero, which may have unexpected results in some expressions. Also it can generate rounding errors due to the limited precision of floating-point values. Be cautious when using floating-point arithmetic. 
{.tip-note .note-warning}

<i class="bi bi-info text-primary"></i> Unlike some programming languages, there is no implicit conversion between Ballerina numerical types. [Learn more]({{< relref "/docs/types/conversion/numeric" >}}).
{.tip-note}

`float` values do not have a storage identity, so they cannot be modified once created. As a result, they can be assigned to a `readonly` variable like other numeric types, such as `int` and `decimal`.

The `float` type part of the `anydata` and `json`. Also, it is an ordered type.


```ballerina {filename="float_operation.bal" lines="5 6 9-21 26-27" result="output" title="Float Operations" trim=false}
import ballerina/io; //!
//!
public function main() {
//!
    float x = 5.5; //$
    float y = 10.0; //$
 //$
    string output = string `Unary, Arithmetic, and Relational Operations: //$
    +x: ${+x} //$
    -x: ${-x} //$
    x + y: ${x + y} //$
    x - y: ${x - y} //$
    x * y: ${x * y} //$
    x / y: ${x / y} //$
    x % y: ${x % y} //$
    x < y: ${x < y} //$
    x <= y: ${x <= y} //$
    x > y: ${x > y} //$
    x >= y: ${x >= y} //$
    x == y: ${x == y} //$
    x != y: ${x != y} //$
    `; //$
    io:println(output); //!

    output = string `Type Cast Expressions: //$
    int(a): ${<int>x} //$
    decimal(a): ${<decimal>x} //$
    `; //$
    io:println(output); //!
}
```

# Language Library - `ballerina/lang.float`

`lang.float` lang library provides utility functions for `float` type.  See available operations with examples in [Float Lang Library]({{% relref "/docs/langlib/float" %}}).

Additionally, `ballerina/lang.value` Lang Library provides `toString` and another set of functions that can operate on a `float` value.

```ballerina {filename="float_lib.bal" lines="5-6 8-11" result="output" title="Float Lang Library"}
import ballerina/io; //!
//!
public function main() {
//!
    float x = 5.5; //$
    float y = -10.0; //$
 //$
    float maxVal = float:max(x, y); //$
    float minVal = float:min(x, y); //$
    float absY = y.abs(); //$
    float roundVal = x.round(); //$

    string output = string `ballerina/lang.float Functions: //!
    x: ${x} //!
    y: ${y} //!
    max(x, y): ${maxVal} //!
    min(x, y): ${minVal} //!
    abs(y): ${absY} //!
    round(x): ${roundVal} //!
    `; //!
    io:println(output); //!
}
```

# Conclusion

In this post, I have discussed the `float` data type in Ballerina. Here are the key points:

{{<cards>}}
{{<card col=6 text="text-left">}}
* [Floating Point Literal](#syntax), e.g. `12.34`, `0xA1.2B`
* Floating-point operations can produce NaN, infinity, and negative zero, which may have unexpected results in some expressions. 
* No implicit conversion between numbers.
* Lang Library : [*ballerina/lang.float*]({{% relref "/docs/langlib/float" %}}).
{{</card>}}
{{</cards>}}