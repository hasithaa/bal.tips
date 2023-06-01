---
title : Boolean Data Type
description : "The Boolean data type represents boolean truth values: `true` and `false`."
date: 2023-01-01
weight : 5015
type : docs
ballerina_type : [boolean]
ballerina_lang : [type, literal]
ballerina_module : [boolean]
highlight : [boolean_literal.bal, boolean_fromString.bal, boolean_lang_support.bal, boolean_lib.bal, boolean_toString.bal]
aliases :
  - /types/simple/boolean/
menu: 
  main:
    parent: types
    name: 'Boolean'
    params:
      group: "simple"
---

# Boolean Data Type

The Boolean data type represents boolean truth values: `true` and `false`. You may use boolean values to represent various conditions in your program. For example, you can use a boolean value to represent whether a file exists or not, whether a user is logged in or not, etc. Use-cases of boolean values are endless.

{{<cards>}}
{{<card header="✍ Syntax" >}}
`boolean`
{.tip-syntax}

{{</card>}}
{{</cards>}}

## ✍ Syntax

Boolean type is written as `boolean`. We use the Boolean literal syntax to write Boolean values.
A boolean true is written as `true` and a boolean false is written as `false`.
In Ballerina,`0`, `1`, or any other variations of `true` or `false` words are not supported as alternative syntax.

```ballerina {filename="boolean_literal.bal" lines="5 6" result="output" title="Boolean Literal"}
import ballerina/io; //!
//!
public function main() {
//!
    boolean truth = true; //$
    boolean falseValue = false; //$
//!
    io:println(string `Boolean Literal - Truth: ${truth}, False: ${falseValue}`); //!
}
```

## Value Creation

In addition to the Boolean literal syntax, we can create a Boolean value using following methods.
* `boolean:fromString` - Create a Boolean value from a String.
* Boolean Expression - The result of a Boolean expression is a Boolean value. (See next section)

```ballerina {filename="boolean_fromString.bal" lines="5 6" result="output" title="Creating a Boolean Value from a string"}
import ballerina/io; //!
//!
public function main() returns error? {
//!
    boolean fromStringTrue = check boolean:fromString("true"); //$
    boolean fromStringFalse = check boolean:fromString("false"); //$
//!
    io:println(string `Boolean fromString - True: ${fromStringTrue}, False: ${fromStringFalse}`); //!
}
```

# Properties and Operations

`boolean` values do not have a storage identity, so they are inherently immutable
(once created, it is not possible to change the content of the value).
Therefore, they can be assigned to a `readonly` variable.

The `boolean` type part of the `anydata` and `json`. Also, it is an ordered type.

In Ballerina, boolean values are used in many operations and statements.
Here are some of those. I will discuss these operations in detail in later posts.

* Unary logical expression - `! x`
* The result of a Relational expression - `x < y`, `x > y`, `x <= y`, `x >= y`
* The result of an Equality expression - `x == y`, `x != y`, `x === y`, `x !=== y`
* Logical expression - `x | y`, `x && y`, `x || y`
* `if` statement
* Conditional expression `x ? y : z`
* `match` statement (in match guard expression)
* `while` statement
* For writing Transactional Retry Managers

```ballerina {filename="boolean_lang_support.bal" lines="9-11 19-28 35 41 45" result="output" title="Boolean Usage Examples" trim=false}
import ballerina/io; //!
//!
function demoSupportedOperations() {
//!
    boolean x = true; //$
    boolean y = false; //$
//!
    string output = string `Logical Operators: //$
    x && y: ${x && y} //$
    x || y: ${x || y} //$
    !x: ${!x} //$
    `; //$
    io:println(output); //!
//$
    int a = 5; //$
    int b = 10; //$
//!
    output = string `Various Boolean Expressions: //$
    a == b: ${a == b} //$
    a != b: ${a != b} //$
    a < b: ${a < b} //$
    a <= b: ${a <= b} //$
    a > b: ${a > b} //$
    a >= b: ${a >= b} //$
    a === b: ${a === b} //$
    a !== b: ${a !== b} //$
    a is b: ${a is int} //$
    a !is b: ${b !is int} //$
    `; //$
    io:println(output); //!
}
//$
function demoLanguageUsage(boolean isTrue = true) {
//!
    if isTrue { //$
        io:println("If Statement: It's true"); //!
    } else { //$
        io:println("If Statement: It's false"); //!
    } //$
//$
    string result = isTrue ? "It's true" : "It's false"; //$
    io:println("Ternary Expression: ", result); //!
//$
    int i = 0;
    while i < 5 { // This boolean expression is used to determine whether to continue looping or not. //$
        io:println("While Loop Iteration: ", i); //!
        i = i + 1;
    } //$
}

public function main() returns error? { //!
    demoSupportedOperations(); //!
    demoLanguageUsage(); //!
} //!
```

# Language Library - `ballerina/lang.boolean`

`ballerina\lang.boolean` Lang Library provides functions that operate on a `boolean` value. 
See available operations with examples in [Boolean Lang Library]({{% relref "/docs/langlib/boolean" %}}).

```ballerina {filename="boolean_lib.bal" lines="5 6" result="output" title="Boolean Lang Library"}
import ballerina/io; //!
//!
public function main() returns error? {
//!
    boolean fromStringTrue = check boolean:fromString("TRUE"); //$
    boolean fromStringFalse = check boolean:fromString("FALSE"); //$
//!
    string output = string `Boolean Lang Library Functions: //!
    fromString("TRUE"): ${fromStringTrue} //!
    fromString("FALSE"): ${fromStringFalse} //!
    `; //!
    io:println(output); //!
}
```

Additionally, `ballerina/lang.value` Lang Library provides `toString` and another set of functions that can operate on a `boolean` value.

## ToString Behavior

```ballerina {filename="boolean_toString.bal" lines="7-10" result="output" title="Boolean toString Behavior"}
import ballerina/io; //!
//!
public function main() {
//!
    boolean trueValue = true; //$
    boolean falseValue = false; //$
    string trueString = trueValue.toString(); //$
    string falseString = falseValue.toString(); //$
    string trueJsonString = trueValue.toJsonString(); //$
    string falseJsonString = falseValue.toJsonString(); //$
//!
    string output = string `ToString Behavior: //!
    True to String: ${trueString} //!
    False to String: ${falseString} //!
    True to Json String: ${trueJsonString} //!
    False to Json String: ${falseJsonString} //!
    `; //!
    io:println(output); //!
}
```
