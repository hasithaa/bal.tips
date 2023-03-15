---
title : "Identifiers - Best Practices and Use Cases"
description : "An identifier is a name given to an element in a program, such as a variable, function, or type. Identifiers allow programmers to identify and refer to specific elements in the source code."
keywords: [identifiers, naming conventions, naming rules, naming guidelines]
images: [/docs/syntax/identifiers/Identifiers.svg]
date : 2023-03-14
weight : 4005
type : docs
ballerina_type : [json, maps]
ballerina_lang : [identifier]
ballerina_feature : [data-bind]
highlight: [read_json.bal, ignore.bal]
---

# Identifiers - Best Practices and Use Cases 

Identifiers are names assigned to elements like variables, functions, or types in a program, helping programmers identify and reference specific elements in the source code.

{{<figure src="/docs/syntax/identifiers/Identifiers.svg" alt="Identifiers are everywhere" title="Identifiers are everywhere in your code">}}

Using suitable identifiers is crucial for creating readable and understandable code. Each programming language has its own rules and conventions for identifiers, and in this post, we'll explore mastering identifiers in Ballerina.

## ✍️ Syntax 

### Identifier Syntax

When writing code in Ballerina, it's important to understand the basic usage of identifiers.

An identifier in Ballerina is represented by the following syntax:

{{<md class="syntax">}}
* `<Initial_Char><Initial_Char | Digits>*`
{{</md>}}

