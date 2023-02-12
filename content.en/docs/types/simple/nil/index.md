---
title : Nil Data Type
description : The **Nil** data type represents a single value called **nil**, which represents the 
 | absence of any other value.
date: 2023-01-01
weight : 5010
type : docs
ballerina_type : [(), json]
ballerina_lang : [type, literal]
highlight : [nil-literal.bal, null-literal.bal, nil-string.bal]
aliases : 
  - /types/simple/nil/
---

# Nil Data Type

The **Nil** data type represents a single value called **nil**, which represents the absence of any other value.

<!--more-->

## Syntax

{{<md class="syntax">}}

* `()`

{{</md>}}

Both the type and the value (nil literal) use the syntax `()`.

{{< code id="0" title="Nil Type and Value" />}}

## JSON Compatibility

For JSON compatibility, you can also write `()` as `null`.
This will help you to copy and paste JSON values as expressions in your  code.
However, avoid using `null` in places unrelated to JSON.

{{< code id="1" title="Nil in JSON" />}}

# Properties and Operations

The **Nil** type used in many more language features.

* **Optional Type** - A Optional type `𝓣?` means the union of `𝓣` and `()`.
    It is completely equivalent to `𝓣|()`.  
* **Absence of return value in a function** -  A function that does not return a value in Ballerina 
    is equivalent to returning **nil** - `()`. As a best practice, we simply omit the `returns ()`
    from the function signature if function does not return a value.

{{<hint info>}}
🚧 More Examples Coming Soon!
{{</hint>}}

# Lang Library

Unlike other simple types, the **Nil** type does not have a dedicated lang library. But
`ballerina/lang.value` Lang Library provides `toString` and another set of functions
that can operate on a **Nil** value.

# Conversion Using `toString` and `fromString`

Depending on your requirement, you can choose a variation of the `toString` implementation.

{{< code id="2" title="toString support" />}}

Unlike other simple data types, there is no `fromString` language library method for nil.
The closest method you can use is `value:fromJsonStringWithType` method that converts a string
value of `null` to `()`.

# Conclusion

Here are the key points you should remember about the **Nil** data type.

{{<md class="keypoint">}}

Type and Value - `()`, `null`

{{</md>}}
{{<md class="tldr">}}

* [Nil Literal]({{< linkh "#syntax" >}}) : `()` or `null` (for JSON support).
* Optional Type `𝓣?` ⇔ `𝓣|()`.
* `returns ()` means Absence of return value in a function.
* Multiple toString representations.

{{</md>}}