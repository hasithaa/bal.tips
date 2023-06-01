---
title: Template Expressions
description: Template Syntax uses two `` ` `` backtick letters to enclose a string with interpolated expressions.
date : 2023-01-01
weight : 6050
ballerina_lang : [template]
aliases : 
    - /learn-syntax/expr/template/
menu:
  main:
    parent: syntax
    name: 'Templates'
    params:
      group: "expressions"
---

# Template Expressions

Template Syntax uses two `` ` `` backtick letters to enclose a string with interpolated expressions.

{{< cards >}}
{{<card header="✍ Syntax" title="Template Expression">}}

[Tag] `` ` `` BacktickItem* Dollar* `` ` ``
{.tip-syntax}

Here

* Tag = `string`|`xml`|`re`
* BacktickItem := BacktickSafeChar| BacktickDollarsSafeChar| Dollar* interpolation
* interpolation := `${` expression `}`
* BacktickSafeChar := ^ ( `` ` `` | `$` )
* BacktickDollarsSafeChar :=  `$`+ ^ ( `{` | `` ` ``  | `$`)
* Dollar := `$`
{.tip-syntax}

{{</card>}}
{{</cards>}}

## Template Kinds

Ballerina supports following template syntaxes:

| Template Expressions        | Example                  |
|-----------------------------|--------------------------|
| String Template             | ``string `Hello ${a}` `` |
| XML Template                | `` xml `<A>${a}</A>` ``  |
| Regular Expression Template | ``re `A.*?` ``           |
| Raw Data Template           | `` `A ${a} B` ``         |
{.table}

👉 Template Expression uses interpolated expressions. Let's say the expression you want to interpolate is `expr`, then interpolated expression is written as `${expr}`. The semantics of the interpolated expression depend on each template kind. See each kind for more details.
{.tip-note}
👉 [Byte Array Literal](../literals/byte-array) Syntax uses the same syntax as the Template expression, But it doesn't support interpolated expressions and is always a constant expression. Because of these reasons, it is more like a literal, than a template expression.   
{.tip-note}