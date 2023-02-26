---
title : "`length`"
description : Returns the number of members of an array.
example : "`[🔵,🟡,🟢,🔴].length()` ➜ `4`"
date: 2023-02-01
weight : 11052
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : [length.bal]
---

# `length`

The `length` function is used to determine the number of elements in an array. When this function is called with an array as its input parameter, it returns an `int` value that represents the number of elements in the array.
{{< example >}}

For example, if you have an array of colors like `[🔵,🟡,🟢,🔴]`, and you call the length function on this array using the expression `[🔵,🟡,🟢,🔴].length()`, the function would return the `int` value 4, which represents the number of colors in the array.

Let's look at a real programing examples.

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