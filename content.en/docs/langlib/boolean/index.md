---
title : Boolean Lang Library
description : The Ballerina Boolean lang library - `ballerina\lang.boolean` provides functions that operate on a `boolean` value.
date: 2023-01-01
weight : 11100
type : docs
ballerina_type : [boolean]
ballerina_module : [boolean]
menu:
  main:
    name: "lang.boolean"
    parent: "module"
    pre: "<i class='bi bi-box'></i>"
    params:
        group: "langlib"
---

# Boolean Lang Library

The Ballerina Boolean lang library ( `ballerina\lang.boolean` ) provides functions that operate on a `boolean` value.
As of now, it has only the `fromString` function.
See available operations in the [ballerina/lang.boolean](https://ballerina.io/spec/lang/master/#lang.boolean) module.

<!--more-->

```ballerina {filename="lang_boolean.bal" lines="5-6"  result="output"}
import ballerina/io; //!
//!
public function main() returns error? {
    boolean t1 = check boolean:fromString("true"); //$
    boolean f1 = check boolean:fromString("false"); //$
//!
    io:println("t1:", t1); //!
    io:println("f1:", f1); //!
}
```

💡 `boolean` is a keyword in Ballerina, and it is a pre-defined prefix.
Therefore, you can call boolean functions with the prefix even without an import declaration.
{.tip-note}
