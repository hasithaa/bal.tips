---
title : "`indexOf`"
description : Returns the index of first member of `arr` that is equal to `val` if there is one.
example : "`[🍎, 🍇, 🍌, 🍓].indexOf(🍌)` ➜ `2`"
date: 2023-02-01
weight : 11065
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `indexOf`

{{< example >}}

The `indexOf` function returns the index of the first member of a given list that is equal to a specified value. The _arr_ argument specifies the list to be searched, and the _val_ argument specifies the value to search for. The _startIndex_ argument specifies the index at which to start the search. The `indexOf` function returns the index of the first member that is equal to _val_, if there is one, and `()` otherwise.

## Examples

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

## Spec Definition

{{< spec title="`indexOf` documentation" >}}

```ballerina
# A type parameter that is a subtype of `anydata|error`.
# Has the special semantic that when used in a declaration
# all uses in the declaration must refer to same type.
@typeParam
type AnydataType anydata;

# Returns the index of first member of `arr` that is equal to `val` if there is one.
# Returns `()` if not found.
# Equality is tested using `==`.
#
# + arr - the array
# + val - member to search for
# + startIndex - index to start the search from
# + return - index of the member if found, else `()`
public isolated function indexOf(AnydataType[] arr, AnydataType val, int startIndex = 0) returns int? = external;
```

{{< /spec >}}
