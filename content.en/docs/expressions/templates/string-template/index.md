---
title : String Template
description : A String template expression constructs a string value using the Template expression.
date: 2023-01-01
weight : 6052
type : docs
ballerina_type : [string]
ballerina_lang : [template]
highlight : [template.bal, template-special.bal]
aliases :
  - /examples/expr/string-template/string-template/
---

# String Template Expression

A String template expression constructs a string value using the Template expression. Support interpolation (Syntax `${expr}`) and each interpolation expression must have a type that is a subtype of `boolean|int|float|decimal|string`. You can use this expression in places where you use string concatenation, or you need to build multi-line string values.   

<!--more-->

{{< md class="syntax">}}

* Syntax - e.g., `` string `Hello ${a}` ``

{{< /md >}}

{{< code id="0" title="String Template Expression Example" />}}

## How String Interpolation works

* Step 1 - Take every character that is not part of the interpolation within the two `` ` `` Backtick, including newline, CR, etc. These characters are sliced based on interpolation expression positions. 
* Step 2- Evaluate each interpolation expression in the order in which they were written. Then Take the string representation of the values, by using the `value:toString()` lang-lib function.
* Step 3 - Construct the final string value interleaving Step 1 and Step 2 results.   

## Special Cases

{{< code id="1" title="String Template Special Cases" />}}

* 🚫 Unlike [*string-literal*](/tags/string-literal/), String Template doesn't support escape characters.    
* ✅ Use [*string-literal*](/tags/string-literal/) with interpolation to type such characters i.e ``${"`"}``.    

🚧 More Details Coming Soon!
