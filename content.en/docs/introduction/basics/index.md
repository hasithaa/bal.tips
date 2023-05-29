---
title : "A Beginner's Guide to Ballerina Language"
description : "This tutorial will provide a gateway into the world of Ballerina. Learn how to build a 'Hello World' program by harnessing the power of functions, modules, expressions, statements. Step into the world of Ballerina, and say hello to a new way of programming!"
keywords : [ballerina, programming, language, hello world, functions, modules, expressions, statements]
images : [/docs/introduction/basics/main.png]
date: 2023-01-01
weight : 1010
ballerina_lang : [function, vardef]
ballerina_feature : [main, function, expression, statement, module, package]
ballerina_module : [ballerina-io]
highlight: [main.bal]
menu:
  main:
    name: "Hello World - Language Basics"
    pre: <i class="bi bi-lightbulb-fill"></i>
    parent: guides
    params:
      group: "intro"
---

# Hello, World

Welcome to the world of Ballerina! Let's get started with writing a "Hello World" program.
First start by creating a file called **main.bal**, and open it up in a text editor such as Visual Studio Code (VSCode). To get the best experience, be sure to install the Ballerina Extension. Save the file with the following code.  
{.drop-cap}

```ballerina {filename="main.bal" result="output" trim=false codeview=false}
import ballerina/io; //$
//$
public function main() { //$
    io:println("Hello, World...!"); //$
//!
    string greeting = "👋🌏"; //!
    io:println(greeting); //!
} //$
```

There are two ways to run this.

1. Execute it directly using `bal run main.bal` command.
2. First build the executable `jar` file using `bal build main.bal`. Then run it using `bal run main.jar`  

# Ballerina Basics

To become familiar with the syntax of Ballerina Language, I will explain the **Hello World** program step by step. It uses a syntax and paradigm inspired by C-style programming languages such as C, Java, and C++.

## Functions

Functions are the building blocks of a program in Ballerina. To create a Function, start with the keyword `function`, followed by the function's name, with the input parameters written inside parentheses. After that, use the `returns` keyword with a type to indicate the output of the function. Finally, write the function's body. Here is the main function.

```plan { title="Function Definition Syntax" lang="ballerina" lines="1 2"}
function main() returns () {
}
```

This main function returns *nil* - `()`. In Ballerina function that returns *nil* is equivalent to a function that does not return a value. So, the above function can be written as follows.

```plan { title="Function Definition Syntax Without Returns" lang="ballerina" lines="1 2"}
function main() {
}
```

## Program Entry Points

The *`main`* function is the primary entry point into a Ballerina program. It must be declared as *`public`* in order to be visible to the outside world. Here is the final main function.

```plan { title="Public Main Function" lang="ballerina" lines="1"}
public function main() {
}
```

Additionally, Services are also entry points for a Ballerina program, which enable parallelism. I will discuss services in details later.

## Modules and Packages

A **Module** in Ballerina is a collection of Ballerina code, and it is the unit of compilation. Modules are shareable and reusable. It can consist of one or more source files. In this example, `main.bal` work as a single file module.

One or more modules can be grouped together into a Ballerina **Package**. Ballerina packages can be published or retrieved from [Ballerina Central](https://central.ballerina.io "ballerina package repository"). A Package has its own directory structure and I will discuss this further in more detail later.

## Import Declaration

Let's use the `ballerina/io` module, a standard library for IO operations. Before calling its operations, we must first import the module using an **Import declaration** by specifying the organization name **ballerina** and the module name **io**.

```plan { title="Import Declaration Syntax" lang="ballerina" lines="1"}
import ballerina/io;

public function main() {
}
```

The last part of the imported module name acts as a prefix, i.e., *`io:`*. This prefix will then be used to call the io module's operations. Alternatively, we can define our own prefix, such as `bio`, using the syntax `import ballerina/io as bio;`.

The Ballerina compiler generates an error for the above program, stating " *unused module prefix 'io'* ", as the `io` module has not been used in the program. To fix this, we can use the `io` module's `println` function to print a message to the console.
{.alert .alert-warning}

## Function Call Syntax and Expressions

The `io` module's `println()` function can be used to write to **stdout**. To do this, call the function by its name with the module prefix (This is a qualified name) and pass a string value inside the parentheses, for example `"Hello, World!"`.

```plan { title="Function Call Syntax" lang="ballerina" lines="4"}
import ballerina/io;

public function main() {
  io:println("Hello, World...!");
}
```

Here `io:println("Hello, World...!")` is a **Call Expression**. An **Expression** is a combination of values, variables, operations, or even sub-expressions that produce **a result or an error**.  There are many expressions in Ballerina, which I will cover in details later.

## Statements and Actions

A **Statement** is a line of code that performs a specific task. In the last step, the `io:println();` **call statement** was used to print a message. This statement consists of a **call expression** followed by a semicolon `;`. Additionally, a statement can be a declaration, variable assignment, flow control, etc. Ballerina has a wide variety of statements, such as `if`, `while`, `foreach`, `match`, and more, which will be discussed in detail in upcoming posts.

In Ballerina, there is another syntactic category called **Actions**, which are like expressions, but they yield a value. The syntax for actions is carefully designed such that there is parity between the source and the graphical diagram. That is a topic for another post.

Let us add a variable declaration statement to our example. Ballerina is a C-style language, so variable definitions start with the type then followed by a variable name. Optionally, you can give an initial value expression after the equal sign `=`. The statement is then terminated with a semicolon `;`.

```plan { title="Variable Declaration Statement" lang="ballerina" lines="6 7"}
import ballerina/io;

public function main() {
    io:println("Hello, World...!");

    string greeting = "👋🌏";
    io:println(greeting);
}
```

In the example, I have defined a `string` variable called `greeting` and printed its value using the `io:println()` function.  

# Conclusion

In this post, we learned about Ballerina basic by writing a "Hello, World...!" program.  Below are the main points to remember:

![hello world](/docs/introduction/basics/main.png)
{.tip-50-frame}

{{<cards>}}
{{< card header="Highlights" col="6">}}
<i class="bi bi-info-lg text-primary"></i> Ballerina is a C-style language.<br>
<i class="bi bi-info-lg text-primary"></i> Functions serve as the building blocks of a program.<br>
<i class="bi bi-info-lg text-primary"></i> The 'main' function serves as the entry point for a program.<br>
<i class="bi bi-info-lg text-primary"></i> A module is a collection of Ballerina code. A package is formed by grouping together one or more modules.<br>
<i class="bi bi-info-lg text-primary"></i> Expressions, Statements, and Actions are considered syntactic categories.<br>
{{</ card >}}
{{</cards>}}
