---
title : "`forEach`"
description : Applies a function to each member of an array.
example : "`[🍎, 🍇, 🍌, 🍓].foreach(PrintName)` ➜ Apples, Grapes, Bananas, Strawberries"
date: 2023-02-01
weight : 11056
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `forEach`

{{< example >}}

The `forEach` function applies a given function to each member of a list in order. It iterates over the list and calls the function with each list member as its argument.

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