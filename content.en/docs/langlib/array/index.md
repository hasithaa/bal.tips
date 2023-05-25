---
title : Array Lang Library
description : The Ballerina Array lang library - `ballerina/lang.array` provides functions that operate on list values, such as arrays and tuples.
date: 2023-01-01
weight : 11050
type : docs
ballerina_type : [list]
ballerina_lang : []
ballerina_module : [array]
menu:
  main:
    name: "lang.array"
    parent: "module"
    pre: "<i class='bi bi-box'></i>"
    params:
        group: "langlib"
---

# Array Lang Library

The Ballerina Array lang library - `ballerina/lang.array` provides functions that operate on list values, such as arrays and tuples.
See available operations in the [ballerina/lang.boolean](https://ballerina.io/spec/lang/master/#lang.boolean) module.

<!--more-->

💡 _array_ is not a pre-defined module prefix (because array is not a keyword).
To use it with function call syntax, you must have an `import ballerina/lang.array` declaration.
However, you can call these functions on a list value using the method call syntax.
{.tip-note}

```ballerina {filename="lang_array.bal" lines="2 5-7"  result="output"}
import ballerina/io;
import ballerina/lang.array; //$

public function main() {
    int[] numbers = [5, -2, 9, 1, 0, 8]; //$
    int length = numbers.length(); //$
    int? index = array:indexOf(numbers, 9); //$
    int[] sortedNumbers = array:sort(numbers);

    io:println("length: ", length); //!
    io:println("index: ", index); //!
    io:println("sortedNumbers: ", sortedNumbers); //!
}
```

## Definitions

The graphical examples are for illustration purposes only and provide a visual aid to help understand the concept easily. They are not actual syntax.
{.tip-note}