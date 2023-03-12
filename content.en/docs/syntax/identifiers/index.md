---
title : Identifiers
description : ""
weight : 200
---

# Identifiers 

An identifier is a name given to an element in a program, such as a variable, function, or type. Identifiers allow programmers to identify and refer to specific elements in the source code. 

The use of appropriate identifiers is important for writing readable and understandable code. Different programming languages have their own rules and conventions for identifiers, and in this post, I will focus on how to master identifiers in Ballerina.

I will start by covering the basics of identifiers, including their usage and syntax. Then, I will delve into more advanced concepts, such as the semantic rules associated with them. By the end of this post, you will have a thorough understanding of identifiers in Ballerina and be able to write clean, well-organized code.

## Syntax 

### Normal Syntax
When writing code in Ballerina, it's important to understand the basic usage of identifiers.

An identifier in Ballerina is defined by the following regular expression:

`<Initial_Char><Initial_Char | Digits>*`


The `Initial_Char` can be an ASCII letter (`A-Z` or `a-z`), an underscore (`_`), a Unicode identifier character (excluding certain [characters](https://ballerina.io/spec/lang/master/#UnicodeNonIdentifierChar)) or any valid Unicode code point escaped using `\u{XXXX}` or a non-empty character using `\`. After the `Initial_Char`, any combination of characters including digits is allowed. However, using reserved words such as keywords will result in a compilation error.

Let's look at some valid identifiers and invalid identifiers.  

<TODO Add example here>

Ballerina supports the use of Unicode characters in identifiers. When we designed the language, supporting Unicode identifiers was one of the primary design requirements, because it makes it easier for programmers to use non-ASCII characters, domain-specific terminology, and support non-English languages in their code. For example, this is particularly useful when working with data such as JSON or XML that may contain characters from various languages and symbols. 

> Ballerina Identifier follows the requirements of Unicode TR31 for immutable identifiers; the set of characters is immutable in the sense that it does not change between Unicode versions. 


### Quoted Identifier

As you may have noticed, the previous syntax we discussed disallowed keywords and identifiers that start with digits. However, this limitation can be overcome using a Quoted Identifier syntax:

`'<Initial_Char | Digits>*`

It is same syntax, instead identifier starts with single quote `'`. This allows any combination of characters, including keywords and identifiers that start with digits, to be used as an identifier. Here are some examples. 

<TODO Add example here>


### Character Escaping 

As previously mentioned, Ballerina allows any valid Unicode code point to be used in an identifier, which can be escaped using the `\u{XXXX}` syntax or a non-empty character using the `\` syntax. This provides even more flexibility for programmers to use non-ASCII characters and support non-English languages in their code.

<TODO Add example here>

However, there are some restrictions on the use of these escape sequences in identifiers, as defined in the [Ballerina Language Specifications](https://ballerina.io/spec/lang/master/#lexical_structure). For example, `\u{0000}` to `\u{D800}` and from (excluding) `\u{DFFF}` to `u{10FFFF}` are not allowed in identifiers. 

### Qualified Identifier 

Identifiers are not only used to name elements in a program but also to refer to them. The syntax we discussed so far works well to refer to elements locally within the source of the module. However, to refer to another module, you need a qualified identifier.

Qualified identifier syntax has an additional identifier (module-prefix) at the beginning of the identifier to indicate the module that is being referred to. It must be the same as the module-prefix specified in an import declaration in the same source file. To separate the module-prefix and the identifier, there is a colon `:`, and there should not be any whitespace between them.

`<module-prefix-identifier>:<identifier>`

> In the Ballerina platform, there are restrictions on choosing the organization and module name. Unlike other identifiers, they only support the use of alphanumeric characters for the module name and organization name. The module name and organization name must start with an ASCII letter (`A-Z`, `a-z`) and may contain an underscore `_` to separate words that are written in ASCII letters and digits (`0-9`). They must not end with an underscore. 

## Usages and Naming Conventions

Identifiers are used in multiple context. Here I have list them. 

* Type Definitions
  * To refer already defined type, such as built-in types and user defined types
  * Record/Object field
* Function parameter name
* Objects
  * Method name 
  * Resource Path Segment


## Naming Conventions 

Identifiers can be used in different language contexts, and depending on the context, there are generally accepted best practices for naming identifiers. 

However, depending on the requirements, you may not be able to follow the same guidelines mentioned bellow. Sometimes you have to comply with certain specifications or contracts. For example, Ballerina developers implementing integrations often have to adhere to OpenAPI/GraphQL/gRPC contracts and use the names defined in the contract. In such cases, using the same name can help reduce unnecessary data transformation and mapping.

Another valid reason to deviate from these guidelines is that they are designed for English words, and camelCase, PascalCase don't make any sense in some other languages. In such cases, you are free to follow your own convention.



|Context|Case|Examples|
|---|---|---|
|Variables, Functions, Configurable, Listener Record/Object fields | camelCase| `number`, `isOpen`, `createResponse()` |
|Type definitions, Classes, Enum, Annotation| PascalCase | `Person`, `State`, `Connector`, `Display` |
|Service/Resource Path| kebab-case / dash-case | `about-us`, `customer-info` |
|Const | UPPER_SNAKE_CASE | `PI`, `INT_MAX` |


It's important to note that these are just guidelines, and the Ballerina compiler won't force you to follow these rules, except for one occasion where you can only use alphanumeric characters (As mentioned in the qualified identifier) for the module name and organization name. If you see a warning or error other than that, it's probably caused by a compiler extension that is part of the imported library used by you.

<TODO : Good Example >

## Advanced Topics

### Identifier Scope

### Keywords and Predefined Identifiers

Predefined built-in types (identifier)

* boolean
* int
* float
* decimal
* string
* xml
* error
* function
* future
* handle
* any
* readonly
* anydata
* json
* byte


### Runtime Representation



