---
title : "`length`"
description : Returns the number of members of an array.
example : "`[🍎, 🍇, 🍌, 🍓].length()` ➜ `4`"
date: 2023-02-01
weight : 11052
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : [length.bal]
---

# `length`

{{< example >}}

The `length` function is used to determine the number of elements in a list. When this function is called with a list as its input parameter, it returns an `int` value that represents the number of elements in the list.

## Examples

{{< code id="0" title="`array:length()` Usage" />}}

## Spec Definition
{{< spec title="`length` documentation" >}}
```ballerina
# Returns the number of members of an array.
#
# + arr - the array
# + return - number of members in `arr`
public isolated function length((any|error)[] arr) returns int = external;
```
{{< /spec >}}