---
title : "`fromBase64`"
description : Returns the byte array that a string represents in Base64.
example : "`fromBase64(\"SGVsbG8=\")` ➜ `[72, 101, 108, 108, 111]`"
date: 2023-02-01
weight : 11074
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `fromBase16`

{{< example >}}
The `fromBase64` function returns the byte array that a string represents in Base64. The _str_ argument specifies the Base64-encoded string to be decoded.

The str argument must consist of the characters `A..Z`, `a..z`, `0..9`, `+`, `/` and `=`, and whitespace as allowed by a Ballerina [Base64Literal]({{< ref "/docs/expressions/literals/byte-array/index.md#base64-byte-array-literal">}}).

## Examples

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

## Spec Definition

{{< spec title="`fromBase16` documentation" >}}

```ballerina
# Returns the byte array that a string represents in Base64.
# `str` must consist of the characters `A..Z`, `a..z`, `0..9`, `+`, `/`, `=`
# and whitespace as allowed by a Ballerina Base64Literal.
#
# + str - Base64 string representation
# + return - the byte array or error
public isolated function fromBase64(string str) returns byte[]|error = external;
```

{{< /spec >}}
