---
title : "`reverse`"
description : Reverses the order of the members of an array.
example : "`[🍎, 🍇, 🍌, 🍓].reverse()` ➜ `[🍓, 🍌, 🍇, 🍎]`"
date: 2023-02-01
weight : 11067
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `reverse`

{{< example >}}

The `reverse` function reverses the order of the members in a given list. The _arr_ argument specifies the list to be reversed. The function returns **a new list** containing the members of the original list in reverse order.

## Examples

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

## Spec Definition

{{< spec title="`reverse` documentation" >}}

```ballerina
# A type parameter that is a subtype of `any|error`.
# Has the special semantic that when used in a declaration
# all uses in the declaration must refer to same type.
@typeParam
type Type any|error;

# Reverses the order of the members of an array.
#
# + arr - the array to be reversed
# + return - new array with the members of `arr` in reverse order
public isolated function reverse(Type[] arr) returns Type[] = external;
```
{{< /spec >}}
