---
title : "Nil Literal"
date : 2022-07-05T15:59:48+05:30
summary : "Writing an nil value"
kind : tip 
tags : ["literal", "nil", "null"] 
code : ["nil-literal.bal","nil-literal.out"] 
weight : 06-05-01-00-01 
size : "medium" 
disableNavChevron : true      
---

The `nil` basic type has only a single value called `nil`. So, both the type and the value use the syntax `()`.  

For JSON compatibility you can also write it as `null`. This will help you to copy and paste JSON values as expressions in the code. But avoid using `null` in non-JSON-related places.

{{< gencode >}}
