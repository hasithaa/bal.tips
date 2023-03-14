---
title : "A Beginner's Guide to Ballerina Language"
description : "This tutorial will provide a gateway into the world of Ballerina. Learn how to build a 'Hello World' program by harnessing the power of functions, modules, expressions, statements. Step into the world of Ballerina, and say hello to a new way of programming!"
keywords : [ballerina, programming, language, hello world, functions, modules, expressions, statements]
images : [/docs/introduction/basics/main.png]
date: 2023-01-01
weight : 1010
type : docs
ballerina_lang : [function, vardef]
ballerina_feature : [main, function, expression, statement, module, package]
ballerina_module : [ballerina-io]
highlight : [main.bal]
---

# Hello, World

Welcome to the world of Ballerina! Let's get started with writing a "Hello World" program.
First start by creating a file called **main.bal**, and open it up in a text editor such as Visual Studio Code (VSCode). To get the best experience, be sure to install the Ballerina Extension. Save the file with the following code.  

<!--more-->

{{<code id="0" title="Hello World, Program."/>}}

There are two ways to run this.

1. Execute it directly using `bal run main.bal` command.
2. First build the executable `jar` file using `bal build main.bal`. Then run it using `bal run main.jar`  

# Ballerina Basics

To become familiar with the syntax of Ballerina Language, I will explain the **Hello World** program step by step. It uses a syntax and paradigm inspired by C-style programming languages such as C, Java, and C++.

## Functions

Functions are the building blocks of a program in Ballerina. To create a Function, start with the keyword `function`, followed by the function's name, with the input parameters written inside parentheses. After that, use the `returns` keyword with a type to indicate the output of the function. Finally, write the function's body. Here is the main function.

{{< balcode "1 2" "Function definition syntax - function name is `main`" >}}
function main() returns () {
}
{{</ balcode >}}

This main function does not return a value. A function that does not return a value in Ballerina is equivalent to returning *nil* - `()`.

As a best practice, we can omit the `returns ()` from the function signature and simply write the above as bellow.

{{< balcode "1 2" "Shortened function definition syntax by omitting `returns ()`" >}}
function main() {
}
{{</ balcode >}}

The *`main`* function is the primary entry point into a Ballerina program. It must be declared as *`public`* in order to be visible to the outside. Here is the final main function.

{{< balcode "1" "Function definition syntax with `public` qualifier">}}
public function main() {
}
{{</ balcode >}}

Additionally, Services are also entry points for a Ballerina program, which enable parallelism. I will discuss services in details later.

## Modules and Packages

A **Module** in Ballerina is a collection of Ballerina code, and it is the unit of compilation. Modules are shareable and reusable. It can consist of one or more source files. In this example, `main.bal` work as a single file module.

One or more modules can be grouped together into a Ballerina **Package**. Ballerina packages can be published or retrieved from [Ballerina Central](https://central.ballerina.io "ballerina package repository"). A Package has its own directory structure and I will discuss this further in more detail later.

{{< balcode "1" "Import declaration syntax">}}
import ballerina/io;

public function main() {
}
{{</ balcode >}}

Let's use the `ballerina/io` module, a standard library for IO operations. Before calling its operations, we must first import the module using an **Import declaration** by specifying the organization name **ballerina** and the module name **io**.

The last part of the imported module name acts as a prefix, i.e., *`io:`*. This prefix will then be used to call the io module's operations. Alternatively, we can define our own prefix, such as `bio`, using the syntax `import ballerina/io as bio;`.

The Ballerina compiler generates an error for the above program, stating *"unused module prefix 'io'"*, as the `io` module has not been used in the program. To call a function from the `io` module, we can use the function call syntax:

## Function Call Syntax and Expressions

The `io` module's `println()` function can be used to write to **stdout**. To do this, call the function by its name with the module prefix (This is a qualified name) and pass a string value inside the parentheses, for example `"Hello, World!"`.

{{< balcode "4" "Function call expression">}}
import ballerina/io;

public function main() {
  io:println("Hello, World...!");
}
{{</ balcode >}}

Here `io:println("Hello, World...!")` is a **Call Expression**. An **Expression** is a combination of values, variables, operations, or even sub-expressions that produce **a result or an error**.  There are many expressions in Ballerina, which I will cover in details later.

## Statements and Actions

A **Statement** is a line of code that performs a specific task. In the last step, the `io:println();` **call statement** was used to print a message. This statement consists of a **call expression** followed by a semicolon `;`. Additionally, a statement can be a declaration, variable assignment, flow control, etc. Ballerina has a wide variety of statements, such as `if`, `while`, `foreach`, `match`, and more, which will be discussed in detail in upcoming posts.

In Ballerina, there is another syntactic category called **Actions**, which are like expressions, but they yield a value. The syntax for actions is carefully designed such that there is parity between the source and the graphical diagram. That is a topic for another post.

Let us add a variable declaration statement to our example. Ballerina is a C-style language, so variable definitions start with the type then followed by a variable name. Optionally, you can give an initial value expression after the equal sign `=`. The statement is then terminated with a semicolon `;`.

{{< balcode "6 7" "Variable declaration syntax">}}
import ballerina/io;

public function main() {
    io:println("Hello, World...!");

    string greeting = "👋🌏";
    io:println(greeting);
}
{{</ balcode >}}

In the example, I have defined a `string` variable called `greeting` and printed its value using the `io:println()` function.  

# Conclusion

In this post, we learned about Ballerina basic by writing a "Hello, World...!" program.  Below are the main points to remember:

<!--tldr-->
{{<md class="keypoint">}}

![hello world](/docs/introduction/basics/main.png)

{{</md>}}
{{<md class="tldr">}}

* Ballerina is a C-style language.
* Functions are the building blocks of a program.
* The main function acts as an entry point for a program.
* A Module is a collection of Ballerina codes. One or more modules grouped together form a package.
* Expression and Statement, and Actions are syntactic categories.

{{</md>}}