---
title : String Literal
description : A string literal can be written by having the Unicode code points wrapped using two double quotes `"`.
date: 2023-01-01
weight : 6035
type : docs
ballerina_type : [string]
ballerina_lang : [literal]
highlight : [string-literal.bal, string-escape.bal, numeric-escape.bal]
aliases :
- /examples/expr/literals/string-literal/
- /examples/expr/literals/string-escape/
---

# String Literal

A string literal can be written by having the Unicode code points wrapped using two double quotes `"`.

<!--more-->

{{< md class="syntax" >}}
* String Literal, e.g. `"Hello World"`
{{< /md >}}

{{< code id="0" title="String literal" />}}

## String Literal With Escape Characters

There are certain code points, that are not allowed inside a string literal. 
You can use String Escape or Numeric Escape syntaxes to provide such code points.

### String Escape syntax

This syntax starts with `\`, then followed by one of `t`, `n`, `r`, `\`, `"` letters.

{{< code id="1" title="String escape syntax example" />}}

### Numeric Escape syntax

This syntax starts with `u{`, then hexadecimal numeral of the code point, followed by `}`.
The hexadecimal numeral is an integer n where 0 ≤ n < 0xD800 or 0xDFFF < n ≤ 0x10FFFF.

{{< code id="2" title="String numeric escape syntax example" />}}

Here is the summary.

{{< md class="post_element post_table center post_table_compact" >}}
| Name                     | Code Point | Correct Usage                                  |
|--------------------------|------------|------------------------------------------------|
| Line feed - LF, New Line | 0xA        | `string s1 = "\n";`<br>`string s2 = "\u{A}";`  |
| Carriage return - CR     | 0xD        | `string s1 = "\r";`<br>`string s2 = "\u{D}";`  |
| Tab                      | 0x9        | `string s1 = "\t";`<br>`string s2 = "\u{9}";`  |
| Backslash                | 0x5C       | `string s1 = "\\";`<br>`string s2 = "\u{5C}";` |
| Double quote             | 0x22       | `string s1 = "\"";`<br>`string s2 = "\u{22}";` |
{{< /md >}}
