---
title : "Template Expressions"
date : 2022-07-31T07:56:53+05:30
kind : page 
tags : ["expr", "template"]
tips : ["template"]
view : card
weight : 10606000000
---

|Template Expressions||
|---|---|
|``string `Hello ${a}` ``   |{{< tag "string-template">}}|
|`` xml `<A>${a}</A>` ``    |{{< tag "xml-template">}}|
|``re `A.*?` ``             |{{< tag "tagged-data-template">}} |
|`` `A ${a} B` ``           |{{< tag "raw-template">}}|

<!--more-->

Template Syntax uses two `` ` `` backtick letters to enclose a string with interpolated expressions. 

👉 Template Expression uses interpolated expressions. Let's say the expression you want to interpolate is `expr`, then interpolated expression is written as `${expr}`. The semantics of the interpolated expression depend on each template kind. See each kind for more details. 

👉 {{< tag "byte array literal" >}} Syntax uses the same syntax as the Template expression, But it doesn't support interpolated expressions and is always a constant expression. Because of these reasons, it is more like a literal, than a template expression.   
<br/>
