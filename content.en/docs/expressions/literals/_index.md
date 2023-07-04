---
title: "Literals"
description: A literal is a value that is specified directly in the source code.
date : 2023-01-01
weight : 6030
ballerina_lang : [literal]
highlight : [numeric-literals.bal]
aliases : 
  - /learn-syntax/expr/literals/
  - /examples/expr/literals/numeric-literals/
menu:
  main:
    parent: syntax
    name: 'Literal'
    params:
      group: "expressions"
---

# Literals

A literal is a value that is specified directly in the source code. Ballerina supports the following literals.

| Literals               | Examples                                          |
| ---------------------- | ------------------------------------------------ |
| Nil Literal            | `()`, `null`                                     |
| Boolean Literal        | `true` or `false`                                |
| Integer Literal        | `123`, `0x1A`                                    |
| Floating Point Literal | `456.78`, `12.3f`, `12.3d`, `1.23e3`, `0X1a.A`   |
| String Literal         | `"Hello, World!"`                                |
| Byte Array Literal     | ``base16 `AB 12 34` `` <br/>  ``base64 `A1z+` `` |
{.tip-table}

# Inferring the Type of a Numeric Literal - The Algorithm.

This topic has been moved to its [own page](/docs/types/rules/numeric-literals/) to make it easier to find.
{.tip-note .note-warning}