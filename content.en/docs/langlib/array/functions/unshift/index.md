---
title : "`unshift`"
description : Adds values to the start of an array.
example : "`[🍎, 🍇, 🍌, 🍓].unshift(🍒, 🍉)` ➜ `[🍒, 🍉, 🍎, 🍌, 🍇, 🍓]`"
date: 2023-02-01
weight : 11072
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `unshift`

{{< example >}}

The `unshift` function adds one or more values to the start of a given list. The _arr_ argument specifies the list to which the values will be added, and the _vals_ argument is a variable-length argument that can contain one or more values to add to the list.

## Examples

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

## Spec Definition

{{< spec title="`unshift` documentation" >}}

```ballerina
# A type parameter that is a subtype of `any|error`.
# Has the special semantic that when used in a declaration
# all uses in the declaration must refer to same type.
@typeParam
type Type any|error;

# Adds values to the start of an array.
# The values newly added to the array will be in the same order
# as they are in `vals`.
# 
# + arr - the array
# + vals - values to add to the start of the array
public isolated function unshift(Type[] arr, Type... vals) returns () = external;
```

{{< /spec >}}
