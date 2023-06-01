---
title : Float Lang Library
description : The Ballerina Float lang library - `ballerina\lang.float` provides functions that operate on a `float` value.
date: 2023-06-01
weight : 11350
ballerina_type : [float]
ballerina_module : [float]
menu:
  main:
    name: "lang.float"
    parent: "module"
    pre: "<i class='bi bi-box'></i>"
    params:
        group: "langlib"
---

# Float Lang Library

`ballerina\lang.float` Lang Library provides utility functions for `float` type.

```ballerina {filename="float_lib.bal" lines="5-6 8-11" result="output" title="Float Lang Library"}
import ballerina/io; //!
//!
public function main() {
//!
    float x = 5.5; //$
    float y = -10.0; //$
 //$
    float maxVal = float:max(x, y); //$
    float minVal = float:min(x, y); //$
    float absY = y.abs(); //$
    float roundVal = x.round(); //$

    string output = string `ballerina/lang.float Functions: //!
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