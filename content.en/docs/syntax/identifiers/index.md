---
title: "Identifiers - Best Practices and Use Cases"
description: "An identifier is a name given to an element in a program, such as a variable, function, or type. Identifiers allow programmers to identify and refer to specific elements in the source code."
keywords: [identifiers, naming conventions, naming rules, naming guidelines]
images: [/docs/syntax/identifiers/Identifiers.png]
date: 2023-03-14
images: [/docs/syntax/identifiers/Identifiers.png]
weight: 4005
ballerina_type: [json, maps]
ballerina_lang: [identifier]
ballerina_feature: [data-bind]
highlight: [qualified_identifier.bal, read_json.bal, person.bal, ignore.bal, variable_shadowing-error.bal]
menu:
  main:
    parent: syntax
    name: "Identifiers"
    params:
      group: "basic"
---

# Identifiers

Identifiers are names assigned to elements like variables, functions, or types in a program, helping programmers identify and reference specific elements in the source code.

{{<cards>}}
{{<card header="✍ Syntax" title="Common Identifier Syntax" url="#common-identifier-syntax">}}

&lt;Initial_Char>&lt;Initial_Char | Digits>*
{.tip-syntax}

{{</card>}}
{{<card header="✍ Syntax" title="Quoted Identifier" url="#quoted-identifier">}}

`'`&lt;Initial_Char | Digits>*
{.tip-syntax}

{{</card>}}
{{<card header="✍ Syntax" title="Character Escaping" url="#character-escaping">}}
* `\u{`&lt;Digits>`}`
* `\`&lt;Char>
{.tip-syntax}

{{</card>}}
{{<card header="✍ Syntax" title="Qualified Identifier" url="#qualified-identifier-syntax">}}

&lt;module-prefix-identifier>`:`&lt;identifier>
{.tip-syntax}

{{</card>}}
{{</cards>}}

Using suitable identifiers is crucial for creating readable and understandable code. Each programming language has its own rules and conventions for identifiers, and in this post, we'll explore mastering identifiers in Ballerina.

![Identifiers are everywhere](/docs/syntax/identifiers/Identifiers.svg "Identifiers are everywhere in your code")
{.tip-75-frame}

## ✍ Syntax

There are multiple ways to define identifiers in Ballerina. Let's look at the syntax for each of them.

### Common Identifier Syntax {id="common-identifier-syntax"}

An identifier in Ballerina is represented by the following syntax:

&lt;Initial_Char>&lt;Initial_Char | Digits>*
{.tip-syntax}

The `Initial_Char` can be:
* An ASCII letter (`A-Z` or `a-z`),
* An underscore (`_`),
* A Unicode identifier character (excluding certain [characters](https://ballerina.io/spec/lang/master/#UnicodeNonIdentifierChar)), or
* Any valid Unicode code point escaped using `\u{XXXX}` or a non-empty character using `\`.

After the `Initial_Char`, any combination of characters including digits (`0-9`) is allowed. However, using reserved words such as keywords will result in a compilation error. Let's look at some valid identifiers and invalid identifiers.

| ✅ Valid Identifiers | ❌ Invalid Identifiers (Reason)                       |
|---------------------|----------------------------------------------------|
| `name`                | `2invalid` (starts with a number)                     |
| `ageInYears`          | `my-variable` (contains an invalid special character) |
| `Student`             | `bad!name` (contains an invalid special character)    |
| `sales_tax_rate`      | `12345` (starts with a number)                        |
| `user_name`           | `@hello` (starts with an invalid special character)   |
| `_isAvailable`        | `id with spaces` (contains a space)                   |
| `MAX_ATTEMPTS`        | `if` (keyword)                                        |
| `国家`                  | `order` (keyword)                                     |
| `国`                   | `service` (keyword)                                   |
| `страна`              | `class` (keyword)                                     |
{.tip-table .text-center}

Note: Ballerina Identifier follows the requirements of Unicode TR31 for immutable identifiers; the set of characters is immutable in the sense that it does not change between Unicode versions.
{.note .note-primary}

### Quoted Identifier{id="quoted-identifier"}

You might have noticed that the earlier syntax doesn't allow keywords and identifiers starting with digits. To overcome this limitation, use the Quoted Identifier syntax:

`'`&lt;Initial_Char | Digits>*
{.tip-syntax}

