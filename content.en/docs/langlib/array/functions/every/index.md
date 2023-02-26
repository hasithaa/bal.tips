---
title : "`every`"
description : Tests whether a function returns `true` for some member of an array.
example : "`[🍎, 🍇, 🍌, 🍓].some(isFruit)` ➜ `true`"
date: 2023-02-01
weight : 11060
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `every`

{{< example >}}

The `every` function tests whether a given function returns `true` for every member of a list. It applies the given function to each list member in order, and stops as soon as a call returns `false`. If the function returns `true` for every member of the list, the every function returns `true`. If the list is empty, the every function returns `true`. 

## Examples

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

## Spec Definition

{{< spec title="`every` documentation" >}}

```ballerina
# A type parameter that is a subtype of `any|error`.
# Has the special semantic that when used in a declaration
# all uses in the declaration must refer to same type.
@typeParam
type Type any|error;

# Tests whether a function returns true for every member of an array.
# `func` is called for each member of `arr` in order unless and until a call returns false.
# When the array is empty, returns true.
#
# + arr - the array
# + func - function to apply to each member
# + return - true if func returns true for every member of `arr`; otherwise, false
# 
public isolated function every(Type[] arr, @isolatedParam function(Type val) returns boolean func) returns boolean = external;
```

{{< /spec >}}
