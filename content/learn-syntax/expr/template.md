---
title : "Template Expressions"
date : 2022-07-31T07:56:53+05:30
kind : page 
tags : ["template"]
weight : 10606000000
---

Template Syntax uses two `` ` `` backtick letters to enclose a string with interpolated expressions. There are several variations of the [Template Expressions](https://ballerina.io/spec/lang/2022R1/#section_6.6) defined in the Language Specification. 

<!--more-->

Here is the summary.

{{<md class="center-ele center-txt tip-data">}}
Type | Description | Example
---|---|---
[*string template*](/tags/string-template/) | Constructs String values | ``string `Hello, ${name}` ``
[*xml template*](/tags/xml-template/) | Constructs XML values | ``xml `<name>${name}</name>` ``
[*raw template*](/tags/raw-template/) | Constructs object values<br> that subtype of<br> `object:RawTemplate` | `` `.. ${varA} ..` `` 
{{</md>}}

👉 Template Expression uses interpolated expressions. Let's say the expression you want to interpolate is `expr`, then interpolated expression is written as `${expr}`. The semantics of the interpolated expression depend on each template kind. See each kind for more details. 

👉 [*byte-array-literal*](/tags/byte-array-literal/) Syntax uses the same syntax as the Template expression, But it doesn't support interpolated expressions and is always a constant expression. Because of these reasons, it is more like a literal, than a template expression.   
<br/>
