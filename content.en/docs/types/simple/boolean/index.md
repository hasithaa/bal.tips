---
title : Boolean Data Type
description : "The Boolean data type represents boolean truth values: `true` and `false`."
date: 2023-01-01
weight : 5015
type : docs
ballerina_type : [boolean]
ballerina_lang : [type, literal]
ballerina_module : [boolean]
highlight : [boolean-literal.bal]
aliases :
  - /examples/expr/literals/boolean-literal/
  - /types/simple/boolean/
---

# Boolean Data Type

The Boolean data type represents boolean truth values: `true` and `false`.

<!--more-->

## Syntax

Boolean type is written as `boolean`. We use the Boolean literal syntax to write Boolean values.
A boolean true is written as `true` and a boolean false is written as `false`.
In Ballerina,`0`, `1`, or any other variations of `true` or `false` words are not supported as alternative syntax.

{{< code id="0" title="Boolean Literal" />}}

# Properties and Operations

`boolean` values do not have a storage identity, so they are inherently immutable
(once created, it is not possible to change the content of the value).
Therefore, they can be assigned to a `readonly` variable.

The `boolean` type part of the `anydata` and `json`. Also, it is an ordered type.

In Ballerina, boolean values are used in many operations and statements.
Here are some of those. I will discuss these operations in detail in later posts.

* `if` statement
* `match` statement (in match guard expression)
* `while` statement
* Conditional expression `x ? y : z`
* Unary logical expression - `! x`
* The result of a Relational expression - `x < y`, `x > y`, `x <= y`, `x >= y`
* The result of an Equality expression - `x == y`, `x != y`, `x === y`, `x !=== y`
* Logical expression - `x | y`, `x && y`, `x || y`
* For writing Transactional Retry Managers

{{<hint info>}}
🚧 More Examples Coming Soon!
{{</hint>}}

# Language Library - `ballerina/lang.boolean`

`ballerina\lang.boolean` Lang Library provides functions that operate on a `boolean` value. 
See available operations with examples in [Boolean Lang Library]({{< relref "/docs/langlib/boolean" >}}).

{{<hint info>}}
🚧 More Examples Coming Soon!
{{</hint>}}

# Conclusion

In this post, I have discussed the `boolean` data type in Ballerina. Here are the key points:

<!--tldr-->
{{<md class="keypoint">}}

Type - `boolean`

{{</md>}}
{{<md class="tldr">}}

* [Boolean Literal]({{< linkh "#syntax" >}}), e.g. `true` & `false`.
* Lang Library : [*ballerina/lang.boolean*]({{< relref "/docs/langlib/boolean" >}}).
* Used in many language constructs.

{{</md>}}