---
title : Boolean Lang Library
description : Boolean lang library provides functions that operate on a `boolean` value. 
date: 2023-01-01
weight : 113200
type : docs
ballerina_type : [boolean]
ballerina_module : [boolean]
highlight : [lang-boolean.bal]
---
# Boolean Lang Library

`ballerina\lang.boolean` Lang Library provides functions that operate on a `boolean` value.
As of now, it has only the `fromString` function.
See available operations in the [ballerina/lang.boolean](https://ballerina.io/spec/lang/master/#lang.boolean) module.

Additionally, `ballerina/lang.value` Lang Library provides `toString` and another set of functions 
that can operate on a `boolean` value.

{{<hint info>}}
💡 `boolean` is a pre-defined module prefix, and you can use it without an `import` declaration.
{{</hint>}}

# Functions

## `fromString`

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
public isolated function fromString(string s) returns boolean|error { ... };
```
<div class="tip__code_title"> fromString documentation (source : ballerina spec)</div>

{{< code id="0" title="`boolean:fromString()` Usage" />}}
