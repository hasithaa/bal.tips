---
title : "`enumerate`"
description : Returns a new array consisting of index and member pairs.
example: "`[🔵,🟡,🟢].enumerate()` ➜ `[[0,🔵], [1,🟡], [2,🟢]]`"
date: 2023-02-01
weight : 110505
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : [enumerate1.bal, enumerate2.bal]
---

# `enumerate`

{{< example >}}

{{< spec title="spec documentation" >}}

```ballerina
# Returns a new array consisting of index and member pairs.
#
# + arr - the array
# + return - array of index, member pairs
public isolated function enumerate(Type[] arr) returns [int, Type][] = external;
```
{{< /spec >}}

## Arary Example
{{< code id="0" title="`array:enumerate()` Usage with Arrays" >}}
* {{< line 7 "tip_info">}} The enumerate() function returns an array of `[int, T]` tuples. In this example, `T` is `string`. Each tuple consists of the index and the value of the array.
{{< /code >}}


## Tuple Example
{{< code id="1" title="`array:enumerate()` Usage with Tuples" >}}
* {{< line 7 "tip_info">}} For tuples, enumerate() returns an array of `[int, T]` tuples. Where `T` is an union of the tuple members. In this example it is `float|boolean|string`. 
{{< /code >}}

