---
title : String Literal
description : A string literal can be written by having the Unicode code points wrapped using two double quotes `"`.
date: 2023-01-01
weight : 6035
ballerina_type : [string]
ballerina_lang : [literal]
highlight : [string_literal.bal, string_escape.bal, numeric_escape.bal]
aliases :
- /examples/expr/literals/string-literal/
- /examples/expr/literals/string-escape/
menu:
  main:
    parent: syntax
    name: 'String Literal'
    params:
      group: "literals"
---

# String Literal

A string literal is used to create a string value. A string literal consists of a sequence of zero or more Unicode Code Points.

{{< cards >}}
{{<card header="✍ Syntax" title="Double Quoted String Literal" url="#DoubleQuotedStringLiteral">}}

`"` StringCharacters* `"`
{.tip-syntax}

Here `StringCharacters` is an Unicode Code Point except 0xA | 0xD | `\` | `"`  

{{</card>}}
{{<card header="✍ Syntax" title="String Escape" url="#string-escape">}}

`\t` | `\n` | `\r` | `\\` | `\"`
{.tip-syntax}

{{</card>}}
{{<card header="✍ Syntax" title="Numeric Escape" url="#numeric-escape">}}

`u{` Digit+ `}`
{.tip-syntax}

{{</card>}}
{{</cards>}}

## ✍ Syntax

### Double Quoted String Literal{id="DoubleQuotedStringLiteral"}

A string literal can be written by having the Unicode code points wrapped using two double quotes `"`.

`"` StringCharacters* `"`
{.tip-syntax}

Here `StringCharacters` is an Unicode Code Point except 0xA | 0xD | `\` | `"`  

```ballerina {filename="string_literal.bal" title="Double Quoted String Literal" result="output"}
import ballerina/io; //!
//!
public function main() {
//!
    string en = "Hello, World!"; //$
    string zh = "你好世界！"; //$
    string hi = "नमस्ते दुनिया!"; //$
    string si = "හෙලෝ වර්ල්ඩ්!"; //$
    string emoji = "👋🌏"; //$
//!
    io:println(en);     //!
    io:println(zh);     //!
    io:println(hi);     //!
    io:println(si);     //!
    io:println(emoji);  //!
}
```

### String Literal With Escape Characters

There are certain code points, that are not allowed inside a string literal. 
You can use String Escape or Numeric Escape syntaxes to provide such code points.

#### String Escape syntax {id="string-escape"}


`\t` | `\n` | `\r` | `\\` | `\"`
{.tip-syntax}

This syntax starts with `\`, then followed by one of `t`, `n`, `r`, `\`, `"` letters.

```ballerina {filename="string_escape.bal" title="String Escape Example" result="output"}
import ballerina/io; //!
//!
public function main() {
//!
    string tab = "tab :A\tB"; //$
    string newline = "newline :A\nB"; //$
    string carriageReturn = "carriageReturn :A\rB"; //$
    string backSlash = "backSlash :A\\B"; //$
    string doubleQuote = "doubleQuote :A\"B"; //$
//!
    io:println(tab);    //!
    io:println(newline);    //!
    io:println(carriageReturn); //!
    io:println(backSlash);  //!
    io:println(doubleQuote);    //!
}
```

### Numeric Escape syntax {id="numeric-escape"}

`u{` Digit+ `}`
{.tip-syntax}

This syntax starts with `u{`, then hexadecimal numeral of the code point, followed by `}`.
The hexadecimal numeral is an integer n where 0 ≤ n < 0xD800 or 0xDFFF < n ≤ 0x10FFFF.

```ballerina {filename="numeric_escape.bal" title="Numeric Escape Example" result="output"}
import ballerina/io; //!
//!
public function main() {
//!
    string tab = "tab :A\u{9}B"; //$
    string newline = "newline :A\u{A}B"; //$
    string carriageReturn = "carriageReturn :A\u{D}B"; //$
    string backSlash = "backSlash :A\u{5C}B"; //$
    string doubleQuote = "doubleQuote :A\u{22}B"; //$
//!
    io:println(tab);    //!
    io:println(newline);    //!
    io:println(carriageReturn); //!
    io:println(backSlash);  //!
    io:println(doubleQuote);    //!
}
```