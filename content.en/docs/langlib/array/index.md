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

```ballerina {filename="lang_array.bal" lines="2 5-7"  result="output"}
import ballerina/io; //!
import ballerina/lang.array; //$
//$
public function main() {
    int[] numbers = [5, -2, 9, 1, 0, 8]; //$
    int length = numbers.length(); //$
    int? index = array:indexOf(numbers, 9); //$
    int[] sortedNumbers = array:sort(numbers);
    //!
    io:println("length: ", length); //!
    io:println("index: ", index); //!
    io:println("sortedNumbers: ", sortedNumbers); //!
}
```

💡 _array_ is not a pre-defined module prefix (because array is not a keyword).
To use it with function call syntax, you must have an `import ballerina/lang.array` declaration.
However, you can call these functions on a list value using the method call syntax.
{.tip-note}

## Functions

The graphical examples are for illustration purposes only and provide a visual aid to help understand the concept easily. They are not actual syntax.
{.tip-note}

### Stack and Queue Operations

{{<cards>}}
{{<card title="Pop">}}

Removes and returns the last element of the list. 

`[🍎, 🍇, 🍌, 🍓].pop()` ➜ `🍓`

The `pop` function removes and returns the last member of a given list. The arr argument specifies the list from which to remove the last member. The function returns the removed member.

{{</card>}}
{{<card title="Push">}}

Adds values to the end of an array.

`[🍎, 🍇, 🍌, 🍓].push(🍒, 🍉)` ➜ `[🍎, 🍌, 🍇, 🍓, 🍒, 🍉]`

The `push` function adds one or more values to the end of a given list. The _arr_ argument specifies the list to which the values will be added, and the _vals_ argument is a variable-length argument that can contain one or more values to add to the list.

{{</card>}}
{{<card title="Shift">}}

Removes and returns first member of an array.

`[🍎, 🍇, 🍌, 🍓].shift()` ➜ `🍎`

The `shift` function removes and returns the first member of a given list. The _arr_ argument specifies the list from which to remove the first member. The function returns the removed member.

{{</card>}}
{{<card title="Unshift">}}

Adds values to the start of an array. 

`[🍎, 🍇, 🍌, 🍓].unshift(🍒, 🍉)` ➜ `[🍒, 🍉, 🍎, 🍌, 🍇, 🍓]`

The `unshift` function adds one or more values to the start of a given list. The _arr_ argument specifies the list to which the values will be added, and the _vals_ argument is a variable-length argument that can contain one or more values to add to the list.

{{</card>}}
{{</cards>}}


```ballerina {filename="lang_array_stack_queue.bal" result="output" lines="4 7 10 14 18"}
import ballerina/io; //!

public function main() {
    int[] numbers = [1, 2, 3, 4, 5]; //$

    io:println("Numbers: ", numbers); //!
    numbers.push(6, 7); //$
    io:println("Numbers After Push: ", numbers); //!

    int last = numbers.pop(); //$
    io:println("Numbers After Pop: ", numbers); //!
    io:println("Last: ", last); //!

    int first = numbers.shift(); //$
    io:println("Numbers After Shift: ", numbers); //!
    io:println("First: ", first); //!

    numbers.unshift(-1, 0); //$
    io:println("Numbers After Unshift: ", numbers); //!
}
```
