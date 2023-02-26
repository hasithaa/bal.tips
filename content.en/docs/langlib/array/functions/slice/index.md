---
title : "`slice`"
description : Returns a slice of an array.
example : "`[🍎, 🍇, 🍌, 🍓].slice(1,3)` ➜ `[🍇, 🍌]`"
date: 2023-02-01
weight : 11061
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `slice`

{{< example >}}

The `slice` function returns **a new list** containing a subset of the members of a given list. The subset is defined by two indices: _startIndex_ and _endIndex_. The resulting list includes all members of the original list with indices greater than or equal to _startIndex_, and less than _endIndex_.

## Examples

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

## Spec Definition

{{< spec title="`slice` documentation" >}}

```ballerina
# A type parameter that is a subtype of `any|error`.
# Has the special semantic that when used in a declaration
# all uses in the declaration must refer to same type.
@typeParam
type Type any|error;

# Returns a slice of an array.
#
# + arr - the array
# + startIndex - index of first member to include in the slice
# + endIndex - index of first member not to include in the slice
# + return - new array containing members of `arr` with index >= `startIndex` and < `endIndex` 
public isolated function slice(Type[] arr, int startIndex, int endIndex = arr.length()) returns Type[] = external;
```

{{< /spec >}}
