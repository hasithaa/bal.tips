---
title : "`push`"
description : Adds values to the end of an array.
example : "`[🍎, 🍇, 🍌, 🍓].push(🍒, 🍉)` ➜ `[🍎, 🍌, 🍇, 🍓, 🍒, 🍉]`"
date: 2023-02-01
weight : 11070
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `push`

{{< example >}}

The `push` function adds one or more values to the end of a given list. The _arr_ argument specifies the list to which the values will be added, and the _vals_ argument is a variable-length argument that can contain one or more values to add to the list.

## Examples

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

## Spec Definition

{{< spec title="`push` documentation" >}}

```ballerina
# A type parameter that is a subtype of `any|error`.
# Has the special semantic that when used in a declaration
# all uses in the declaration must refer to same type.
@typeParam
type Type any|error;

# Adds values to the end of an array.
#
# + arr - the array
# + vals - values to add to the end of the array
public isolated function push(Type[] arr, Type... vals) returns () = external;
```

{{< /spec >}}
