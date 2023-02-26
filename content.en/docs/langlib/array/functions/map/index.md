---
title : "`map`"
description : Applies a function to each member of an array and returns an array of the results.
example : "`[🔵,🟡,🟢,🔴].map( m => square(m))` ➜ `[🟦,🟨,🟩,🟥]`"
date: 2023-02-01
weight : 11055
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `map`
The `map` function applies a function to each member of the list and returns **a new list** containing the results.
{{< example >}}

The color ball example uses the `map` function to apply a `square` function to each color in an input list of colors. The `map` function then returns **a new list** containing the squared colors, which would be `[🟦,🟨,🟩,🟥]`.

The color ball example is only used for illustrative purposes, let's take a look at a few real programming examples to better understand the behavior of the `map` function.

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
