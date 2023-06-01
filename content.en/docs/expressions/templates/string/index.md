---
title : String Template
description : A String template expression constructs a string value using the Template expression.
date: 2023-01-01
weight : 6052
ballerina_type : [string]
ballerina_lang : [template]
highlight : [string_template.bal, template_special.bal]
aliases :
  - /examples/expr/string-template/string-template/
menu:
  main:
    parent: syntax
    name: 'String Template'
    params:
      group: "templates"
---

# String Template Expression

A String template expression constructs a string value using the Template expression.

{{< cards >}}
{{<card header="✍ Syntax" title="String Template">}}

`string` `` ` `` BacktickItem* Dollar* `` ` ``
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

## ✍ Syntax

String Template syntax support interpolation (Syntax `${expr}`) and each interpolation expression must have a type that is a subtype of `boolean|int|float|decimal|string`. You can use this expression in places where you use string concatenation, or you need to build multi-line string values.   

```ballerina {filename="string_template.bal", lines="14-17" result="output", title="String Template Expression Example" }
import ballerina/io; //!
//!
type Employee record {
    int id;
    string name;
    decimal salary;
};
//!
public function main() {
//!
    Employee emp = {name: "Bob", id: 2, salary: 45000};
    string department = "IT";

    string s1 = string `Hello, ${emp.name}!`; //$
    string s2 = string `Your id is ${emp.id} //$
Your department is ${department} //$
Your salary is ${emp.salary}`; //$
//!
    io:println(s1); //!
    io:println(s2); //!
}
```

## How String Interpolation works

* Step 1 - Take every character that is not part of the interpolation within the two `` ` `` Backtick, including newline, CR, etc. These characters are sliced based on interpolation expression positions. 
* Step 2- Evaluate each interpolation expression in the order in which they were written. Then Take the string representation of the values, by using the `value:toString()` lang-lib function.
* Step 3 - Construct the final string value interleaving Step 1 and Step 2 results.   


## Special Cases

{{<cards>}}
{{<card header="🚫 No Escape Characters">}}
## <i class="bi bi-x-lg text-danger"></i> 

Unlike [string-literal]({{% relref "../../literals/string/" %}}), String Template doesn't support escape characters.  
{{</card>}}
{{<card header="✅Use interpolation to handle special cases">}}

## <i class="bi bi-check-lg text-success"></i>

Use [string-literal]({{% relref "../../literals/string/" %}}) with interpolation to type such characters i.e. ``${"`"}``. 
{{</card>}}
{{</cards>}}

```ballerina {filename="template_special.bal", lines="4 5 8" result="output", title="String Template Special Cases" }
import ballerina/io; //!
//!
public function main() {
    string s1 = string `\\ \n \t`; //$
    string s2 = string `backtick - ${"`"}`; //$
//!
    int value = 100; //$
    string s3 = string `Price $${value}`; //$
//!
    io:println(s1); //!
    io:println(s2); //!
    io:println(s3); //!
}
```

**Code Breakdown**
{.tip-code-full}

* Line 4 - Escape characters are not supported in String Template.
* Line 5 - Use interpolation to type such characters like backtick character i.e. ``${"`"}``.
* Line 8 - Additional `$` character doesn't have any special meaning in String Template.
{.tip-code-full}
