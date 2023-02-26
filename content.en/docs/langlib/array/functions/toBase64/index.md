---
title : "`toBase64`"
description : Returns the string that is the Base64 representation of an array of bytes. 
example : "`toBase64([72, 101, 108, 108, 111])` ➜ `SGVsbG8=`"
date: 2023-02-01
weight : 11073
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `toBase64`

{{< example >}}

The `toBase64` function returns a string that is the Base64 representation of an array of bytes. The _arr_ argument specifies the array of bytes to be encoded.

The Base64 representation returned by the `toBase64` function is the same as used by a Ballerina [Base64Literal]({{< ref "/docs/expressions/literals/byte-array/index.md#base64-byte-array-literal">}}). The resulting string will contain only characters `A..Z`, `a..z`, `0..9`, `+`, `/` and `=`, and there will be no whitespace in the returned string.

## Examples

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

## Spec Definition

{{< spec title="`toBase64` documentation" >}}

```ballerina
# Returns the string that is the Base64 representation of an array of bytes.
# The representation is the same as used by a Ballerina Base64Literal.
# The result will contain only characters  `A..Z`, `a..z`, `0..9`, `+`, `/` and `=`.
# There will be no whitespace in the returned string.
#
# + arr - the array
# + return - Base64 string representation
public isolated function toBase64(byte[] arr) returns string = external;
```

{{< /spec >}}