This syntax starts with a single quote ('), enabling any combination of characters, including keywords and identifiers starting with digits, to be used as an identifier. Let's turn some of those invalid identifiers into valid ones using quoted identifiers.

| ❌ Invalid Identifiers | ✅ Valid Identifiers |
|-----------------------|---------------------|
| `2invalid`              | `'2invalid`           |
| `12345`                 | `'12345`              |
| `if`                    | `'if`                 |
| `order`                 | `'order`              |
| `service`               | `'service`            |
| `class`                 | `'class`              |
{.tip-table .text-center}

### Identifiers with Character Escaping{id="character-escaping"}

Ballerina allows any valid Unicode code point in an identifier, escaped using the `\u{XXXX}` syntax or a non-empty character with the `\` syntax. This offers flexibility for using non-ASCII characters in code.

* `\u{`&lt;Digits>`}`
* `\`&lt;Char>
{.tip-syntax}

Note: However, some restrictions apply to escape sequences in identifiers, as outlined in the [Ballerina Language Specifications](https://ballerina.io/spec/lang/master/#lexical_structure). For instance, `\u{0000}` to `\u{D800}` and (excluding) `\u{DFFF}` to `u{10FFFF}` are not allowed in identifiers.
{.note .note-warning}

| ❌ Invalid Identifiers | ✅ Valid Identifiers | ✅ Valid Identifiers |
|-----------------------|---------------------|---------------------|
| `my-variable`         | `my\u{2D}variable` | `my\-variable`      |
| `@hello`              | `\u{40}hello`       | `\@hello`           |
| `bad!name`            | `bad\u{21}name`     | `bad\!name`         |
| `id with spaces`      | `id\u{20}with\u{20}spaces`  | `id\ with\ spaces`  |
{.tip-table .text-center}

### Qualified Identifier Syntax{id="qualified-identifier-syntax"}

Identifiers are not only used to name elements in a program but also to refer to them. The syntax we discussed so far works well to refer to elements locally within the source of the module. However, to refer to another module, you need a qualified identifier.

&lt;module-prefix-identifier>`:`&lt;identifier>
{.tip-syntax}

Qualified identifier syntax includes an additional identifier (module-prefix) at the start to indicate the referenced module. It must match the module-prefix in an import declaration within the same source file. A colon (:) separates the module-prefix and identifier, with no whitespace in between.

```ballerina {filename="qualified_identifier.bal" lines="1 2 6 9 12" result="output"}
import ballerina/http; //$
import ballerina/io; //$
//$
public function main() returns error? {
    // Refers to http:Client Class //!
    http:Client httpClient = check new ("https://example.com"); //$

    // Refers to io:NEW_LINE constant //!
    string newLineChar = io:NEW_LINE; //$

    // Refers to io:println function //!
    io:println("Qualified Identifier"); //$
}
```

With Ballerina platform, restrictions apply to organization and module names. They only support alphanumeric characters, and names must start with an ASCII letter (A-Z, a-z). Underscores _ can be used to separate words composed of ASCII letters and digits (0-9), but names shouldn't end with an underscore.
{.note .note-warning}


# 💡 Use-Cases 

## Better Support for JSON Keys

Ballerina's flexible identifiers are great for working with data containing various languages and symbols, making it easier to handle domain-specific terminology. For instance, when dealing with poorly designed JSON or XML data with special characters in the keys, Ballerina enables you to create matching identifiers, simplifying data access and manipulation without complex transformations.

The video demonstrates how Ballerina's flexible identifiers help work with special characters in JSON keys for easy data transformation and access.

{{<youtube id="Yz21_A6Z1Eo" title="Working with JSON data" >}}

Here is the source code used in the video:

```ballerina {filename="read_json.bal" lines="5 7 12-26" result="output" trim=false}
import ballerina/io; //!

public function main() returns error? {
    json inputJson = check io:fileReadJson("data.json");
    Customer customer = check inputJson.cloneWithType(Customer); //$
//!
    string fullName = customer.customer\.first\.name + " " + customer.customer\.last\.name; //$
//!
    io:println("Full Name: ", fullName); //!
}

type CustomerAddress record {
    string street;
    string city;
    string state;
    string zip;
};
//$
type Customer record { //$ 
    string customer\.first\.name; //$
    string customer\.last\.name; //$
    int customer\.age; //$
    string customer\.email\-address; //$
    string customer\#phone\-number; //$
    CustomerAddress customer\$address; //$
}; //$
```

**Code Breakdown**
{.tip-code-full}

* Line 5: Using `cloneWithType`, convert the JSON value to a record value.
* Line 7: After converting the JSON value to a record value, access the fields using dot notation.
* Lines 12-25: Generated the Record Structure using the original JSON value as a template with the Ballerina Visual Studio Code plugin.
{.tip-code-full}

## Unicode Support

Ballerina supports the use of Unicode characters in identifiers. When we designed the language, supporting Unicode identifiers was one of the primary design requirements, because it makes it easier for programmers to use non-ASCII characters, domain-specific terminology, and support non-English languages in their code. 

![Writing Person record in different languages](/docs/syntax/identifiers/person-record.gif "Writing Person record in different languages")

```ballerina {filename="person.bal" trim=false result="output"}
import ballerina/io; //!
//!
public function main() {
    // EN-US //!
    Person john = {name: "John", age: 30, country: "United States"}; //$
    io:println(john.age); //!
//!
    // CN //!
    人 李华 = {名字: "李华", 年龄: 25, 国家: "中国"}; //$
    io:println(李华.年龄); //!
//!
    // IN //!
    व्यक्ति राजेश = {नाम: "राजेश", उम्र: 30, देश: "भारत"}; //$
    io:println(राजेश.उम्र); //!
//!
    // SI //!
    පුද්ගලයා හසිත = {නම: "හසිත", වයස: 34, රට: "ශ්‍රී ලංකාව"};
    io:println(හසිත.වයස); //!
//!
    // JP* (人 Same Unicode as CN, Hence using 人1) //!
    人1 たかし = {名前: "たかし", 年齢: 35, 国: "日本"};
    io:println(たかし.年齢); //!
//!
    // RU //!
    Человек Иван = {имя: "Иван", возраст: 25, страна: "Россия"};
    io:println(Иван.возраст); //!
//!
    // ES //!
    Persona María = {nombre: "María", edad: 25, país: "España"};
    io:println(María.edad); //!
//!
    // KO //!
    사람 지민 = {이름: "지민", 나이: 28, 나라: "대한민국"};
    io:println(지민.나이); //!
}
//$
type Person record { //$
    string name; //$
    int age; //$
    string country; //$
}; //$
//$
type 人 record { //$
    string 名字; //$
    int 年龄; //$
    string 国家; //$
}; //$
//$
type व्यक्ति record { //$
    string नाम; //$
    int उम्र; //$
    string देश; //$
}; //$

type පුද්ගලයා record {
    string නම;
    int වයස;
    string රට;
};

type 人1 record {
    string 名前;
    int 年齢;
    string 国;
};

type Человек record {
    string имя;
    int возраст;
    string страна;
};

type Persona record {
    string nombre;
    int edad;
    string país;
};

type 사람 record {
    string 이름;
    int 나이;
    string 나라;
};
```

## Ignoring Values Using `_`

In Ballerina, you can use a single underscore `_` as an identifier in a variable context to simply ignore a value. This is useful when you don't actually need to use the value generated from an expression. Another use case is when you bind a structured value to multiple variables using binding patterns, but you don't need all of the values. In such cases, you can use a single underscore to ignore the values that you don't need.

```ballerina {filename="ignore.bal" result="output" trim=false lines="11 17 18"}
import ballerina/io; //!

public function main() {
    [string, string, int, int, int][] grades = [ //$ ... ];
        ["John", "smith", 80, 90, 100],
        ["Jane", "doe", 90, 100, 100],
        ["Jim", "carrey", 80, 80, 80]
    ];

    int average = 0;
    foreach [string, string, int...] [_, _, ...scores] in grades { //$ ... }
        int sum = int:sum(...scores);
        average += sum / scores.length();
    }
    io:println("Average: ", average / grades.length()); //!

    foreach [string, string, int...] [firstName, lastName, _, _, _] in grades { //$
        _ = printName(firstName, lastName); //$
    } //$
}
//$
function printName(string fname, string lname) returns boolean { //$ ... }
    io:println(fname, " ", lname); //!
    // Return only to illustrate that the return value is not used by the caller. //!
    return true;
}
```

**Code Breakdown**
{.tip-code-full}

* Line 11: To calculate the average, you don't need student's name, ignore it using `_`.
* Line 17: In this specific case, you only need student's name, ignore the rest using `_`.
* Line 18: The `printStudentName` function returns a boolean value, since you don't need it, ignore it using `_`.
{.tip-code-full}


Note: It's important to note that this technique only works for non-error values. Ignoring errors is generally considered bad practice, and the Ballerina compiler will generate an error if you try to ignore a value that could contain an error.
{.note .note-primary}

# 💡 Naming Conventions

Identifiers can be used in different language contexts, and depending on the context, there are generally accepted best practices for naming identifiers. 

[![Memes by Hasitha Aravinda](/docs/syntax/identifiers/7e9l6t.jpg "Identifiers are everywhere, But not a single one is descriptive.")](https://imgflip.com/i/7e9l6t "Memes by Hasitha Aravinda")

Here are some of the best practices for naming identifiers in Ballerina:

- Opt for descriptive identifiers to enhance code readability and comprehension.
  - Find a balance in length: long names add clarity, but excessively long ones reduce readability. Short names are quicker to type but may lack meaning.
  - Mastering this balance takes time.

- Avoid abbreviations in identifiers, except for well-known and widely-used ones.

- Consider the identifier's context and relevant conventions. Depending on the context, you may need to follow specific conventions. I will discuss some of these conventions later in this section.

- Understand the distinction between public and non-public identifiers: public identifiers are visible outside the module, while non-public ones are module-specific.
  - When exposing APIs such as services or client objects, carefully choose public identifiers.
  - Thoughtful selection of public identifiers improves code readability and minimizes future breaking changes or inconveniences when upgrading a library version.

## Enforcing Naming Conventions

It's important to note that these are just guidelines, and the Ballerina compiler won't force you to follow these rules, except for one occasion where you can only use alphanumeric characters (As mentioned in the qualified identifier) for the module name and organization name. 

If you see a warning or error other than that, it's probably caused by a compiler extension that is part of the imported library used by you. As an example, some protocols like HTTP, gRPC, and GraphQL may enforce specific naming conventions for identifiers such as resource paths, operation names, and field names.

In such a case, you may not be able to strictly adhere to previously discussed guidelines. Also using the same names defined in the contract/specification can minimize the need for extra data transformation and mapping. To work around identifier syntax limitations, you can utilize features like quoted identifiers and character escaping.

Another valid reason to deviate from these guidelines is that they are primarily designed for English words, and conventions like camelCase or PascalCase may not make sense in other languages. In such cases, you are free to follow your conventions. However, it's important to note that you should be consistent with your conventions throughout the codebase.

## Working with Acronyms

When using acronyms like XML, JSON, or REST in identifiers, stick to capitalizing the first letter and using camelCase for the rest. If an identifier starts with an acronym, follow the standard convention for its case in the context it used.

For instance, in a function converting JSON to XML, you could use `jsonToXml` (with "json" in lowercase camelCase and "Xml" in PascalCase). Similarly, for XML to JSON, use `xmlToJson`.

For type definitions with acronyms, apply the same rule, using PascalCase and capitalizing the first letter. Examples include `XmlProperties` or `RestApiProperties`, where "Xml" and "RestApi" follow this convention.

## 📝 Naming Conventions Examples

Examples of identifiers in different contexts are shown below.

### 🐫 camelCase

CamelCase is a convention for writing compound words or phrases in which the elements are joined without spaces, and each word or abbreviation begins with a capital letter, except for the first word. In Ballerina, camelCase is used for the following identifiers.

* Function/Method Name

    e.g. `function calculateAverage() { }`, `function jsonToXml() { }`
* Function Parameters

    e.g. `function getName(string firstName, string lastName) { }`

* Variable (Local or Global), Configurable, Listeners
    ```
    int number = 10;
    boolean isOpen = true;

    configurable int port = ?;
    configurable string hostName = ?;

    listener http:Listener httpListener = new (port);
    http:Client restClient = check new (hostName);
    ```

* Record Fields (Or as specified)
    ```
    type Person record {
        string firstName;
        string lastName;
        string home\-address;
    };
    ```
    💡 In Record Fields, `\-` is used to escape the `-` character.

* Object/Class Fields
    ```
    type PersonObject object {
        string firstName;
        string lastName;
    };

    class StudentObject {
        *PersonObject;
        string firstName = "John";
        string lastName = "Doe";
    }
    ```
    💡 Unlike, records, we do not use objects to represent data from an external system. Therefore, we do not have to worry about escaping the "-" character. It is important to use proper naming conventions for object fields.

* Anonymous function parameter list
    ```
    function (string, string) returns string getFullName = (fname, lname) => fname + " " + lname;
    ```
    💡 Use simple and short names for the Anonymous function parameter list.

* Worker Name
    ```
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
    ```
* XML Namespace
    ```
    xmlns "http://bal.tips" as balTips;
    ```
    💡 XML namespace identifier must be short, a single word, and typically written in lowercase letters. Use camelCase if you need multiple words.

### 🅟 PascalCase

PascalCase is another convention for writing compound words or phrases in which the elements are joined without spaces, and each word or abbreviation begins with a capital letter. In Ballerina, PascalCase is used for the following identifiers.

* Type Definitions, Classes, Enum
    ```
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
    ```

### 🐍 UPPER_SNAKE_CASE

UPPER_SNAKE_CASE is a convention for writing compound words or phrases in which the elements are joined without spaces using underscores, and each word or abbreviation is written in uppercase letters.  

* Constants 
    ```
    const PI = 3.141592653589793;
    const MAX_VALUE = 9223372036854775807;
    ```

### ➖ kebab-case/dash-case

kebab-case/dash-case is a convention for writing compound words or phrases in which the elements are joined without spaces using dashes, and each word or abbreviation is written in lowercase letters.

* Service/Resource Path Segment - (or as specified)
    ```
    service /inventory on new http:Listener (9090) {
        resource function get item\-list () { }
        resource function get customer\-info () { }
    }
    ```
    💡 In Resource Path Segment, `\-` is used to escape the `-` character.


# 🚀 Advanced Topics

## 🎚️ Identifier Scoping Rules

Identifiers in Ballerina have their own scope, with different rules based on the context. There are two main scopes:

* **Module-scope**: You can reference identifiers declared here anywhere in the module. If they're public, you can reference them outside the module too.
* **Block-scope**: These identifiers are limited to the block they're declared in, usually within curly braces.

Additionally, there are three symbol spaces for these scopes. Here's a quick rundown of language constructs in each Ballerina symbol space:

**Language Constructs/Symbol Space and Scopes**

| Symbol-Space / Scope  | *main*    | *prefix*      | *annotation tag*   |
|:--------------------------:|------------|-----|----|
|        Module-Scope        | Variables, Constants, Types, Functions, and other identifiers that do not belong to any of the other two spaces  | Prefixes declared by import declarations and XML namespace declarations | Annotation tags declared by annotation declarations |
|        Block-Scope         | Any statement, action, expression that supports type-binding patterns/binding patterns, such as variable definition statements, foreach statements, let expressions, and query from clauses. Additionally, function parameters are also part of the block scope.  | Local XML namespace declaration statements  | N\A    |
{.tip-table .text-center}

## Variable Shadowing Rules

You can use the same identifier name for both block-scope and module-scope within the same symbol space. Within the block-scope region, it'll take priority over the module-scope. But watch out! If you declare two same-named identifiers with overlapping block-scope in the same symbol space, you'll get a compile error.

```ballerina {filename="variable_shadowing-error.bal" lines="3 4 5 7 9 11 16 17 18" result="error" trim=false}
import ballerina/io; //!
//!
function sumIf(int num1, int num2, int max) returns int { //$
    // num1, num2, max are block-scope variables //!
    // max hides a module-scope variable with the same name //!

    int a = num1; // block-scope, hides module-scope identifier //4
    if a > max { //$
        int a = 0; // Compile time error. Already defined in a block-scope //$
    } else if num2 > max {
        int num2 = 0; // Compile time error. Already defined in a block-scope
    } //$
    return a + num2;
} //$

// module-scope identifiers location does not matter
int a = 100; // module-scope //$
public int max = 40; // module-scope and public //$

public function main() { //!
    io:println(sumIf(a, a, 200));    //!
} //!
```

## Keywords/Predefined Identifiers and Special Cases

Ballerina has a large set of reserved keywords that are reserved for language constructs. Sometimes, common words such as "order" or "limit" may also be reserved keywords. In such cases, you can still use these keywords as identifiers by using the quoted identifier syntax.

However, there are special cases where you don't need to use the quoted identifier syntax. One such case is when using built-in type names. These are the types that are defined in the language specification, yet you can use them as identifiers without using the quoted identifier syntax.

|         |         |          |             |          |
|---------|---------|----------|-------------|----------|
| boolean | decimal | error    | float       | future   |
| int     | string  | xml      | any         | anydata  |
| byte    | never   | handle   | readonly    | function |
{.tip-table .text-center}

Another example of where you don't need to use the quoted identifier syntax is when working with pre-declared module prefixes. These prefixes are used to refer to the language libraries and are predefined by the Ballerina language. Here is the list of pre-declared module prefixes.

|         |         |          |             |          |
|---------|---------|----------|-------------|----------|
| boolean | decimal | error    | float       | function |
| future  | int     | map      | object      | stream   |
| string  | table   | typedesc | transaction | xml      |
{.tip-table .text-center}

Additional `map`, `join`, and `start` are keywords, but they are allowed as method names without the quoted identifier syntax.

## Runtime Representation

In Ballerina, some identifiers have runtime meaning, while others do not. For example, variable names are converted into something sequential during bytecode generation, but debugger information is still maintained, so we can refer to those variables using the original identifier name during a debugging session. 

However, not all identifiers are converted into sequential identifiers. For example, record fields, some level of type information, and function names have runtime meaning and are not de-sugared. In these cases, we keep the original identifier name as it is, as it has runtime significance.

# Conclusion

In this post, I have covered the basics of identifiers including syntax variations, naming conventions, and scoping rules. Then, discuss the flexibility when working with JSON data, and covered some advanced topics such as keywords, predefined identifiers, and runtime representation. I hope you found this post useful.
