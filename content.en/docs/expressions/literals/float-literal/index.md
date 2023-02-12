---
title : Floating Point Literal
description : Floating point values can be expressed in either Decimal (base 10) or Hexadecimal (base 16) systems
 | and come in two types, `float` and `decimal`, with slight differences in their representation using floating point literals.
date: 2023-01-01
weight : 6034
type : docs
ballerina_type : [float, decimal]
ballerina_lang : [literal]
highlight : [float-literal.bal, decimal-literal.bal, exp-literal.bal, float-hex-literal.bal]

aliases : 
  - /examples/expr/literals/float-literal/
  - /examples/expr/literals/float-exp-literal/
  - /examples/expr/literals/float-hex-literal/
---

# Floating Point Literal

Floating point values can be expressed in either Decimal (base 10) or Hexadecimal (base 16) systems
and come in two types, `float` and `decimal`, with slight differences in their representation using floating point literals.
<!--more-->

{{<md class="syntax">}}

* Decimal Literal, e.g. `123.34`
* Hexadecimal Literal, e.g. `0x1a2b.3d`

{{</md>}}



## Decimal Floating Point Literal

You can write floating point values using a set of digits of the decimal system (Base 10 number) numbers, 
by using a dot `.` as the radix character to separate *integer-part* and *fractional-part*.

Optionally you can write *float-type-suffix* character `f` or `F` precisely to say the numerical literal is a float
value, Or *decimal-type-suffix* character `d` or `D` to say the numerical literal is a decimal value.

Digits are `0`, `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, and `9`. You can make a floating point number negative by
writing a minus (`-`) sign in front of the literal. See `Unary Expressions` for more details.


{{< code id="0" title="Floating point literal with the `float` type" />}}

{{< code id="1" title="Floating point literal with the `decimal` type" />}}

## Floating Point Literal With Exponent

You can write floating numbers using scientific notation. Letter `e` or `E` is used as the exponent indicator.

{{< code id="2" title="Floating point literal with the exponent" />}}

## Hexadecimal Floating Point Literal

Hexadecimal numbers start with a Hex Indicator `0x` (Number zero and lowercase letter `x`) or `0X`
(Number zero and Uppercase letter `X`) Hex digits are `0`, `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, 
`9`, `a` or `A`, `b` or `B`, `c` or `C`, `d` or `D`, `e` or `E`, `f` or `F`

{{< hint "info" >}}
💡 Hexadecimal floating point literal only supports the `float` type.
{{</ hint >}}

{{< code id="3" title="Hexadecimal floating point literal with the `float` type" />}}

[//]: # (## Conversion Using `toString` and `fromString`)

🚧 More Details Coming Soon!
