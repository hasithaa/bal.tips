---
title : "String Templates"
date : 2022-07-31T07:56:53+05:30
kind : tip 
tags : ["template", "string-template", "string"]
code : ["template.bal", "template-special.bal"] 
weight : 0606010001
size : "small"
disableNavChevron : true 
seeMore : true
---

A String template expression constructs a string value using the Template expression. Support interpolation (Syntax `${expr}`) and each interpolation expression must have a type that is a subtype of `boolean|int|float|decimal|string`. You can use this expression in places where you use string concatenation, or you need to build multi-line string values.   

<!--more-->

**How String Interpolation works**

* Step 1 - Take every character that is not part of the interpolation within the two `` ` `` Backtick, including newline, CR, etc. These characters are sliced based on interpolation expression positions. 
* Step 2- Evaluate each interpolation expression in the order in which they were written. Then Take the string representation of the values, by using the `value:toString()` lang-lib function.
* Step 3 - Construct the final string value interleaving Step 1 and Step 2 results.   

**Special Cases**

* 🚫 Unlike [*string-literal*](/tags/string-literal/), String Template doesn't support escape characters.    
* ✅ Use [*string-literal*](/tags/string-literal/) with interpolation to type such characters i.e ``${"`"}``.    


{{<gencode>}}
