---
title: Boolean Literal
description: Boolean literal syntax is used to write Boolean values. A boolean true is written as `true` and a boolean false is written as `false`.
date: 2023-01-01
weight : 6032
ballerina_type : [boolean]
ballerina_lang : [literal]
highlight : [boolean_literal.bal]
aliases : 
  - /examples/expr/literals/boolean-literal/
menu:
  main:
    parent: syntax
    name: 'Boolean Literal'
    params:
      group: "literals"
---

# Boolean Literal


The `boolean` basic type has only two values; boolean true is written as `true` and boolean false is written as `false`.

`true` and `false`
{.alert .alert-info}

Ballerina **doesn't** support `0`, `1` or any other variations of `true` or `false` words as alternative syntax. 

```ballerina {filename="boolean_literal.bal" lines="5 6"}
import ballerina/io; //!
//!
public function main() {
//!
    boolean enable = true; //$
    boolean open = false; //$
//!
    io:println(enable); //!
    io:println(open);   //!
}
```

**Code Breakdown**
{.tip-code-full}

* Line 5: boolean literal `true` is assigned to the variable `enable`.
* Line 6: boolean literal `false` is assigned to the variable `open`.
{.tip-code-full}