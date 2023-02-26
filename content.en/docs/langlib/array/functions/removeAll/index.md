---
title : "`removeAll`"
description : Removes all members of an array.
example : "`[🍎, 🍇, 🍌, 🍓].removeAll()` ➜ `[]`"
date: 2023-02-01
weight : 11063
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `removeAll`

{{< example >}}

The `removeAll` function removes all members from a given list. The _arr_ argument specifies the list to be emptied. The function panics if any member cannot be removed.

## Examples

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

## Spec Definition

{{< spec title="`removeAll` documentation" >}}

```ballerina
# Removes all members of an array.
# + arr - the array
# Panics if any member cannot be removed.
public isolated function removeAll((any|error)[] arr) returns () = external;
```

{{< /spec >}}
