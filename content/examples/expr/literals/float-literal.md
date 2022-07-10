---
title : "Floating Point Literal"
date : 2022-07-05T20:49:35+05:30
summary : "Writing a float literal"
kind : tip 
tags : ["literal", "float", "decimal"] 
code : ["float-literal.bal", "float-literal.out", "decimal-literal.bal", "decimal-literal.out"] 
weight : 0502040001
size : "small"
disableNavChevron : true   
---

There are two floating point types, `float` and `decimal`. Both use the same decimal number (Base 10 number) literal syntax.  

You can write floating point values using a set of digits of the decimal system (Base 10 number) numbers, by using a dot `.` as the radix character to separate *integer-part* and *fractional-part*.

Optionally you can write *float-type-suffix* character `f` or `F` precisely to say the numerical literal is a float value, Or *decimal-type-suffix* character `d` or `D` to say the numerical literal is a decimal value.

Digits are `0`, `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, and `9`. You can make a floating point number negative by writing a minus (`-`) sign in front of the literal. See `Unary Expressions` for more details.

{{< gencode >}}