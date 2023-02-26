---
title : "`fromBase16`"
description : Returns the byte array that a string represents in Base16.
example : "`fromBase16(\"48656c6c6f=\")` ➜ `[72, 101, 108, 108, 111]`"
date: 2023-02-01
weight : 11076
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `fromBase16`

{{< example >}}

The `fromBase16` function takes a Base16 string as input and returns the corresponding byte array. The `fromBase16 `function assumes that the input string contains only characters `0..9`, `A..F`, and `a..f`, and has no whitespace.

## Examples

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

## Spec Definition

{{< spec title="`fromBase16` documentation" >}}

```ballerina
# Returns the byte array that a string represents in Base16.
# `str` must consist of the characters `0..9`, `A..F`, `a..f`
# and whitespace as allowed by a Ballerina Base16Literal.
#
# + str - Base16 string representation
# + return - the byte array or error
public isolated function fromBase16(string str) returns byte[]|error = external;
```

{{< /spec >}}
