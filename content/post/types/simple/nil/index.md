---
title : Nil Data Type
description : About type nil
author: Hasitha
date: 2023-01-01
weight : 5005
btype : [(), json]
blang : [type, literal]
highlight : [nil-literal.bal, null-literal.bal, nil-string.bal]
aliases : 
  - /examples/expr/literals/nil-literal/
  - /examples/expr/literals/null-literal/
  - /types/simple/nil/
---

{{<md class="summary">}} 
The nil basic data type represents A single value called **nil**, which represents the absence of any other value. 
{{</md>}}
{{<md class="syntax">}} 
* `()` 
{{</md>}}
{{<md class="tldr">}} 
* [Nil Literal]({{< linkh "#syntax" >}}) : `()` or `null` (for JSON support).
* Multiple toString representations.
{{</md>}}
<!--more-->
<hr>

## Syntax

Both the type and the value use the syntax `()`. 

{{< code id="0" title="Nil Type and Value" />}}

## JSON Compatibility

For JSON compatibility, you can also write `()` as `null`. This will help you to copy and paste JSON values as expressions in your  code. However, avoid using `null` in places unrelated to JSON.

{{< code id="1" title="Nil in JSON" />}}

## Conversion Using `toString` and `fromString`

Depending on your requirement, you can choose a variation of the `toString` implementation.

{{< code id="2" title="toString support" />}} 

Unlike other simple data types, there is no `fromString` language library method for nil. The closest method you can use is `value:fromJsonStringWithType` method that converts a string value of `null` to `()`. 
