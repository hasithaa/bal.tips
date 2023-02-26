---
title : "`toBase16`"
description : Returns the string that is the Base16 representation of an array of bytes.
example : "`toBase16([72, 101, 108, 108, 111])` ➜ `48656c6c6f`"
date: 2023-02-01
weight : 11075
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `toBase16`

{{< example >}}

The `toBase16` function returns a string that represents the Base16 (hexadecimal) encoding of an array of bytes. The resulting string contains only characters `0..9` and `a..f` and has no whitespace.

## Examples

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

## Spec Definition

{{< spec title="`toBase16` documentation" >}}

```ballerina
# Returns the string that is the Base16 representation of an array of bytes.
# The representation is the same as used by a Ballerina Base16Literal.
# The result will contain only characters  `0..9`, `a..f`.
# There will be no whitespace in the returned string.
#
# + arr - the array
# + return - Base16 string representation
public isolated function toBase16(byte[] arr) returns string = external;
```

{{< /spec >}}
