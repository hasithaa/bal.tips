---
title : "`filter`"
description : Selects the members from an array for which a function returns true.
example : "`[🔵,🟡,🟢,🔴].filter( m => m == 🟡))` ➜ `[🟡]`"
date: 2023-02-01
weight : 11057
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `filter`
The `filter` function selects members from an input list for which a given function returns `true`.
{{< example >}}

The color ball example uses the `filter` function to apply a predicate function that selects only the color `🟡` from an input list of colors. The `filter` function then returns **a new list** containing only the selected color, which would be `[🟡]`.

The color ball example is only used for illustrative purposes, let's take a look at a few real programming examples to better understand the behavior of the `filter` function.

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
