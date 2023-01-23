---
title : Boolean Data Type
description : About type boolean
author: Hasitha
date: 2023-01-01
weight : 5010
btype : [boolean]
blang : [type, literal]
bmodule : [boolean]
highlight : [boolean-literal.bal, lang-boolean.bal]
aliases :
  - /examples/expr/literals/boolean-literal/
  - /types/simple/boolean/
---

{{<md class="summary">}}
The Boolean data type represents boolean truth values: `true` and `false`.
{{</md>}}
{{<md class="syntax">}}

* `boolean`

{{</md>}}
{{<md class="tldr">}}

* [Boolean Literal]({{< linkh "#syntax" >}}), e.g. `true` & `false`
* Lang Library : [*ballerina/lang.boolean*]({{< linkh "#language-library---ballerinalangboolean" >}})

{{</md>}}
<!--more-->

## Syntax

Boolean type is written as `boolean`. A boolean true is written as `true` and a boolean false is written as `false`. In Ballerina,`0`, `1`, or any other variations of `true` or `false` words are not supported as alternative syntax.

{{< code id="0" title="Boolean Literal" />}}

## Properties and Operations

`boolean` values do not have a storage identity, so they are inherently immutable (once created, it is not possible to change the content of the value). Therefore, they can be assigned to a `readonly` variable.

The `boolean` type part of the `anydata` and `json`. Also, it is an ordered type.

In Ballerina, boolean values are used in many operations and statements. Here are some of those. I will discuss these operations in detail in later posts.

* `if` statement
* `match` statement (in match guard expression)
* `while` statement
* Conditional expression `x ? y : z`
* Unary logical expression - `! x`
* The result of a Relational expression - `x < y`, `x > y`, `x <= y`, `x >= y`
* The result of an Equality expression - `x == y`, `x != y`, `x === y`, `x !=== y`
* Logical expression - `x | y`, `x && y`, `x || y`
* For writing Transactional Retry Managers

## Language Library - `ballerina/lang.boolean`

`ballerina\lang.boolean` Lang Library provides functions that operate on a `boolean` value. As of now, it has only the `fromString` function. See available operations in the [ballerina/lang.boolean](https://ballerina.io/spec/lang/master/#lang.boolean) module.

{{< code id="1" title="Boolean Langrage Library" />}}

💡 `boolean` is a pre-defined module prefix and you can use it without an `import` declaration.

Additionally, `ballerina/lang.value` Lang Library provides `toString` and another set of functions that can operate on a `boolean` value.
