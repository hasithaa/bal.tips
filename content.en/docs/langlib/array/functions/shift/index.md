---
title : "`shift`"
description :  Removes and returns first member of an array.
example : "`[🍎, 🍇, 🍌, 🍓].shift()` ➜ `🍎`"
date: 2023-02-01
weight : 11071
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `shift`

{{< example >}}

The `shift` function removes and returns the first member of a given list. The _arr_ argument specifies the list from which to remove the first member. The function returns the removed member.

## Examples

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

## Spec Definition

{{< spec title="`shift` documentation" >}}

```ballerina
# A type parameter that is a subtype of `any|error`.
# Has the special semantic that when used in a declaration
# all uses in the declaration must refer to same type.
@typeParam
type Type any|error;

# Removes and returns first member of an array.
# The array must not be empty.
#
# + arr - the array
# + return - the value that was the first member of the array
public isolated function shift(Type[] arr) returns Type = external;
```

{{< /spec >}}
