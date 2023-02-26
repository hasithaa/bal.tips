---
title : "`iterator`"
description : Returns an iterator over an array.
example : "`[🔵,🟡,🟢,🔴].iterator().next()` ➜ `{ value : 🔵 }`"
date: 2023-02-01
weight : 11053
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : [iterator1.bal, iterator2.bal]
---

# `iterator`

The `iterator` function in Ballerina is used to create an iterator object for an input array. An iterator is an object that can be used to iterate over the elements of an array in a controlled manner. When the `iterator` function is called with an array as its input parameter, it returns a new iterator object that can be used to iterate over the elements of the input array.

{{< example >}}

For example, if you have an array of colors like `[🔵,🟡,🟢,🔴]`, and you call the `iterator` function on this array using the expression `[🔵,🟡,🟢,🔴].iterator()`, the function would return a new iterator object that can be used to iterate over the elements of the array.

The `next` function of the iterator object is used to retrieve the next element of the array. When the `next` function is called and if the iterator has a next value, it returns a `record` value that contains a single field called `value`. The `value` field contains the next element of the array. If the iterator does not have a next value, it returns `()` instead of a record value.

For example, if you call the next function on the iterator object returned from `[🔵,🟡,🟢,🔴].iterator()`, it would return the first element of the array, which is the color `🔵`. The returned `record` value would contain a single field called value, which would contain the value `🔵`.

The color ball example is only used for illustrative purposes, let's take a look at a few real programming examples to better understand the behavior of the `iterator` function.

## Examples

### Array

{{< code id="0" title="`array:iterator()` Usage with Array" >}}
{{< highlight >}}
📌::: 7-9  :::  The `iterator` method is called on the array to get an iterator object.
📌::: 11 :::  The `next()` method returns a record with the next value, if iterator has a next, else returns `()`.
📌::: 12-16 ::: Use while statement to iterate through the array, until the `next()` method returns `()`.
📌::: 15 ::: Assign the next value to the `next` variable.
{{< /highlight >}}
{{< /code >}}

### Tuple

{{< code id="1" title="`array:iterator()` Usage with Tuple" >}}
{{< highlight >}}
📌::: 8  ::: Return type of the `next()` method is inferred from the tuple member types.
📌::: 14 ::: Use type test to get the type of the value.
{{< /highlight >}}
{{< /code >}}

## Spec Definition

{{< spec title="`iterator` documentation" >}}

```ballerina
# A type parameter that is a subtype of `any|error`.
# Has the special semantic that when used in a declaration
# all uses in the declaration must refer to same type.
@typeParam
type Type any|error;

# Returns an iterator over an array.
#
# + arr - the array
# + return - a new iterator object that will iterate over the members of `arr`.
public isolated function iterator(Type[] arr) returns object {
    public isolated function next() returns record {|
        Type value;
    |}?;
} = external;
```

{{< /spec >}}