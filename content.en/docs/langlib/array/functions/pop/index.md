---
title : "`pop`"
description : Removes and returns the last member of an array.
example : "`[🍎, 🍇, 🍌, 🍓].pop()` ➜ `🍓`"
date: 2023-02-01
weight : 11069
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `pop`

{{< example >}}

The `pop` function removes and returns the last member of a given list. The arr argument specifies the list from which to remove the last member. The function returns the removed member.

## Examples

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

## Spec Definition

{{< spec title="`pop` documentation" >}}

```ballerina
# A type parameter that is a subtype of `any|error`.
# Has the special semantic that when used in a declaration
# all uses in the declaration must refer to same type.
@typeParam
type Type any|error;


# Removes and returns the last member of an array.
# The array must not be empty.
#
# + arr - the array
# + return - removed member
public isolated function pop(Type[] arr) returns Type = external;
```

{{< /spec >}}
