---
title: Template Expressions
description: Template Syntax uses two `` ` `` backtick letters to enclose a string with interpolated expressions.
date : 2023-01-01
weight : 6050
type : docs
bookToc: true
ballerina_lang : [template]
highlight : []
bookCollapseSection : true
aliases : 
    - /learn-syntax/expr/template/
---

# Template Expressions

Template Syntax uses two `` ` `` backtick letters to enclose a string with interpolated expressions.

<!--more-->

Ballerina supports following template syntaxes:

{{<md class="post_table center">}}

| Template Expressions        | Example                  |
|-----------------------------|--------------------------|
| String Template             | ``string `Hello ${a}` `` |
| XML Template                | `` xml `<A>${a}</A>` ``  |
| Regular Expression Template | ``re `A.*?` ``           |
| Raw Data Template           | `` `A ${a} B` ``         |

{{</md>}}

{{< section >}}

## Tips

👉 Template Expression uses interpolated expressions. Let's say the expression you want to interpolate is `expr`, then interpolated expression is written as `${expr}`. The semantics of the interpolated expression depend on each template kind. See each kind for more details.

👉 [Byte Array Literal](../literals/byte-array) Syntax uses the same syntax as the Template expression, But it doesn't support interpolated expressions and is always a constant expression. Because of these reasons, it is more like a literal, than a template expression.   

🚧 More Details Coming Soon!
