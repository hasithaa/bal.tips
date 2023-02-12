---
title : Nil Literal
description : Nil literal uses the syntax `()` and `null`.
date: 2023-01-01
weight : 6011
type : docs
ballerina_type : [()]
ballerina_lang : [literal]
highlight : [nil-literal.bal]
---

# Nil Literal

The `nil` basic type has only a single value called `nil`. Nil literal uses the syntax `()` and `null`.

<!--more-->
{{<md class="syntax">}}

* `()` and `null`

{{</md>}}

{{< code id="0" title="Nil literal example" >}}
* {{< line 5 >}} nil literal `()` is assigned to variable `a`.
* {{< line 6 >}} nil literal `null` is assigned to variable `b`.
{{< /code >}}

{{< hint info >}}
💡 Both `()` and `null` are equivalent to `nil` in Ballerina. However, `()` is the preferred way to assign **nil** value to a variable.
{{< /hint >}}
