---
title : "Numerical Operations"
date : 2022-07-09T18:22:30+05:30
summary : "Numerical Operations."
kind : tip 
tags : [int, float, decimal, expr]
code : [] 
weight : 0601000001 
size : "small" 
disableNavChevron : true      
---

*int*,*float*,*decimal* values support multiple operators, Here are some

* Multiplicative ( `*`, `/`, `%` )
* Additive (`+`, `-`)
* Relational Operations ( `<`, `>`, `<=`, `>=`)  
* Equality ( `==`, `!=`, `===`, `!===`)

Additionally, *int* type supports following operations

* Shift Operations ( `<<`,`>>`, `>>>`)
* Binary bitwise (`&`, `^`, `|`)
* Range Operator ( `x ... y` )
  
See each section for more tips.

{{% notice info %}}
Runtime will panic on integer overflow or on division by zero.
{{% /notice %}}
