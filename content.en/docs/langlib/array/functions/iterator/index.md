---
title : "`iterator`"
description : Returns an iterator over an array.
example : "`[🔵,🟡,🟢].iterator().next()` ➜ `{ value : 🔵 }`"
date: 2023-02-01
weight : 110505
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : [iterator1.bal, iterator2.bal]
---

# `iterator`

{{< example >}}

{{< spec title="spec documentation" >}}

```ballerina
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

## Array Example

{{< code id="0" title="`array:iterator()` Usage with Array" >}}
* {{< line 7 >}} The `iterator` method is called on the array to get an iterator object.
* {{< line 11 >}} The `next()` method returns a record with the next value, if iterator has a next, else returns `()` .
* {{< line 12 >}} Use while statement to iterate through the array, until the `next()` method returns `()` .
* {{< line 15 >}} Assign the next value to the `next` variable.
{{< /code >}}

## Tuple Example

{{< code id="1" title="`array:iterator()` Usage with Tuple" >}}
* {{< line 8 >}} Return type of the `next()` method is inferred from the tuple member types.
* {{< line 14 >}} Use type test to get the type of the value.
{{< /code >}}

