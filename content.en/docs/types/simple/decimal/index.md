---
title : Decimal Data Type
description : About type decimal
date: 2023-01-01
weight : 5030
ballerina_type : [decimal]
ballerina_lang : [type]
ballerina_module : [decimal]
highlight : [decimal-operation.bal]
draft : false
aliases :
  - /types/simple/decimal/
---

{{<md class="summary">}}
The Decimal basic data type represents 128-bit IEEE 754-2008 decimal floating point values.
{{</md>}}
{{<md class="syntax">}}

* `decimal`

{{</md>}}
{{<md class="tldr">}}

* Floating Point Literal, e.g. `12.34`,
* Lang Library : [*ballerina/lang.decimal*]({{< linkh "#language-library---ballerinalangdecimal">}})
* No implicit conversion between numbers.

{{</md>}}

<!--more-->

## Syntax

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

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

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}
