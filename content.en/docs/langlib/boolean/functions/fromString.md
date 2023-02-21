---
title : "`fromString`"
description : Converts a string to a boolean.
date: 2023-01-01
weight : 11106
type : docs
ballerina_type : [boolean]
ballerina_module : [boolean]
highlight : [fromString.bal]
---

# `fromString`

{{< spec title="fromString documentation" >}}

```ballerina
# Converts a string to a boolean.
# Returns the boolean of which `s` is a string representation.
# The accepted representations are `true`, `false`
# (in any combination of lower- and upper-case),
# and also `1` for true and `0` for `false`.
# This is the inverse of `value:toString` applied to a `boolean`.
#
# + s - string representing a boolean value
# + return - boolean that `s` represents, or an error if there is no such boolean
public isolated function fromString(string s) returns boolean|error = external;
```
{{< /spec >}}

{{< code id="0" title="`boolean:fromString()` Usage" />}}