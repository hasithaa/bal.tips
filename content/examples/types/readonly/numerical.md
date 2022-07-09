---
title : "Numbers are Immutable"
date : 2022-07-08T21:27:59+05:30
summary : "Numbers don't have a storage identity."
kind : tip 
tags : [int, float, decimal, readonly] 
code : ["numerical.bal", "numerical.out"] 
weight : 0506050001 
size : "small"
disableNavChevron : true      
---

Numerical value don't have a storage identity, hence they are Inherently immutable (once created, it can't be change the content of the value). 

Numbers are assignable to a `readonly` variable.

{{< gencode >}}