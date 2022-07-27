---
title : "Base16 Byte Array Literal"
date : 2022-07-25T22:52:46+05:30
kind : tip 
tags : ["literal", "byte-array-literal", "byte", "Base16Literal"]
code : ["Base16Literal.bal"]
weight : 0605050001
size : "small"
disableNavChevron : true 
seeMore : true
---

You can use Base16 Byte Array Literal syntax to represent bytes in Hex textual form.

<!--more-->

- Base16 Literal uses Hex Digits; `0`, `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `a` or `A`, `b` or `B`, `c` or `C`, `d` or `D`, `e` or `E`, `f` or `F`. 
  - In regex form, `A..F` | `a..f` | `0..9`
- You need two Hex digits to represent a byte.
  - One hex digits represent 4 bits. i.e . `0` -> `0000`, `9` -> `1001`, `A` -> `1010`, F -> `1111`
  - So `0A` in hex means `0000 1010` which equals byte value 10. Similarly `11` -> `0001 0001`(17), `AB` -> `1010 1011`(171) 
- You can have any white space in between two Hex Digits. 
  - Group Hex Digits to improve the readability of your code. 
  - Writing Hex digits in pairs or even numbers is a good option. 

{{< gencode >}}

#### Known Limitation. 

- [The byte array type is not inferred properly](https://github.com/ballerina-platform/ballerina-lang/issues/32542)