---
title : Float Data Type
description : About type float
date: 2023-01-01
weight : 5025
ballerina_type : [float]
ballerina_lang : [type]
ballerina_module : [float]
highlight : [float-operation.bal]
draft : false
aliases :
  - /types/simple/float/
---
{{<md class="summary">}}
The Float data type represents 64-bit IEEE 754-2008 binary floating point numbers.
{{</md>}}
{{<md class="syntax">}}

* `float`

{{</md>}}
{{<md class="tldr">}}

* Floating Point Literal, e.g. `12.34`, `0xA1.2B`
* Lang Library : [*ballerina/lang.float*]({{< linkh "#language-library---ballerinalangfloat">}})
* No implicit conversion between numbers.

{{</md>}}

<!--more-->

## Syntax

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

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

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}
