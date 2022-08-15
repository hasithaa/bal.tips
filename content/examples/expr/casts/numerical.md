---
title : "Converting Numerical Values"
date : 2022-07-08T20:57:17+05:30
kind : tip 
tags : [int, float, decimal] 
code : ["int-float-error.bal", "int-decimal-error.bal", "float-decimal-error.bal"] 
weight : 10603000001 
size : "small" 
disableNavChevron : true
---
Unlike some programming languages, there is no implicit conversion between Ballerina numerical types. 

<!--more-->
If required, you can use a type-cast expression to do a numeric conversion. This is useful when converting a mapping value to another with the same field name but with different numerical type. 

{{< gencode >}}