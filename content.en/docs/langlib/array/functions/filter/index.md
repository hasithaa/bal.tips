---
title : "`filter`"
description : Selects the members from an array for which a function returns true.
example : "`[🍎, 🍇, 🍌, 🍓].filter(isRed)` ➜ `[🍎, 🍓]`"
date: 2023-02-01
weight : 11057
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `filter`

{{< example >}}

The `filter` function selects the members from a list for which a function returns `true`. It applies the given function to each list member to test whether it should be selected, and returns a **new list** containing only the members of the original list for which the function evaluates to true.

## Examples

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

## Spec Definition

{{< spec title="`filter` documentation" >}}

```ballerina
# A type parameter that is a subtype of `any|error`.
# Has the special semantic that when used in a declaration
# all uses in the declaration must refer to same type.
@typeParam
type Type any|error;

# Selects the members from an array for which a function returns true.
#
# + arr - the array
# + func - a predicate to apply to each member to test whether it should be selected
# + return - new array only containing members of `arr` for which `func` evaluates to true
public isolated function filter(Type[] arr, @isolatedParam function(Type val) returns boolean func) returns Type[] = external;
```

{{< /spec >}}
