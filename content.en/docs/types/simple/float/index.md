---
title : Float Data Type
description : About type float
date: 2023-05-06
weight : 5025
type : docs
ballerina_type : [float]
ballerina_lang : [type]
ballerina_module : [float]
highlight : [float-operation.bal, float-lib.bal, float-intro.bal]
draft : false
aliases :
  - /types/simple/float/
---

# Float Data Type

The Float data type represents 64-bit IEEE 754-2008 binary floating point numbers. Floating point numbers are used to represent fractional values. They are suitable for scientific and engineering calculations. But floating point values do not provide exact precision. Hence, they are not suitable for financial and monetary calculations. For such calculations, you can use the [Decimal]({{% relref "/docs/types/simple/decimal" %}}) type.

<!--more-->

## Syntax 

The floating point type is written as `float`. You can use [Floating Point Literal]({{% relref "/docs/expressions/literals/float" %}}) to represent a float value.

{{<md class="syntax">}}

* `float`

{{</md>}}

Ballerina's float type provides several utility functions and constants through the `ballerina/lang.float` lang library module, such as `float:NaN`, `float:Infinity`, `isNaN()`, and `isFinite()`, to handle specific floating-point scenarios like infinity and "not a number" (NaN) values.

{{< code id="2" title="`float` type" />}}

# Properties and Operations

The `float` type supports the following operations and many more language features. I will discuss these operations in detail in later posts.

* Unary expressions               - `+ x`, `- x`
* Multiplicative expressions      - `x * y`, `x / y`
* Additive expressions            - `x + y`, `x - y`
* Relational expressions          - `x < y`, `x > y`, `x <= y`, `x >= y`
* Equality expressions            - `x == y`, `x != y`
* Type Cast expression            - `<int> x`, `<decimal> x`

{{< hint warning >}}
⚠ Floating-point operations can produce NaN, infinity, and negative zero, which may have unexpected results in some expressions. Also it can generate rounding errors due to the limited precision of floating-point values. Be cautious when using floating-point arithmetic. 
{{</ hint >}}

{{<code id="0" title="Float Operations" />}}

`float` values do not have a storage identity, so they cannot be modified once created. As a result, they can be assigned to a `readonly` variable like other numeric types, such as `int` and `decimal`.

The `float` type part of the `anydata` and `json`. Also, it is an ordered type.

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

# Language Library - `ballerina/lang.float`

`lang.float` lang library provides utility functions for `float` type. 

{{<code id="1" title="Float Lang Library" />}}

Additionally, `ballerina/lang.value` Lang Library provides `toString` and another set of functions that can operate on a `float` value.


# Conclusion

In this post, I discussed the `float` type in Ballerina. Here are some key takeaways from this post.

{{<md class="keypoint">}}

Type - `float`

{{</md>}}
{{<md class="tldr">}}

* [Floating Point Literal]({{% relref "/docs/expressions/literals/float" %}}), e.g. `12.34`, `0xA1.2B`
* No implicit conversion between numbers.
* Lang Library : [*ballerina/lang.float*]({{< linkh "#language-library---ballerinalangfloat">}})

{{</md>}}
