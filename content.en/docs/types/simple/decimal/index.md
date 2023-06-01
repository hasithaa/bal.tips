---
title : Decimal Data Type
description : About type decimal
date: 2023-05-06
weight : 5030
ballerina_type : [decimal]
ballerina_lang : [type]
ballerina_module : [decimal]
highlight : [decimal_operation.bal, decimal_lib.bal, decimal_intro.bal]
draft : false
aliases :
  - /types/simple/decimal/
menu: 
  main:
    parent: types
    name: 'Decimal'
    params:
      group: "simple"
---

# Decimal Data Type

The Decimal basic data type represents 128-bit IEEE 754-2008 decimal floating point values. Decimals in Ballerina provide higher precision and a larger range of values than floating-point numbers. Which means, they are suitable for financial and monetary calculations.

{{<cards>}}
{{<card header="✍ Syntax" >}}
`decimal`
{.tip-syntax}

{{</card>}}
{{</cards>}}

## ✍ Syntax{id=syntax}

The decimal type is written as `decimal`. You can use [Floating Point Literal]({{% relref "/docs/expressions/literals/float" %}}) to represent a decimal value. Please note that you cannot use hexadecimal floating point literals with `decimal` type.

```ballerina {filename="decimal_intro.bal" lines="5 6" result="output" title="Decimal Literal"}
import ballerina/io; //!
//!
public function main() {
//!
    decimal positiveDecimal = 10.5; //$
    decimal negativeDecimal = -5.25; //$
//$
    decimal sum = positiveDecimal + negativeDecimal;
    decimal difference = positiveDecimal - negativeDecimal;
    decimal product = positiveDecimal * negativeDecimal;
    decimal quotient = positiveDecimal / negativeDecimal;
//!
    io:println("Positive decimal:", positiveDecimal); //!
    io:println("Negative decimal:", negativeDecimal); //!
    io:println("Sum of decimals:", sum); //!
    io:println("Difference of decimals:", difference); //!
    io:println("Product of decimals:", product); //!
    io:println("Quotient of decimals:", quotient); //!
}
```

# Properties and Operations

The `decimal` type supports the following operations and many more language features. I will discuss these operations in detail in later posts.

* Unary expressions               - `+ x`, `- x`
* Multiplicative expressions      - `x * y`, `x / y`, `x % y`
* Additive expressions            - `x + y`, `x - y`
* Relational expressions          - `x < y`, `x > y`, `x <= y`, `x >= y`
* Equality expressions            - `x == y`, `x != y`, `x === y`, `x !=== y`
* Type Cast expression            - `<int> x`, `<float> x`


Note: Unlike some programming languages, there is no implicit conversion between Ballerina numerical types. [Learn more]({{< relref "/docs/types/conversion/numeric" >}}).
{.tip-note}

```ballerina {filename="decimal_operation.bal" lines="5-6 9-21 26-27" result="output" title="Decimal Operations" trim=false}
import ballerina/io; //!
//!
public function main() {
//!
    decimal x = 5.5; //$
    decimal y = 10.0; //$
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
//$
    output = string `Type Cast Expressions: //$
    int(a): ${<int>x} //$
    float(a): ${<float>x} //$
    `; //$
    io:println(output);//!
}
```

`decimal` values do not have a storage identity, so they cannot be modified once created. As a result, they can be assigned to a `readonly` variable like other numeric types, such as `int` and `float`.

The `decimal` type is part of the `anydata` and `json`. Also, it is an ordered type.

# Language Library - `ballerina/lang.decimal`

`ballerina\lang.decimal` Lang Library provides utility functions for `decimal` type. See available operations with examples in [Decimal Lang Library]({{% relref "/docs/langlib/decimal" %}}).

Additionally, `ballerina/lang.value` Lang Library provides `toString` and another set of functions that can operate on a `decimal` value.

```ballerina {filename="decimal_lib.bal" lines="5-6 8-11" result="output" title="Decimal Lang Library"}
import ballerina/io; //!
//!
public function main() {
//!
    decimal x = 5.5; //$
    decimal y = -10.0; //$
//$
    decimal maxVal = decimal:max(x, y); //$
    decimal minVal = decimal:min(x, y); //$
    decimal absY = y.abs(); //$
    decimal roundVal = x.round(); //$
//!
    string output = string `ballerina/lang.decimal Functions: //!
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

In this post, I have discussed the `boolean` data type in Ballerina. Here are the key points:

{{<cards>}}
{{<card col=6 text="text-left">}}
* [Floating Point Literal](#syntax), e.g. `12.34`
* No implicit conversion between numbers.
* Lang Library : [*ballerina/lang.decimal*]({{% relref "/docs/langlib/decimal" %}}).
{{</card>}}
{{</cards>}}