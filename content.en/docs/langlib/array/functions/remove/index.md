---
title : "`remove`"
description : Removes a member of an array.
example : "`[🍎, 🍇, 🍌, 🍓].remove(1)` ➜ `🍇`"
date: 2023-02-01
weight : 11062
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `remove`

{{< example >}}

The `remove` function removes a member from a given list. The _index_ argument specifies the index of the member to be removed from the list. The `remove` function returns the member of the list that was removed.

## Examples

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

## Spec Definition

{{< spec title="`remove` documentation" >}}

```ballerina
# A type parameter that is a subtype of `any|error`.
# Has the special semantic that when used in a declaration
# all uses in the declaration must refer to same type.
@typeParam
type Type any|error;

# Removes a member of an array.
#
# + arr - the array
# + index - index of member to be removed from `arr`
# + return - the member of `arr` that was at `index`
# This removes the member of `arr` with index `index` and returns it.
# It panics if there is no such member.
public isolated function remove(Type[] arr, int index) returns Type = external;
```

{{< /spec >}}
