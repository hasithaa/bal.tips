---
title : "`reduce`"
description : Combines the members of an array using a combining function.
example : "`[🍎, 🍇, 🍌, 🍓].reduce(makeJuice)` ➜ `🥤`"
date: 2023-02-01
weight : 11058
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `reduce`

{{< example >}}

The `reduce` function combines the members of a list using a combining function. The combining function takes two arguments: the combined value so far, and a list member. It then returns a new combined value. The `reduce` function starts with an initial value for the first argument of the combining function, and then applies the combining function to each list member in order, using the current combined value and the current list member as its arguments.

## Examples

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

## Spec Definition

{{< spec title="`reduce` documentation" >}}

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

# Combines the members of an array using a combining function.
# The combining function takes the combined value so far and a member of the array,
# and returns a new combined value.
#
# + arr - the array
# + func - combining function
# + initial - initial value for the first argument of combining function `func`
# + return - result of combining the members of `arr` using `func`
#
# For example
# ```
# reduce([1, 2, 3], function (int total, int n) returns int { return total + n; }, 0)
# ```
# is the same as `sum(1, 2, 3)`.
public isolated function reduce(Type[] arr, @isolatedParam function(Type1 accum, Type val) returns Type1 func, Type1 initial) returns Type1 = external;
```

{{< /spec >}}
