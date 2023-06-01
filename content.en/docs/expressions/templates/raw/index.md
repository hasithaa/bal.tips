---
title : Raw Template Expression
description : Raw Template expression constructs an object belongs to `object:RawTemplate` object type.
date: 2023-01-01
weight : 6055
ballerina_type : [object]
ballerina_lang : [template]
highlight : [raw_template.bal]
aliases :
- /examples/expr/raw-template/raw-template/
menu:
  main:
    parent: syntax
    name: 'Raw Template'
    params:
      group: "templates"
---

# Raw Template Expression

Raw Template expression constructs an object belonging to the `object``:RawTemplate`` object type.

{{< cards >}}
{{<card header="✍ Syntax" title="XML Template">}}

`` ` `` BacktickItem* Dollar* `` ` ``
{.tip-syntax}

Here

* BacktickItem := BacktickSafeChar| BacktickDollarsSafeChar| Dollar* interpolation
* interpolation := `${` expression `}`
* BacktickSafeChar := ^ ( `` ` `` | `$` )
* BacktickDollarsSafeChar :=  `$`+ ^ ( `{` | `` ` ``  | `$`)
* Dollar := `$`
{.tip-syntax}

{{</card>}}
{{</cards>}}

```ballerina {filename="raw_template.bal", lines="7" result="output", title="Raw Template Expression Example" }
import ballerina/io; //!
//!
public function main() {
//!
    string name = "";
    int age = 30;
    object:RawTemplate tmp = `My name is ${name}. My age is ${age}.`; //$
//!
    io:println(tmp.strings); //!
    io:println(tmp.insertions); //!
}
```