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

# Identifiers 

An identifier is a name given to an element in a program, such as a variable, function, or type. Identifiers allow programmers to identify and refer to specific elements in the source code. 

{{< md class="center" >}}
<img src="/docs/syntax/identifiers/Identifiers.svg" alt="Identifiers are everywhere"  />
Identifiers are everywhere in your code
{{</md >}}

The use of appropriate identifiers is important for writing readable and understandable code. Different programming languages have their own rules and conventions for identifiers, and in this post, I will focus on how to master identifiers in Ballerina.

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

As you may have noticed, the previous syntax we discussed disallowed keywords and identifiers that start with digits. However, this limitation can be overcome using a Quoted Identifier syntax:

{{<md class="syntax">}}
* `'<Initial_Char | Digits>*`
{{</md>}}

It is same syntax, instead identifier starts with single quote `'`. This allows any combination of characters, including keywords and identifiers that start with digits, to be used as an identifier. Let's make some of those invalid identifiers valid using quoted identifiers.

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

As previously mentioned, Ballerina allows any valid Unicode code point to be used in an identifier, which can be escaped using the `\u{XXXX}` syntax or a non-empty character using the `\` syntax. This provides even more flexibility for programmers to use non-ASCII characters and support non-English languages in their code.

{{<md class="syntax">}}
* `\u{XXXX}`
* `\`
{{</md>}}

However, there are some restrictions on the use of these escape sequences in identifiers, as defined in the [Ballerina Language Specifications](https://ballerina.io/spec/lang/master/#lexical_structure). For example, `\u{0000}` to `\u{D800}` and from (excluding) `\u{DFFF}` to `u{10FFFF}` are not allowed in identifiers. 

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

Qualified identifier syntax has an additional identifier (module-prefix) at the beginning of the identifier to indicate the module that is being referred to. It must be the same as the module-prefix specified in an import declaration in the same source file. To separate the module-prefix and the identifier, there is a colon `:`, and there should not be any whitespace between them.

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
When using the Ballerina platform, there are restrictions on choosing the organization and module name. Unlike other identifiers, they only support the use of alphanumeric characters for the module name and organization name. The module name and organization name must start with an ASCII letter (`A-Z`, `a-z`) and may contain an underscore `_` to separate words that are written in ASCII letters and digits (`0-9`). They must not end with an underscore. 
{{</hint >}}

## 💡 Usages 

### Better Support for Domain-Specific Terminology

Ballerina is designed to have flexible identifiers, which is especially useful when working with data that may contain characters from various languages and symbols. This makes it easier to work with domain-specific terminology, as identifiers can be customized to match the specific needs of a domain. For example, if you're working with JSON or XML data that has been poorly designed and contains special characters in the keys, Ballerina allows you to create identifiers that match those keys, making it easier to access and work with the data.

The video showcases how Ballerina's flexible identifiers allow us to work with the special characters in the JSON keys, enabling us to transform and access the data easily.

{{<tabs>}}
{{<tab "Demo">}}
{{<youtube Yz21_A6Z1Eo>}}

{{</tab>}}
{{<tab "Source Code">}}
{{<code id="0" title="Handling poorly design JSON value">}}
{{< highlight title="Code Breakdown" >}}
📌::: 5::: Use `cloneWithType` to convert the JSON value to a record value.
📌::: 7::: Once the JSON value is converted to a record value, you can access the fields using the dot notation.
📌::: 12-25::: Generated Record Structure, using the original JSON value as the template by using the Ballerina Visual Studio Code plugin. 
{{< /highlight >}}
{{</code>}}
{{</tab>}}
{{</tabs>}}


### Unicode Support

Ballerina supports the use of Unicode characters in identifiers. When we designed the language, supporting Unicode identifiers was one of the primary design requirements, because it makes it easier for programmers to use non-ASCII characters, domain-specific terminology, and support non-English languages in their code. 

{{<md class="center">}}

<iframe src="https://docs.google.com/presentation/d/e/2PACX-1vR52UNbp40rRKFI416fBQcLOvjOK68AMjQU67DWPl22JR__7mXAn26DbpJXk4IQtwb-hK81hmV50GFT/embed?start=true&loop=true&delayms=3000" frameborder="0" width="672" height="317" allowfullscreen="true" mozallowfullscreen="true" webkitallowfullscreen="true"></iframe>

{{</md>}}

### Ignore value using `_`

In Ballerina, you can use a single underscore `_` as an identifier in a variable context to simply ignore a value. This is useful when you don't actually need to use the value generated from the expression. Another use-case is when you bind a structured value to multiple variables using binding patterns, but you don't need all the values. In such cases, you can use the single underscore to ignore the values you don't need. 

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

{{< md class="center" >}}
![Identifiers Everywhere](https://i.imgflip.com/7e9l6t.jpg)
[Memes by Hasitha Aravinda](https://imgflip.com/i/7e9l6t)
{{</md >}}

* Use descriptive identifiers to make your code more readable and understandable.
* Avoid using names that are either too long or too short. Longer names are easier to understand, but excessively long names can make your code less readable. Shorter names are easier to type, but names that are too short may not convey sufficient meaning, making your code less readable.
* Avoid using abbreviations in identifiers unless they are well-known and commonly used.
* Be aware of the context in which you are using the identifier. Depending on the context, you may have to follow certain conventions. I will discuss some of these conventions later in this section.
* Be aware of the difference between public and non-public identifiers. Public identifiers are visible outside the module, while non-public identifiers are visible only within the module.
  * When exposing APIs to the public, such as services, client objects, etc., you should choose public identifiers carefully.
  * Take the time to think about the public identifiers and choose them wisely, as this will make your code more readable and understandable.
  * This will also reduce the possibility of breaking changes in the future and the inconvenience consumers of your library will experience when migrating to a new version.

However, depending on the requirements, you may not be able to follow these guidelines. Sometimes you have to comply with certain specifications or contracts. For example, Ballerina developers implementing integrations often have to adhere to OpenAPI/GraphQL/gRPC contracts and use the names defined in the contract. In such cases, using the same name can help reduce unnecessary data transformation and mapping. You can use features such as quoted identifiers and character escaping to overcome limitations of the identifier syntax.

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

When using acronyms such as `XML`, `JSON`, or `REST` in identifiers, it's generally recommended to use capital letters for the first letter of the acronym and camelCase for the rest of the letters. However, if the identifier starts with an acronym, you should use appropriate case for the first letter, following the standard convention for that acronym.

For example, in a function that converts JSON to XML, you might use the identifier `jsonToXml`, where "json" is written in lowercase using camelCase, and "Xml" is written in PascalCase with a capital letter for the first letter of the acronym. Similarly, in a function that converts XML to JSON, you might use the identifier `xmlToJson`.

For type definitions that use acronyms, you would follow the same convention, using PascalCase with a capital letter for the first letter of the acronym. For example, you might define a type `XmlProperties` or `RestApiProperties`, where "Xml" and "RestApi" are written in PascalCase with a capital letter for the first letter of each acronym.

## 🚀 Advanced Topics

### 🎚️ Identifier Scoping Rules

Identifiers have their own scope, and depending on the context in which they are used, different rules apply. There are two main scopes for identifiers in Ballerina:
* Module-scope
  An identifier declared in the module-scope can be referenced anywhere within the module. If the identifier is declared as public, it can be referenced from outside the module as well.
* Block-scope.
  An identifier declared in the block-scope can only be referenced within the particular block in which it is declared. These blocks are typically delimited by curly braces.

These two scopes are further separated into three symbol spaces. Here's a breakdown of which language constructs belong to each of the three symbol spaces in Ballerina:  

**Language Constructs/Symbol Space and Scopes**
{{< md class="post_table center post_table_compact" >}}

| Symbol-Space 🡢 / Scope 🡣 | *main*    | *prefix*      | *annotation tag*   |
|:--------------------------:|------------|-----|----|
|        Module-Scope        | Variables, Constants, Types, Functions, and other identifiers that do not belong to any of the other two spaces  | Prefixes declared by import declarations and XML namespace declarations | Annotation tags declared by annotation declarations |
|        Block-Scope         | Any statement, action, expression that supports type-binding patterns/binding patterns, such as variable definition statements, foreach statements, let expressions, and query from clauses. Additionally, function parameters are also part of the block scope.  | Local XML namespace declaration statements  | N\A    |

{{</md>}}

**Shadowing Rules**

 It is possible to declare an identifier with block-scope even if the same identifier has already been declared with module-scope within the same symbol space. In this case, the block-scope declaration will take precedence over the module-scope declaration within the region where the block-scope declaration is in scope. However, if two identifiers with the same name are declared with overlapping block-scope within the same symbol space, it will result in a compile error.

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

However, not all identifiers are desugared into sequential bytecode. For example, record fields, some level of type information, function names have runtime meaning and are not desugared. In these cases, we keep the original identifier name as it is, as it has runtime significance.

# Conclusion

In this post, I have covered the basics of identifiers in Ballerina. I hope you found this post useful.

