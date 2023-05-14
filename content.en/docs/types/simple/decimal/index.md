---
title : Decimal Data Type
description : About type decimal
date: 2023-05-06
weight : 5030
type : docs
ballerina_type : [decimal]
ballerina_lang : [type]
ballerina_module : [decimal]
highlight : [decimal-operation.bal, decimal-lib.bal, decimal-intro.bal]
draft : false
aliases :
  - /types/simple/decimal/
---
# Decimal Data Type

The Decimal basic data type represents 128-bit IEEE 754-2008 decimal floating point values. Decimals in Ballerina provide higher precision and a larger range of values than floating-point numbers. Which means, they are suitable for financial and monetary calculations.

<!--more-->

## Syntax

The decimal type is written as `decimal`. You can use [Floating Point Literal]({{% relref "/docs/expressions/literals/float" %}}) to represent a decimal value. Please not that you cannot use hexadecimal floating point literals with `decimal` type.

{{`<md class="syntax">`}}

* `decimal`

{{`</md>`}}

{{< code id="2" title="`decimal` type" />}}

# Properties and Operations

The `decimal` type supports the following operations and many more language features. I will discuss these operations in detail in later posts.

* Unary expressions               - `+ x`, `- x`
* Multiplicative expressions      - `x * y`, `x / y`, `x % y`
* Additive expressions            - `x + y`, `x - y`
* Relational expressions          - `x < y`, `x > y`, `x <= y`, `x >= y`
* Equality expressions            - `x == y`, `x != y`, `x === y`, `x !=== y`
* Type Cast expression            - `<int> x`, `<float> x`

{{< code id="0" title="Decimal Operations" />}}

`decimal` values do not have a storage identity, so they cannot be modified once created. As a result, they can be assigned to a `readonly` variable like other numeric types, such as `int` and `float`.

The `decimal` type is part of the `anydata` and `json`. Also, it is an ordered type.

# Language Library - `ballerina/lang.decimal`

`lang.decimal` lang library provides utility functions for `decimal` type.

{{`<code id="1" title="Decimal Lang Library" />`}}

Additionally, `ballerina/lang.value` Lang Library provides `toString` and another set of functions that can operate on a `decimal` value.

# Conclusion

In this post, I discussed the `decimal` type in Ballerina. Here are some key takeaways from this post.

{{`<md class="keypoint">`}}

Type - `decimal`

{{`</md>`}}
{{`<md class="tldr">`}}

* [Floating Point Literal]({{% relref "/docs/expressions/literals/float" %}}), e.g. `12.34`
* No implicit conversion between numbers.
* Lang Library : [*ballerina/lang.decimal*]({{< linkh "#language-library---ballerinalangdecimal">}})

{{`</md>`}}