The `Initial_Char` can be 
* An ASCII letter (`A-Z` or `a-z`),
* An underscore (`_`),
* A Unicode identifier character (excluding certain [characters](https://ballerina.io/spec/lang/master/#UnicodeNonIdentifierChar)) or
* Any valid Unicode code point escaped using `\u{XXXX}` or a non-empty character using `\`.

After the `Initial_Char`, any combination of characters including digits is allowed. However, using reserved words such as keywords will result in a compilation error. Let's look at some valid identifiers and invalid identifiers.  

{{<md class="post_table center">}}

| ✅ Valid Identifiers |                                                      | ❌ Invalid Identifiers (Reason) |
|---------------------|------------------------------------------------------|--------------------------------|
| name                || 2invalid (starts with a number)                      |
| ageInYears          || my-variable (contains an invalid special character)  |
| Student             || bad!name (contain with an invalid special character) |
| sales_tax_rate      || 12345 (starts with a number)                         |
| user_name           || @hello (starts with an invalid special character)    |
| _isAvailable        || id with spaces  (contains a space)                   |
| MAX_ATTEMPTS        || if   (keyword)                                       |
| 国家                  || order (keyword)                                      |
| 国                   || service (keyword)                                    |
| страна              || class (keyword)                                      |

{{</md>}}

{{< hint info >}}
 Ballerina Identifier follows the requirements of Unicode TR31 for immutable identifiers; the set of characters is immutable in the sense that it does not change between Unicode versions. 
{{</hint >}}

### Quoted Identifier

You might have noticed that the earlier syntax doesn't allow keywords and identifiers starting with digits. To overcome this limitation, use the Quoted Identifier syntax:

{{<md class="syntax">}}
* `'<Initial_Char | Digits>*`
{{</md>}}

This syntax starts with a single quote `'`, enabling any combination of characters, including keywords and identifiers starting with digits, to be used as an identifier. Let's turn some of those invalid identifiers into valid ones using quoted identifiers.

{{<md class="post_table center">}}

| ❌ Invalid Identifiers | ✅ Valid Identifiers |
|-----------------------|---------------------|
| 2invalid              | '2invalid           |
| 12345                 | '12345              |
| if                    | 'if                 |
| order                 | 'order              |
| service               | 'service            |
| class                 | 'class              |

{{</md>}}

### Character Escaping 

Ballerina allows any valid Unicode code point in an identifier, escaped using the \u{XXXX} syntax or a non-empty character with the \ syntax. This offers flexibility for using non-ASCII characters in code.

{{<md class="syntax">}}
* `\u{XXXX}`
* `\`
{{</md>}}

However, some restrictions apply to escape sequences in identifiers, as outlined in the [Ballerina Language Specifications](https://ballerina.io/spec/lang/master/#lexical_structure). For instance, `\u{0000}` to `\u{D800}` and (excluding) `\u{DFFF}` to `u{10FFFF}` are not allowed in identifiers.

{{<md class="post_table center">}}

| ❌ Invalid Identifiers           | ✅ Valid Identifiers                 | ✅ Valid Identifiers                            |
|---------------------------------|-------------------------------------|------------------------------------------------|
| my-variable                     | my\-variable                        | my\u{2D}variable                               |
| bad!name                        | bad\!name                           | bad\u{21}name                                  |
| @hello                          | \@hello                             | \u{40}hello                                    |
| id with spaces                  | id\ with\ spaces                    | id\u{20}with\u{20}spaces                       |


{{</md>}}

### Qualified Identifier Syntax

Identifiers are not only used to name elements in a program but also to refer to them. The syntax we discussed so far works well to refer to elements locally within the source of the module. However, to refer to another module, you need a qualified identifier.

{{<md class="syntax">}}
* `<module-prefix-identifier>:<identifier>`
{{</md>}}

Qualified identifier syntax includes an additional identifier (module-prefix) at the start to indicate the referenced module. It must match the module-prefix in an import declaration within the same source file. A colon : separates the module-prefix and identifier, with no whitespace in between.

{{<balcode "1 2 3 7 10 13">}}
import ballerina/http;
import ballerina/io;
import myorg/account.user;

public function main() returns error? {
    // Refers to http:Client Class 
    http:Client httpClient = check new("http://localhost:9090");

    // Refers to io:NEW_LINE constant
    string newLineChar = io:NEW_LINE;

    // Refers to myorg/account.user:Payer Record
    user:Payer payer = {name: "John Doe", age: 25};
}
{{</balcode>}}

{{< hint warning >}}
With Ballerina platform, restrictions apply to organization and module names. They only support alphanumeric characters, and names must start with an ASCII letter (A-Z, a-z). Underscores _ can be used to separate words composed of ASCII letters and digits (0-9), but names shouldn't end with an underscore.
{{</hint >}}

## 💡 Usages 

### Better Support for JSON and XML

Ballerina's flexible identifiers are great for working with data containing various languages and symbols, making it easier to handle domain-specific terminology. For instance, when dealing with poorly designed JSON or XML data with special characters in the keys, Ballerina enables you to create matching identifiers, simplifying data access and manipulation without complex transformations.

The video demonstrates how Ballerina's flexible identifiers help work with special characters in JSON keys for easy data transformation and access.

{{<tabs>}}
{{<tab "Demo">}}
{{<youtube Yz21_A6Z1Eo>}}

{{</tab>}}
{{<tab "Source Code">}}
{{<code id="0" title="Handling poorly design JSON value">}}
{{< highlight title="Code Breakdown" >}}
📌::: 5::: Using `cloneWithType`, convert the JSON value to a record value.
📌::: 7::: After converting the JSON value to a record value, access the fields using dot notation.
📌::: 12-25::: Generated the Record Structure using the original JSON value as a template with the Ballerina Visual Studio Code plugin.
{{< /highlight >}}
{{</code>}}
{{</tab>}}
{{</tabs>}}


### Unicode Support

Ballerina supports the use of Unicode characters in identifiers. When we designed the language, supporting Unicode identifiers was one of the primary design requirements, because it makes it easier for programmers to use non-ASCII characters, domain-specific terminology, and support non-English languages in their code. 

{{<md class="center">}}

<iframe src="https://docs.google.com/presentation/d/e/2PACX-1vR52UNbp40rRKFI416fBQcLOvjOK68AMjQU67DWPl22JR__7mXAn26DbpJXk4IQtwb-hK81hmV50GFT/embed?start=true&loop=true&delayms=3000" frameborder="0" width="672" height="317" allowfullscreen="true" mozallowfullscreen="true" webkitallowfullscreen="true"></iframe>

{{</md>}}

### Ignoring Values Using `_`

In Ballerina, you can use a single underscore `_` as an identifier in a variable context to simply ignore a value. This is useful when you don't actually need to use the value generated from an expression. Another use case is when you bind a structured value to multiple variables using binding patterns, but you don't need all of the values. In such cases, you can use a single underscore to ignore the values that you don't need.

{{<code id="1" title="Ignore value">}}
{{< highlight title="Code Breakdown" >}}
📌:::11::: To calculate the average, you don't need student's name, ignore it using `_`.
📌:::17::: In this specific case, you only need student's name, ignore the rest using `_`.
📌:::18::: The `printStudentName` function returns a boolean value, since you don't need it, ignore it using `_`.
{{< /highlight >}}
{{</code>}}


It's important to note that this technique only works for non-error values. Ignoring errors is generally considered bad practice, and the Ballerina compiler will generate an error if you try to ignore a value that could contain an error.

## 💡 Naming Conventions

Identifiers can be used in different language contexts, and depending on the context, there are generally accepted best practices for naming identifiers. 

{{<figure src="/docs/syntax/identifiers/7e9l6t.jpg" attrlink="https://imgflip.com/i/7e9l6t" attr="Memes by Hasitha Aravinda" title="Identifiers Everywhere, But not a single one descriptive." >}}

* Opt for descriptive identifiers to enhance code readability and comprehension.
  * Balance length: long names add clarity, but excessively long ones reduce readability. Short names are quicker to type but may lack meaning.
  * This balance takes time to master.
* Steer clear of abbreviations in identifiers, except for well-known, widely-used ones.
* Be mindful of the identifier's context and any relevant conventions. Depending on the context, you may have to follow certain conventions. I will discuss some of these conventions later in this section.
* Understand public vs. non-public identifiers: public ones are visible outside the module, while non-public ones are module-specific.
  * When exposing APIs like services or client objects, choose public identifiers thoughtfully.
  * Careful public identifier selection improves code readability and minimizes future breaking changes or inconvenience when upgrading a library version.

Some times, you might not be able to stick to these guidelines due to specific requirements, like following OpenAPI/GraphQL/gRPC contracts for Ballerina integrations. In these cases, using the same names defined in the contract can minimize extra data transformation and mapping. To work around identifier syntax limitations, you can use features like quoted identifiers and character escaping.

Another valid reason to deviate from these guidelines is that they are designed for English words, and camelCase, PascalCase don't make any sense in some other languages. In such cases, you are free to follow your own convention.

### 🐫 camelCase

{{< expand "✅ Function/Method Name" "💡" >}}
{{< balcode "1 3" >}}
function calculateAverage() { }

function jsonToXml() { }
{{</balcode >}}
{{</expand>}}

{{< expand "✅ Function Parameters" "💡" >}}
{{<balcode "1">}}
function getName(string firstName, string lastName) returns string {
  return firstName + " " + lastName;
}
{{</balcode>}}
{{</expand>}}

{{< expand "✅ Variable (Local or Global) /Configurable/Listeners" "💡" >}}
{{<balcode "1 2 4 5 7 9">}}
int number = 10;
boolean isOpen = true;

configurable int port = ?;
configurable string hostName = ?;

listener http:Listener httpListener = new (port);

http:Client restClient = check new (hostName);
{{</balcode>}}
{{</expand>}}

{{< expand "✅ Record Fields (Or as specified)" "💡" >}}
{{<balcode "2 3 4">}}
type Person record {
    string firstName;
    string lastName;
    string home\-address;
};
{{</balcode>}}


📌 In Record Fields, `\-` is used to escape the `-` character.
{{</expand >}}

{{< expand "✅ Object/Class Fields" "💡" >}}
{{<balcode "2 3 8 9">}}
type PersonObject object {
    string firstName;
    string lastName;
};

class StudentObject {
    *PersonObject;
    string firstName = "John";
    string lastName = "Doe";
}
{{</balcode>}}

📌 Unlike records, we do not use objects to represent data from an external system. Therefore, we do not have to worry about escaping the "-" character. It is important to use proper naming conventions for object fields.
{{</expand >}}

{{< expand "✅ Anonymous function parameter list" "💡" >}}
{{<balcode "2">}}
function (string, string) returns string getFullName 
    = (fname, lname) => fname + " " + lname;
{{</balcode>}}
📌Use simple and short name for Anonymous function parameter list.
{{</expand >}}

{{< expand "✅ Worker Name" "💡" >}}
{{<balcode "2 6">}}
function parallelSum(int[1000] numbers) returns int {
    worker sumWorker1 returns int { 
        return int:sum(...numbers.slice(0, 499));
    }

    worker sumWorker2 returns int { 
        return int:sum(...numbers.slice(500, 999));        
    }

    record {| int sumWorker1; int sumWorker2; |} results = wait { sumWorker1 , sumWorker2 };
    return results.sumWorker1 + results.sumWorker2;
}
{{</balcode>}}
{{</expand >}}

{{< expand "✅ XML Namespace" "💡" >}}
{{<balcode "1">}}
xmlns "http://bal.tips" as balTips;
{{</balcode>}}

📌 XML namespace identifier must be short, single word and typically written in lowercase letters. Use camelCase if you need multiple words.
{{</expand >}}



### 🅟 PascalCase

{{< expand "✅ Type Definitions, Classes, Enum" "💡" >}}
{{<balcode "1 7 13">}}
type DepartmentWorker  record { 
    string firstName;
    int age;
    decimal salary;
};

enum DepartmentName {
    HR,
    IT,
    SALES
}

class EmployeeDataClient { }
{{</balcode>}}
{{</expand >}}

### 🐍 UPPER_SNAKE_CASE

{{< expand "✅ Constants - UPPER_SNAKE_CASE" "💡" >}}
{{<balcode "1 2">}}
const PI = 3.141592653589793;
const MAX_VALUE = 9223372036854775807;
{{</balcode>}}
{{</expand >}}

### ➖ kebab-case/dash-case

{{< expand "✅ Service/Resource Path Segment - (or as specified)" "💡" >}}
{{<balcode "1 2 3">}}
service /inventory on new http:Listener (9090) {
  resource function get item\-list () { }
  resource function get customer\-info () { }
}
{{</balcode>}}

📌 In Resource Path Segment, `\-` is used to escape the `-` character.
{{</expand >}}

### ⋯ Dot Separated Identifiers

{{< expand "✅ Module Name" "💡" >}}
{{<balcode "1">}}
import ballerina/http;
import bal_tips/user.account;
import bal_tips/email.pop;
{{</balcode>}}
{{</expand >}}

It's important to note that these are just guidelines, and the Ballerina compiler won't force you to follow these rules, except for one occasion where you can only use alphanumeric characters (As mentioned in the qualified identifier) for the module name and organization name. If you see a warning or error other than that, it's probably caused by a compiler extension that is part of the imported library used by you.

#### Working with Acronyms

When using acronyms like XML, JSON, or REST in identifiers, stick to capitalizing the first letter and using camelCase for the rest. If an identifier starts with an acronym, follow the standard convention for its case in the context it used.

For instance, in a function converting JSON to XML, you could use `jsonToXml` (with "json" in lowercase camelCase and "Xml" in PascalCase). Similarly, for XML to JSON, use `xmlToJson`.

For type definitions with acronyms, apply the same rule, using PascalCase and capitalizing the first letter. Examples include `XmlProperties` or `RestApiProperties`, where "Xml" and "RestApi" follow this convention.

## 🚀 Advanced Topics

### 🎚️ Identifier Scoping Rules

Identifiers in Ballerina have their own scope, with different rules based on the context. There are two main scopes:

* **Module-scope**: You can reference identifiers declared here anywhere in the module. If they're public, you can reference them outside the module too.
* **Block-scope**: These identifiers are limited to the block they're declared in, usually within curly braces.

Additionally, there are three symbol spaces for these scopes. Here's a quick rundown of language constructs in each Ballerina symbol space:

**Language Constructs/Symbol Space and Scopes**
{{< md class="post_table center post_table_compact" >}}

| Symbol-Space 🡢 / Scope 🡣 | *main*    | *prefix*      | *annotation tag*   |
|:--------------------------:|------------|-----|----|
|        Module-Scope        | Variables, Constants, Types, Functions, and other identifiers that do not belong to any of the other two spaces  | Prefixes declared by import declarations and XML namespace declarations | Annotation tags declared by annotation declarations |
|        Block-Scope         | Any statement, action, expression that supports type-binding patterns/binding patterns, such as variable definition statements, foreach statements, let expressions, and query from clauses. Additionally, function parameters are also part of the block scope.  | Local XML namespace declaration statements  | N\A    |

{{</md>}}

**Shadowing Rules**

You can use the same identifier name for both block-scope and module-scope within the same symbol space. Within the block-scope region, it'll take priority over the module-scope. But watch out! If you declare two same-named identifiers with overlapping block-scope in the same symbol space, you'll get a compile error.

 {{<balcode "3 4 5 7 9 11 16 17 18">}}
import ballerina/io;

function sumIf(int num1, int num2, int max) returns int {
    // num1, num2, max are block-scope variables
    // max hides a module-scope variable with the same name

    int a = num1; // block-scope, hides module-scope identifier
    if a > max {
        int a = 0; // Compile time error. Already defined in a block-scope
    } else if num2 > max {
        int num2 = 0; // Compile time error. Already defined in a block-scope
    }
    return a + num2;
}

// module-scope identifiers location does not matter
int a = 100; // module-scope
public int max = 40; // module-scope and public

public function main() {
    io:println(sumIf(a, a, 200));    
}
{{</balcode>}}

### Keywords/Predefined Identifiers and Special Cases

Ballerina has a large set of reserved keywords that are reserved for language constructs. Sometimes, common words such as "order" or "limit" may also be reserved keywords. In such cases, you can still use these keywords as identifiers by using the quoted identifier syntax.

However, there are special cases where you don't need to use the quoted identifier syntax. One such case is when using built-in type names. These are the types that are defined in the language specification, yet you can use them as identifiers without using the quoted identifier syntax.

{{< md class="post_table center post_table_compact" >}}

|         |         |          |             |          |
|---------|---------|----------|-------------|----------|
| boolean | decimal | error    | float       | future   |
| int     | string  | xml      | any         | anydata  |
| byte    | never   | handle   | readonly    | function |

{{</md>}}

Another example of where you don't need to use the quoted identifier syntax is when working with pre-declared module prefixes. These prefixes are used to refer to the language libraries and are predefined by the Ballerina language. Here is the list of pre-declared module prefixes.

{{< md class="post_table center post_table_compact" >}}

|         |         |          |             |          |
|---------|---------|----------|-------------|----------|
| boolean | decimal | error    | float       | function |
| future  | int     | map      | object      | stream   |
| string  | table   | typedesc | transaction | xml      |

{{</md>}}

Additional `map`, `join`, and `start` are keywords, but they are allowed as method names without the quoted identifier syntax.

### Runtime Representation

In Ballerina, some identifiers have runtime meaning, while others do not. For example, variable names are desugared into something sequential during bytecode generation, but debugger information is still maintained, so we can refer to those variables using the original identifier name during a debugging session. 

However, not all identifiers are desugared into sequential identifiers. For example, record fields, some level of type information, function names have runtime meaning and are not desugared. In these cases, we keep the original identifier name as it is, as it has runtime significance.

# Conclusion

In this post, I have covered the basics of identifiers including syntax variations, naming conventions, and scoping rules. Then, discuss the flexibility when working with JSON data, covered some advanced topics such as keywords, predefined identifiers, and runtime representation. I hope you found this post useful.
