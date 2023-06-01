---
title : Nil Literal
description : Nil literal uses the syntax `()` and `null`.
date: 2023-01-01
weight : 6031
ballerina_type : [()]
ballerina_lang : [literal]
highlight : [nil_literal.bal]
aliases : 
  - /examples/expr/literals/nil-literal/
  - /examples/expr/literals/null-literal/
menu:
  main:
    parent: syntax
    name: 'Nil Literal'
    params:
      group: "literals"
---

# Nil Literal

The `nil` basic type has only a single value called `nil`. Nil literal uses the syntax `()` and `null`.
    
{{< cards >}}
{{<card header="✍ Syntax" title="Nil Literal">}}

`()` | `null`
{.tip-syntax}

{{</card>}}
{{</cards>}}
    
```ballerina {filename="nil_literal.bal" lines="5 6" result="output"}
import ballerina/io; //!
//!
public function main() {
//!
    () a = (); //$
    () b = null; //$
//!
    io:println("a:", a); //!
    io:println("b:", b); //!
}
```

**Code Breakdown**
{.tip-code-full}

* Line 5: nil literal `()` is assigned to the variable `a`.
* Line 6: nil literal `null` is assigned to the variable `b`.
{.tip-code-full}

💡 Note: Both `()` and `null` are equivalent to `nil` in Ballerina. However, `()` is the preferred way to assign **nil** value to a variable.
{.note .note-primary}