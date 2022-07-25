---
title : "String Escape Chars"
date : 2022-07-25T21:54:33+05:30
kind : tip 
tags : ["literal", "string", "StringEscape", "NumericEscape"] 
code : ["string-escape.bal", "numeric-escape.bal"] 
weight : 0503010002 
size : "small" 
disableNavChevron : true
seeMore : true
---

There are certain code points, that are not allowed inside a string literal. You can use String Escape or Numeric Escape syntaxes to provide such code points.

<!--more-->

- String Escape syntax starts with `\`, then followed by one of `t`, `n`, `r`, `\`, `"` letters.
- Numeric Escape syntax starts with `u{`, then hexadecimal numeral of the code point, followed by `}`. The hexadecimal numeral is an integer n where 0 ≤ n < 0xD800 or 0xDFFF < n ≤ 0x10FFFF.

{{< gencode >}}

Here is the summary.

<table>
<tr>
<th>Name</th>
<th>Code Points</th>
<th>Incorrect Usage</th>
<th>Correct Usage</th>
</tr>
<tr>
  <td>Line feed - LF, New Line</td>
  <td>0xA</td>
  <td>{{<md>}}
  ```
  string s = "
";
  ```
  {{</md>}}</td>
  <td>{{<md>}}
  ```
  string s1 = "\n";
  string s2 = "\u{A}";
  ```
  {{</md>}}</td>
<tr>
<tr>
  <td>Carriage return - CR</td>
  <td>0xD</td>
  <td>{{<md>}}
  ```
  string s = "
";
  ```
  {{</md>}}</td>
  <td>{{<md>}}
  ```
  string s1 = "\r";
  string s2 = "\u{D}";
  ```
  {{</md>}}</td>
<tr>
<tr>
  <td>Reverse Solidus, BackSlash</td>
  <td>{{<md>}}`\`{{</md>}} - 0x5C</td>
  <td>{{<md>}}
  ```
  string s = "\";
  ```
  {{</md>}}</td>
  <td>{{<md>}}
  ```
  string s1 = "\\";
  string s2 = "\u{5C}";
  ```
  {{</md>}}</td>
<tr>
<tr>
  <td>Double Quote/Quotation Mark</td>
  <td>{{<md>}}`"`{{</md>}} - 0x22</td>
  <td>{{<md>}}
  ```
  string s = """;
  ```
  {{</md>}}</td>
  <td>{{<md>}}
  ```
  string s1 = "\"";
  string s2 = "\u{22}";
  ```
  {{</md>}}</td>
<tr>
<tr>
</table>
