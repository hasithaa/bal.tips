---
title: "Literals"
description: A literal is a value that is specified directly in the source code.
date : 2023-01-01
weight : 6030
type : docs
bookToc: true
images: [/docs/expressions/literals/numeric-algo.png]
ballerina_lang : [literal]
highlight : [numeric-literals.bal]
bookCollapseSection : true
aliases : 
  - /learn-syntax/expr/literals/
  - /examples/expr/literals/numeric-literals/
---

# Literals

A literal is a value that is specified directly in the source code. 
<!--more-->
Ballerina supports the following literals.

{{< md class="post_table center">}}

| Literals               | Example                                          |
|------------------------|--------------------------------------------------|
| Nil Literal            | `()`, `null`                                     |
| Boolean Literal        | `true` or `false`                                |
| Integer Literal        | `123`, `0x1A`                                    |
| Floating Point Literal | `456.78`, `12.3f`, `12.3d`, `1.23e3`, `0X1a.A`   |
| String Literal         | `"Hello, World!"`                                |
| Byte Array Literal     | ``base16 `AB 12 34` `` <br/>  ``base64 `A1z+` `` |

{{< /md >}}
{{< section >}}

# Deciding the Numerical Literal's type (Advanced)

A value written in a numeric literal always represents a specific type, which is determined by the literal itself. The type of a literal can be one of the basic types, such as int, float, or decimal.

For example, the literal 10 represents the integer value 10, and its type is int. However, in some contexts, the same literal 10 can also represent a floating-point value 10.0 or a decimal value 10. Depending on the context, the compiler determines the appropriate type of the literal to be used.

{{< code id="0" title="Numeric literal type" >}}
{{< highlight >}}
📌:::7 ::: `a1`'s type is `int`.
📌:::8 ::: `a2`'s type is singleton integer 10.
📌:::9 ::: You can use integer literal `10` as a floating point literal `10.0`.
📌:::10::: You can use integer literal `10` as a decimal literal `10`.
📌:::11::: `a5`'s type is `float`. This is inferred from the type checking algorithm.
📌:::12::: `a6`'s type is `float`. This is inferred from the type checking algorithm.
{{</ highlight >}}
{{< /code >}}

When determining the type of a literal, following 3 steps [algorithm](https://ballerina.io/spec/lang/master/#numeric-literal) is used.

{{<figure src="/docs/expressions/literals/numeric-algo.svg" alt="Type checking Algorithm - Numeric Literal" title="Type checking Algorithm - Numeric Literal">}}
