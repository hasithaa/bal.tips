---
title : "`enumerate`"
description : Returns a new array consisting of index and member pairs.
example: "`[🔵,🟡,🟢,🔴].enumerate()` ➜ `[[0,🔵], [1,🟡], [2,🟢], [3,🔴]]`"
date: 2023-02-01
weight : 11054
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : [enumerate1.bal, enumerate2.bal]
---

# `enumerate`

The `enumerate` function creates **a new list value** that contains pairs of index and member values from the input array. In other words, it associates each member in the input array with its corresponding index, and returns **a new list** of these index-member pairs.
{{< example >}}

For example, if you have an array of colors like `[🔵,🟡,🟢,🔴]`, and you call the `enumerate` function on this array using the expression `[🔵,🟡,🟢,🔴].enumerate()`, the function would return a **new list value** that contains index-member pairs. The resulting array would look like `[[0,🔵], [1,🟡], [2,🟢], [3,🔴]]`, which represents the original colors in the input array, along with their corresponding index numbers.

The color ball example is only used for illustrative purposes, let's take a look at a few real programming examples to better understand the behavior of the `enumerate` function.

## Examples

### Array
{{< code id="0" title="`array:enumerate()` Usage with Arrays" >}}
{{< highlight >}}
📌::: 7 ::: The enumerate() function returns an array of `[int, T]` tuples. In this example, `T` is `string`. Each tuple consists of the index and the value of the array.
{{< /highlight >}}
{{< /code >}}


### Tuple
{{< code id="1" title="`array:enumerate()` Usage with Tuples" >}}
{{< highlight >}}
📌::: 7 ::: For tuples, enumerate() returns an array of `[int, T]` tuples. Where `T` is an union of the tuple members. In this example it is `float|boolean|string`. 
{{< /highlight >}}
{{< /code >}}

## Spec Definition
{{< spec title="`enumerate` documentation" >}}

```ballerina
# A type parameter that is a subtype of `any|error`.
# Has the special semantic that when used in a declaration
# all uses in the declaration must refer to same type.
@typeParam
type Type any|error;

# Returns a new array consisting of index and member pairs.
#
# + arr - the array
# + return - array of index, member pairs
public isolated function enumerate(Type[] arr) returns [int, Type][] = external;
```
{{< /spec >}}
