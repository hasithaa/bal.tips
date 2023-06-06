---
title: "Designing Numeric Literals for Ballerina"
description: "Explore the journey of designing the numeric type system for Ballerina Lang, a modern programming language originally developed for network integration. Learn about the history, the challenges, the solutions adopted, and how the language handles numeric literals, conversions, and performance implications. Get insights into the logic behind the type system and the trade-offs made for striking a balance between ease of use and performance"
date: 2023-06-05
type: blog
weight: 5000
ballerina_lang : [literal]
ballerina_type : [int, float, decimal, byte]
ballerina_feature : [compiler, type-system, jballerina]
keywords : 
  - Ballerina Language
  - Numeric Type System
  - Decimal Type
  - Float Type
  - Int Type
  - JSON support in Ballerina
  - Language Practices
  - Structure-based Type Checking
  - Union Types in Ballerina
  - Literal Representation in Ballerina
  - Ballerina Performance
  - Ballerina Auto-Casting and Conversion
  - Numeric Literal Algorithm in Ballerina
  - Ballerina Runtime Handling
highlight: []
canonicalURL: https://www.reddit.com/r/ProgrammingLanguages/comments/13zjq3y/ballerina_numerical_types_learning_points/
canonicalSite : "Reddit /r/ProgrammingLanguages/"
---

# Designing Numeric Literals for Ballerina

Today, I'd like to share our experience and lessons learned while designing the numeric type system for [Ballerina Lang](https://ballerina.io). 

## History 

In the early days of Ballerina, we adopted `int`, `long`, `byte`, `float`, and `double` as dedicated types for each common case. At this stage, we were primarily drawing inspiration from other languages and didn't fully consider the implications of having numerous numerical data types. Our approach was greatly influenced by Java because at that time Ballerina was initially a JVM-based interpreted language.

However, we soon realized that maintaining separate data types was burdensome for our users. Ballerina's primary target audience were not hardcore developers, but individuals who primarily used to work with DSL (Domain Specific Languages) and low-code/no-code editors. At this level of development, the complexity of having multiple types was a major drawback and which led to a lot of confusion among developers. (when to use `int` vs `long` vs `byte` vs `float` vs `double` etc.)

Concurrently, we identified a requirement to introduce `decimal` as a primary type, given Ballerina's usage for network integration and the handling of financial data - one of its primary use cases. Consequently, the inclusion of a more precise type like `decimal` became a must. Another requirement was to support decimal is to support pure JSON numbers.

Considering these new requirements, we revisited our approach and looked into modern language practices. Simultaneously, we adopted a structure-based type checking system which greatly simplified our problem.

## Solution 

We ended up with three built-in basic types: `int`, `float`, and `decimal`.

- `int` - Represents 64-bit signed integer values
- `float` - Represents 64-bit IEEE 754-2008 binary floating-point numbers
- `decimal` - Represents 128-bit IEEE 754-2008 decimal floating-point values

It is simple to explain and supports Ballerina upcases (I will cover to Performance aspects later. :) ). With help of union types, we defined other types such as `byte`, `signed32`, `unsigned32`, `signed16`, `unsigned16`, `signed8`, and `unsigned8` as subtypes of `int`. This was done to reduce complexity and to still provide a range of types for different advanced use cases. For example, the `byte` type is defined as a union of integers between 0 and 255, inclusive. The same principle applies to the other integer subtypes. 

This design facilitated better better support for JSON. Ballerina defines the json type as a union of `()|int|float|decimal|boolean|string|json[]|map<json>`, preferring `decimal` as the default numeric type when constructing a json value from a string.

Another design decision we made was to not to support implicit conversion among numerical types. I will discuss this in details next. 

The basic idea is make the static typing simple and easy to understand. But at runtime, with enough information, we can represent a value in best optimized way, which is a implementation detail and mostly developers don't want to know. 

## Working with Literals 

In Ballerina, a value written as a numeric literal always represents a specific type, which is determined by the literal itself. The type of a literal can be one of the basic types, such as `int`, `float`, or `decimal`.

For example, the literal 10 represents the integer value

 10, and its basic type is `int`. However, in some contexts, the same literal 10 can also represent a floating-point value 10.0 or a decimal value 10. Depending on the context, the compiler determines the appropriate type of the literal to use.

To determine the type of numeric literals, we have defined a 3-step algorithm. To help explain this, I've included a link to a [playground](https://bal.tips/docs/types/rules/numeric-literals/#algorithm) that visualizes the process.

## Auto-Casting and Conversion

Ballerina does not support implicit conversion among numerical types. This safeguard helps prevent unintended loss of precision and unexpected program behavior.

For example, the following code would result in a compile-time error:
    
```ballerina {filename="numeric-error.bal" result="error"}
float x = 10.0; //$
decimal y = 10 + x; //error //$
int z = 1.0; // error - floating point literal on the right-hand side. //$
```
However, we do allow safe type inference from literals, as seen in float x = 1. This rationale is clarified in the earlier mentioned algorithm.

So, while we can't entirely prevent misuse through adding a cast and the like, Ballerina's strict typing and explicit conversion requirements at least alert the user to potential issues during compile time. This is particularly important for our main focus - network integration - where identifying such issues at compile time rather than runtime is crucial.

## Performance Implications

It's clear that using the new model to represent an int32 list requires the allocation of an int64 list, which isn't optimal. For a byte list, this could even be considered overkill. However, in order to maintain performance, byte[] is specially handled in the runtime.

While there are future plans to allocate memory based on static type for other integer types, currently they're all modeled as int64. Given that Ballerina's target applications are not system applications (such as OS development, low-level apps), this is a known compromise we've had to make to strike a balance between ease of use and performance.

--- 

This blog originally published on [Reddit /r/ProgrammingLanguages/](https://www.reddit.com/r/ProgrammingLanguages/comments/13zjq3y/ballerina_numerical_types_learning_points/)
