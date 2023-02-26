---
title : "`toStream `"
description : Returns a stream of the members of an array.
date: 2023-02-01
weight : 11077
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `toStream `

{{< example >}}

The `toStream` function takes a list as input and returns a stream that contains the members of the list. The `toStream` function is useful when you want to use the functional programming capabilities of Ballerina, such as filtering and mapping, with an array.

## Examples

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

## Spec Definition

{{< spec title="`toStream ` documentation" >}}

```ballerina
# A type parameter that is a subtype of `any|error`.
# Has the special semantic that when used in a declaration
# all uses in the declaration must refer to same type.
@typeParam
type Type any|error;

# Returns a stream of the members of an array.
#
# + arr - the array
# + returns - stream of members of the array
# The returned stream will use an iterator over `arr` and
# will therefore handle mutation of `arr` in the same way
# as an iterator does.
# Theutation of the `arr`
public isolated function toStream(T[] arr) returns stream<T,()> = external;
```

{{< /spec >}}
