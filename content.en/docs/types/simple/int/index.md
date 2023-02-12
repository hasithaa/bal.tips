---
title : Integer Data Type
description : The Integer data type represents 64-bit signed integer values.
date: 2023-01-01
weight : 5020
type : docs
ballerina_type : [int, byte]
ballerina_lang : [type]
ballerina_module : [int]
highlight : [int-intro.bal, int-conversion.bal]
aliases :
  - /types/simple/int/
  - /examples/expr/numerical-operations/
  - /examples/expr/casts/numerical/
  - /examples/types/readonly/numerical/
---
{{<md class="summary">}}
The Integer data type represents 64-bit signed integer values.
{{</md>}}
{{<md class="syntax">}}

* `int`

{{</md>}}
{{<md class="tldr">}}

* [Integer Literal]({{% relref "/docs/expressions/literals/int"%}}) e.g. `10`, `12345`, `0xAD`
* Lang Library : [*ballerina/lang.int*]({{% linkh "#language-library" %}})
* `byte` and more subtypes.
* No implicit conversion between numbers.

{{</md>}}

<!--more-->

# Integer Data Type

The Integer data type represents 64-bit signed integer values.

## Syntax

The integer type is written as `int`. You can use [Integer Literal Syntax]({{% relref "/docs/expressions/literals/int" %}}) to write integer values.

{{<md class="syntax">}}

* `int`

{{</md>}}

{{< code id="0" title="Numeric value conversion with other type" >}}

**Code Breakdown**.

* {{<line 4>}} is an `int` variable with value `10` assigned;
* {{<line 5>}} is another `int` variable.
* {{<line 7>}} is an `int` addition.
* {{<line 9>}} You can refer to the maximum integer value using the `int:MAX_VALUE` constant.
* {{<line 10>}} You can refer to the minimum integer value using the `int:MIN_VALUE` constant.
  
{{</ code>}}

# Properties and Operations

`int` values do not have a storage identity, so they cannot be modified once created. As a result, they can be assigned to a `readonly` variable like other numeric types, such as float and decimal.

The `int` type part of the `anydata` and `json`. Also, it is an ordered type.

The `int` type supports the following operations and many more language features. I will discuss these operations in detail in later posts.

* Unary expressions               - `+ x`, `- x`, `~ x`
* Multiplicative expressions      - `x * y`, `x / y`, `x % y`
* Additive expressions            - `x + y`, `x - y`
* Relational expressions          - `x < y`, `x > y`, `x <= y`, `x >= y`
* Equality expressions            - `x == y`, `x != y`, `x === y`, `x !=== y`
* Shift expression                - `x << y`, `x >> y`, `x >>> y`
* Binary bitwise expression       - `x & y`, `x ^ y`, `x | y`
* Range expression                - `x ... y`
* Type Cast expression            - `<float> x`, `<decimal> x`

{{< hint warning >}}
 ⚠ The runtime will panic on integer overflow or division by zero.
{{</ hint >}}

# Converting Numerical Values

Unlike some programming languages, there is no implicit conversion between Ballerina numerical types.

If required, you can use a type-cast expression to do a numeric conversion. This is useful when converting a mapping value to another with the same field name but with a different numerical type.

{{< code id="1" title="Numeric value conversion with other types" >}}

**Code Breakdown**.

* {{<line 8>}} is the same as `<int>f.round(0)`. This uses Ballerina default round-to-nearest rounding mode. It is the same as IEEE roundToIntegralTiesToEven operation.
* {{<line 9>}} is the same as `<int>d.round(0)`. This uses Ballerina default round-to-nearest rounding mode. It is the same as IEEE roundToIntegralTiesToEven operation with a minor exception to handling positive exponent.
{{</ code>}}

# Language Library

`lang.int` Lang Library provides a set of functions that operates on an `int` value. 
See available operations with examples in [Int Lang Library]({{% relref "/docs/langlib/int" %}}).

{{<hint info>}}
🚧 More Examples Coming Soon!
{{</hint>}}

# Int Subtypes

There are multiple `int` subtypes.

* `byte` - A Built-in type, an `int` between `0` and `255` inclusive. (8 bits)
* `int:Signed32` - an `int` between `-2³¹` and `2³¹ - 1` inclusive. (32 bits using two's complement)
* `int:Signed16` - an `int` between `-2¹⁵` and `2¹⁵ - 1` inclusive. - 1 inclusive, (16 bits using two's complement)
* `int:Signed8` - an `int` between `-128` and `127` inclusive. - 1 inclusive, (8 bits using two's complement)
* `int:Unsigned32` - an `int` between `0` and `2³² - 1` inclusive. (32 bits)
* `int:Unsigned16` - an `int` between `0` and `2¹⁶ - 1` inclusive. - 1 inclusive, (16 bits)
* `int:Unsigned8` - an `int` between `0` and `255` inclusive. - 1 inclusive, (8 bits, Same as `byte`)

I will discuss this more later.

# Conclusion

In this post, I have discussed the `int` data type in Ballerina. Here are the key points.

<!--tldr-->
* Type - `int`
* [Integer Literal]({{% relref "/docs/expressions/literals/int" %}}) e.g. `10`, `12345`, `0xAD`
* No implicit conversion between numbers.
* Lang Library : [*ballerina/lang.int*]({{% linkh "#language-library" %}})
* `byte` and more subtypes.
