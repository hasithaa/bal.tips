---
title : "`some`"
description : Tests whether a function returns `true` for some member of an array.
example : "`[🍎, 🍇, 🍌, 🍓].some(isRed)` ➜ `true`"
date: 2023-02-01
weight : 11059
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `some`

{{< example >}}

The `some` function tests whether a given function returns `true` for at least one member of a given list. It applies the function to each member of the list in order until a call returns `true`, or until all members have been evaluated. If the list is empty, the function returns `false`. 

## Examples

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

## Spec Definition

{{< spec title="`some` documentation" >}}

```ballerina
# A type parameter that is a subtype of `any|error`.
# Has the special semantic that when used in a declaration
# all uses in the declaration must refer to same type.
@typeParam
type Type any|error;

# Tests whether a function returns true for some member of an array.
# `func` is called for each member of `arr` in order unless and until a call returns true.
# When the array is empty, returns false.
#
# + arr - the array
# + func - function to apply to each member
# + return - true if func returns true for some member of `arr`; otherwise, false
# 
public isolated function some(Type[] arr, @isolatedParam function(Type val) returns boolean func) returns boolean = external;
```

{{< /spec >}}
