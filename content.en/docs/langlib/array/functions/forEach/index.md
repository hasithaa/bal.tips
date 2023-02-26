---
title : "`forEach`"
description : Applies a function to each member of an array.
example : "`[🔵,🟡,🟢,🔴].foreach( m => io:print(m))` ➜ 🔵🟡🟢🔴"
date: 2023-02-01
weight : 11056
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `forEach`
The `forEach` function applies a function to each member of an input list in order.

{{< example >}}

The color ball example uses the `forEach` function to apply an `io:print` function to each color in an input list of colors. The `forEach` function then prints each color to the console, which would output the colors 🔵🟡🟢🔴, one after the other.

The color ball example is only used for illustrative purposes, let's take a look at a few real programming examples to better understand the behavior of the `forEach` function.

## Examples

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

## Spec Definition

{{< spec title="`forEach` documentation" >}}

```ballerina
# A type parameter that is a subtype of `any|error`.
# Has the special semantic that when used in a declaration
# all uses in the declaration must refer to same type.
@typeParam
type Type any|error;

# Applies a function to each member of an array.
# The function `func` is applied to each member of array `arr` in order.
#
# + arr - the array
# + func - a function to apply to each member
public isolated function forEach(Type[] arr, @isolatedParam function(Type val) returns () func) returns () = external;
```

{{< /spec >}}