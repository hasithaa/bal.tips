---
title : Decimal Lang Library
description : The Ballerina Decimal lang library - `ballerina\lang.decimal` provides functions that operate on a `decimal` value.
date: 2023-06-01
weight : 11300
ballerina_type : [decimal]
ballerina_module : [decimal]
menu:
  main:
    name: "lang.decimal"
    parent: "module"
    pre: "<i class='bi bi-box'></i>"
    params:
        group: "langlib"
---

# Decimal Lang Library

`ballerina\lang.decimal` Lang Library provides utility functions for `decimal` type.

```ballerina {filename="decimal_lib.bal" lines="5-6 8-11" result="output" title="Decimal Lang Library"}
import ballerina/io; //!
//!
public function main() {
//!
    decimal x = 5.5; //$
    decimal y = -10.0; //$
//$
    decimal maxVal = decimal:max(x, y); //$
    decimal minVal = decimal:min(x, y); //$
    decimal absY = y.abs(); //$
    decimal roundVal = x.round(); //$
//!
    string output = string `ballerina/lang.decimal Functions: //!
    x: ${x} //!
    y: ${y} //!
    max(x, y): ${maxVal} //!
    min(x, y): ${minVal} //!
    abs(y): ${absY} //!
    round(x): ${roundVal} //!
    `; //!
    io:println(output); //!
}
```