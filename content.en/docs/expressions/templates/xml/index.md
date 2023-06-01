---
title : XML Template
description : Use XML template expression to construct an XML value. 
date: 2023-01-01
weight : 6052
ballerina_type : [xml]
ballerina_lang : [template]
highlight : [xml_template.bal]
aliases : 
  - /examples/expr/xml-template/xml-template/
menu:
  main:
    parent: syntax
    name: 'XML Template'
    params:
      group: "templates"
---

# XML Template Expression

You can use XML template expression to construct an XML value. 

{{< cards >}}
{{<card header="✍ Syntax" title="XML Template">}}

`xml` `` ` `` BacktickItem* Dollar* `` ` ``
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

```ballerina {filename="xml_template.bal", lines="7-11" result="output", title="XML Template Expression Example" }
import ballerina/io; //!
//!
public function main() {
//!
    string name = "tom";
    int age = 25;
    xml person = xml ` //$
<person> //$
    <name>${name}</name> //$
    <age>${age}</age> //$
</person>`; //$

    io:println(person); //!
}
```