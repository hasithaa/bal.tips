---
title : "`map`"
description : Applies a function to each member of an array and returns an array of the results.
example : "`[🍎, 🍇, 🍌, 🍓].map(makeCandy)` ➜ `[🍫, 🍬, 🍭, 🍰]`"
date: 2023-02-01
weight : 11055
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `map`

{{< example >}}

The `map` function applies a given function to each member of a list in order and returns **a new list** containing the result of applying the function to each member of the original list.

## Examples

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

## Spec Definition

{{< spec title="`map` documentation" >}}

```ballerina
# A type parameter that is a subtype of `any|error`.
# Has the special semantic that when used in a declaration
# all uses in the declaration must refer to same type.
@typeParam
type Type any|error;

# A type parameter that is a subtype of `any|error`.
# Has the special semantic that when used in a declaration
# all uses in the declaration must refer to same type.
@typeParam
type Type1 any|error;

# Applies a function to each member of an array and returns an array of the results.
#
# + arr - the array
# + func - a function to apply to each member
# + return - new array containing result of applying `func` to each member of `arr` in order
public isolated function 'map(Type[] arr, @isolatedParam function(Type val) returns Type1 func) returns Type1[] = external;
```

{{< /spec >}}
