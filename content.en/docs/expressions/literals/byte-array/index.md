---
title: Byte Array Literal
description: "Byte Array Literal is a sequence of bytes represented in base16 or base64."
date: 2023-01-01
weight: 6036
ballerina_type: [byte]
ballerina_lang: [literal]
highlight: [Base16Literal.bal, Base64Literal.bal]
aliases :
  - /examples/expr/literals/base16literal/
  - /examples/expr/literals/base64literal/
menu:
  main:
    parent: syntax
    name: 'Byte Array Literal'
    params:
      group: "literals"
---

# Byte Array Literal

Byte Array Literal is a sequence of bytes represented in base16 or base64.

{{<cards>}}
{{<card header="✍ Syntax" title="Base16 Byte Array Literal" url="#base16-byte-array-literal">}}

`base16` `` ` ``&lt;hex-digit&gt;*`` ` ``
{.tip-syntax}

You can use Base16 Byte Array Literal syntax to represent bytes in Hex textual form.
{{</card>}}
{{<card header="✍ Syntax" title="Base64 Byte Array Literal" url="#base64-byte-array-literal">}}

`base64` `` ` ``&lt;base64-char&gt;*`` ` ``
{.tip-syntax}

You can use Base64 Byte Array Literal syntax to represent bytes in Base64 encoded form.
{{</card>}}
{{</cards>}}

## ✍ Syntax{id=syntax}

There are two types of Byte Array Literals. Base16 Byte Array Literal and Base64 Byte Array Literal. Additionally, you can use Array Constructor Expression to create a byte array. But instead of writing bytes in textual form, you need to write bytes in decimal form in Array Constructor Expression, which is not convenient for writing long list of bytes.

### Base16 Byte Array Literal{id="base16-byte-array-literal"}

You can use Base16 Byte Array Literal syntax to represent bytes in Hex textual form.

`base16` `` ` ``&lt;hex-digit&gt;*`` ` ``
{.tip-syntax}

- Base16 Literal uses Hex Digits; `0`, `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `a` or `A`, `b` or `B`, `c` or `C`, `d` or `D`, `e` or `E`, `f` or `F`.
    - In regex form, `A..F` | `a..f` | `0..9`
- You need two Hex digits to represent a byte.
    - One hex digits represent 4 bits. i.e . `0` -> `0000`, `9` -> `1001`, `A` -> `1010`, F -> `1111`
    - So `0A` in hex means `0000 1010` which equals byte value 10. Similarly `11` -> `0001 0001`(17), `AB` -> `1010 1011`(171)
- You can have any white space in between two Hex Digits.
    - Group Hex Digits to improve the readability of your code.
    - Writing Hex digits in pairs or even numbers is a good option. 

```ballerina {filename="Base16Literal.bal" lines="5-10" result="output"}
import ballerina/io; //!
//!
public function main() {

    byte[] a = base16 `11AB22CD`; //$
    byte[] b = base16 `c3 d4 e5 f6`; //$
    byte[] c = base16 ` 55 EE 66 FF
                      77 AB 88 CD
                      99 EF 00 AA
                    `;
//!
    io:println(a);  //!
    io:println(b);  //!
    io:println(c);  //!
}
```

### Base64 Byte Array Literal{id="base64-byte-array-literal"}

You can use Base64 Byte Array Literal syntax to represent bytes in Base64 encoded form.

`base64` `` ` ``&lt;base64-char&gt;*`` ` ``
{.tip-syntax}

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

```ballerina {filename="Base64Literal.bal" lines="5-9" result="output"}
import ballerina/io; //!
//!
public function main() {

    byte[] a = base64 `AAAB`; //$
    byte[] b = base64 `ABB=`; //$
    byte[] c = base64 `BC==`;
    byte[] d = base64 `ABCD pqrs
                     5678 +/12`;
//!
    io:println(a);  //!
    io:println(b);  //!
    io:println(c);  //!
    io:println(d);  //!
}
```

# Base64 to Byte Array Explained

Inorder to understand the Base64 to Byte Array conversion, let's refresh our memory on how Base64 encoding works. Following table shows the Base64 encoding table.

| #   | Char | Bits   | #   | Char | Bits   | #   | Char | Bits   | #   | Char | Bits   |
|-----|------|--------|-----|------|--------|-----|------|--------|-----|------|--------|
| 0   | A    | 000000 | 16  | Q    | 010000 | 32  | g    | 100000 | 48  | w    | 110000 |
| 1   | B    | 000001 | 17  | R    | 010001 | 33  | h    | 100001 | 49  | x    | 110001 |
| 2   | C    | 000010 | 18  | S    | 010010 | 34  | i    | 100010 | 50  | y    | 110010 |
| 3   | D    | 000011 | 19  | T    | 010011 | 35  | j    | 100011 | 51  | z    | 110011 |
| 4   | E    | 000100 | 20  | U    | 010100 | 36  | k    | 100100 | 52  | 0    | 110100 |
| 5   | F    | 000101 | 21  | V    | 010101 | 37  | l    | 100101 | 53  | 1    | 110101 |
| 6   | G    | 000110 | 22  | W    | 010110 | 38  | m    | 100110 | 54  | 2    | 110110 |
| 7   | H    | 000111 | 23  | X    | 010111 | 39  | n    | 100111 | 55  | 3    | 110111 |
| 8   | I    | 001000 | 24  | Y    | 011000 | 40  | o    | 101000 | 56  | 4    | 111000 |
| 9   | J    | 001001 | 25  | Z    | 011001 | 41  | p    | 101001 | 57  | 5    | 111001 |
| 10  | K    | 001010 | 26  | a    | 011010 | 42  | q    | 101010 | 58  | 6    | 111010 |
| 11  | L    | 001011 | 27  | b    | 011011 | 43  | r    | 101011 | 59  | 7    | 111011 |
| 12  | M    | 001100 | 28  | c    | 011100 | 44  | s    | 101100 | 60  | 8    | 111100 |
| 13  | N    | 001101 | 29  | d    | 011101 | 45  | t    | 101101 | 61  | 9    | 111101 |
| 14  | O    | 001110 | 30  | e    | 011110 | 46  | u    | 101110 | 62  | +    | 111110 |
| 15  | P    | 001111 | 31  | f    | 011111 | 47  | v    | 101111 | 63  | /    | 111111 |
{.tip-table .text-center}

Let's look at the following examples.

## Example 1: ``base64 `AAAB` ``

<table class="tip-table text-center">
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


## Example 2: ``base64 `ABB=` ``

<table class="tip-table text-center">
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

## Example 3: ``base64 `BC==` ``

<table class="tip-table text-center">
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



## Known Limitations in JBallerina

- [The byte array type is not inferred properly](https://github.com/ballerina-platform/ballerina-lang/issues/32542)