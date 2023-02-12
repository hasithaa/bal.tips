---
title : Byte Array Literal
description : "Byte Array Literal is a sequence of bytes represented in base16 or base64."
date: 2023-01-01
weight : 6035
type : docs
ballerina_type : [byte]
ballerina_lang : [literal]
highlight : [Base16Literal.bal, Base64Literal.bal]
aliases :
  - /examples/expr/literals/base16literal/
  - /examples/expr/literals/base64literal/
---

# Byte Array Literal

Byte Array Literal is a sequence of bytes represented in base16 or base64.

<!--more-->

{{<md class="syntax">}}

* Base16 Literal: e.g., ``base16 `AB 12 34` `` 
* Base64 Literal: e.g., ``base64 `A1z+` ``

{{</md>}}

{{< code id="0" title="Base16 Literal" >}}

{{</md>}}

## Base16 Byte Array Literal

You can use Base16 Byte Array Literal syntax to represent bytes in Hex textual form.

- Base16 Literal uses Hex Digits; `0`, `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `a` or `A`, `b` or `B`, `c` or `C`, `d` or `D`, `e` or `E`, `f` or `F`.
    - In regex form, `A..F` | `a..f` | `0..9`
- You need two Hex digits to represent a byte.
    - One hex digits represent 4 bits. i.e . `0` -> `0000`, `9` -> `1001`, `A` -> `1010`, F -> `1111`
    - So `0A` in hex means `0000 1010` which equals byte value 10. Similarly `11` -> `0001 0001`(17), `AB` -> `1010 1011`(171)
- You can have any white space in between two Hex Digits.
    - Group Hex Digits to improve the readability of your code.
    - Writing Hex digits in pairs or even numbers is a good option. 

{{< code id="0" title="Base16 Byte Array Literal" />}}

## Base64 Byte Array Literal

You can use Base64 Byte Array Literal syntax to represent bytes in Base64 encoded form.

- Base64 Literal uses Base64 alphabet; `A..Z` | `a..z` | `0..9` | `+` | `/`
    - Total 64 characters = 26 Uppercase Letters + 26 Lowercase Letters + 10 numbers + 2 chars.
    - Each Base64 character represents 6 bits.
    - The [Encoding table](#base-64-encoding-table) is the same as RFC 4648.

- You need four Base64 characters to represent 3 bytes.
    - 4 x 6 bits = 24 bits = 3 bytes
- The length of Base64 literal must be a multiple of four.
    - You can add one or two padding characters `=` to make its length multiple of 4.
    - Single `=` means the last four characters will represent only two bytes.
    - `==` means the last four characters will represent only one byte.
    - `=` or `==` always comes at the end of the literal.
- You can have any white space in between two Base64 Characters.
    - Group Base64 Characters to improve the readability of your code.
    - Writing Base64 Characters in a group of 4 characters is a good option.

{{< code id="1" title="Base64 Byte Array Literal" />}}

### Base64 to Byte Array Explained

Inorder to understand the Base64 to Byte Array conversion, let's refresh our memory on how Base64 encoding works.

{{< details title="Base64 Encoding Table" open=true >}}
{{< md class="post_table center post_table_compact" >}}

| #   | Char | Bits   |     | #   | Char | Bits   |
|-----|------|--------|-----|-----|------|--------|
| 0   | A    | 000000 |     | 32  | g    | 100000 |
| 1   | B    | 000001 |     | 33  | h    | 100001 |
| 2   | C    | 000010 |     | 34  | i    | 100010 |
| 3   | D    | 000011 |     | 35  | j    | 100011 |
| 4   | E    | 000100 |     | 36  | k    | 100100 |
| 5   | F    | 000101 |     | 37  | l    | 100101 |
| 6   | G    | 000110 |     | 38  | m    | 100110 |
| 7   | H    | 000111 |     | 39  | n    | 100111 |
| 8   | I    | 001000 |     | 40  | o    | 101000 |
| 9   | J    | 001001 |     | 41  | p    | 101001 |
| 10  | K    | 001010 |     | 42  | q    | 101010 |
| 11  | L    | 001011 |     | 43  | r    | 101011 |
| 12  | M    | 001100 |     | 44  | s    | 101100 |
| 13  | N    | 001101 |     | 45  | t    | 101101 |
| 14  | O    | 001110 |     | 46  | u    | 101110 |
| 15  | P    | 001111 |     | 47  | v    | 101111 |
| 16  | Q    | 010000 |     | 48  | w    | 110000 |
| 17  | R    | 010001 |     | 49  | x    | 110001 |
| 18  | S    | 010010 |     | 50  | y    | 110010 |
| 19  | T    | 010011 |     | 51  | z    | 110011 |
| 20  | U    | 010100 |     | 52  | 0    | 110100 |
| 21  | V    | 010101 |     | 53  | 1    | 110101 |
| 22  | W    | 010110 |     | 54  | 2    | 110110 |
| 23  | X    | 010111 |     | 55  | 3    | 110111 |
| 24  | Y    | 011000 |     | 56  | 4    | 111000 |
| 25  | Z    | 011001 |     | 57  | 5    | 111001 |
| 26  | a    | 011010 |     | 58  | 6    | 111010 |
| 27  | b    | 011011 |     | 59  | 7    | 111011 |
| 28  | c    | 011100 |     | 60  | 8    | 111100 |
| 29  | d    | 011101 |     | 61  | 9    | 111101 |
| 30  | e    | 011110 |     | 62  | +    | 111110 |
| 31  | f    | 011111 |     | 63  | /    | 111111 |
{{</md>}}
{{</details>}}

Let's look at the following examples.


Example 1: ``base64 `AAAB` ``

{{< md class="post_table center post_table_compact" >}}
<table>
  <tr>
    <td>Base64</td>
    <td colspan="6">A</td>
    <td colspan="6">A</td>
    <td colspan="6">A</td>
    <td colspan="6">B</td>
  </tr>
  <tr>
    <td>Index</td>
    <td colspan="6">0</td>
    <td colspan="6">0</td>
    <td colspan="6">0</td>
    <td colspan="6">1</td>
  </tr>
  <tr>
    <td>Bit pattern</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>1</td>
  </tr>
  <tr>
    <td>Byte</td>
    <td colspan="8">0000 0000</td>
    <td colspan="8">0000 0000</td>
    <td colspan="8">0000 00001</td>
  </tr>
  <tr>
    <td>Ballerina byte</td>
    <td colspan="8">0</td>
    <td colspan="8">0</td>
    <td colspan="8">1</td>
  </tr>
</table>
{{</md>}}

Example 2: ``base64 `ABB=` ``
{{< md class="post_table center post_table_compact" >}}
<table>
  <tr>
    <td>Base64</td>
    <td colspan="6">A</td>
    <td colspan="6">B</td>
    <td colspan="6">B</td>
    <td colspan="6">=</td>
  </tr>
  <tr>
    <td>Index</td>
    <td colspan="6">0</td>
    <td colspan="6">1</td>
    <td colspan="6">1</td>
    <td colspan="6">X</td>
  </tr>
  <tr>
    <td>Bit pattern</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>1</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>1</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>
  </tr>
  <tr>
    <td>Byte</td>
    <td colspan="8">0000 0000</td>
    <td colspan="8">0001 0000</td>
    <td colspan="8">x</td>
  </tr>
  <tr>
    <td>Ballerina byte</td>
    <td colspan="8">0</td>
    <td colspan="8">16</td>
    <td colspan="8"></td>
  </tr>
</table>
{{</md>}}

Example 3: ``base64 `BC==` ``

{{< md class="post_table center post_table_compact" >}}
<table>
  <tr class>
    <td>Base64</td>
    <td colspan="6">B</td>
    <td colspan="6">C</td>
    <td colspan="6">=</td>
    <td colspan="6">=</td>
  </tr>
  <tr>
    <td>Index</td>
    <td colspan="6">1</td>
    <td colspan="6">2</td>
    <td colspan="6">X</td>
    <td colspan="6">X</td>
  </tr>
  <tr>
    <td>Bit pattern</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>1</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>1</td><td>0</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>
    <td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td>
  </tr>
  <tr>
    <td>Byte</td>
    <td colspan="8">0000 0100</td>
    <td colspan="8">X</td>
    <td colspan="8">X</td>
  </tr>
  <tr>
    <td>Ballerina byte</td>
    <td colspan="8">4</td>
    <td colspan="8"></td>
    <td colspan="8"></td>
  </tr>
</table>
{{</md>}}


# Known Limitations in JBallerina

- [The byte array type is not inferred properly](https://github.com/ballerina-platform/ballerina-lang/issues/32542)