---
title : "`setLength`"
description : Changes the length of an array.
example : "`[🍎, 🍇, 🍌, 🍓].setLength(2)` ➜ `[🍎, 🍇]`"
date: 2023-02-01
weight : 11064
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `setLength`

{{< example >}}

The `setLength` function changes the length of a given list to a specified value.  The _arr_ argument specifies the list of which to change the length, and the _length_ argument specifies the new length of the list.

## Examples

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

## Spec Definition

{{< spec title="`setLength` documentation" >}}

```ballerina
# Changes the length of an array.
# 
# + arr - the array of which to change the length
# + length - new length
# `setLength(arr, 0)` is equivalent to `removeAll(arr)`.
public isolated function setLength((any|error)[] arr, int length) returns () = external;
```

{{< /spec >}}
