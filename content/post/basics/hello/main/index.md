---
title : "'Hello, World...!' and Ballerina Basics"
description : "Ballerina 'Hello, World...!' Explained."
author: Hasitha
date: 2023-01-01
weight : 1000
bfeature : [main, function]
highlight : [main.bal]
---

{{<md class="summary">}} 
This tutorial will demonstrate the basics of Ballerina language by creating a simple "Hello World" program.
{{</md>}}

{{<md class="tldr">}} 
* Ballerina is a C-style language. 
* Functions are the building blocks of a program.
* The main function acts as an entry point for a program.
* A Module is a collection of Ballerina codes. One or more modules grouped together form a package.
* Expression and Statement, and Actions are syntactic categories.
{{</md>}}
<!--more-->

## Hello, World...!

Welcome to the world of Ballerina! Let's get started with writing a "Hello World" program. 
First start by creating a file called **main.bal**, and open it up in a text editor such as Visual Studio Code (VSCode). To get the best experience, be sure to install the Ballerina and WSO2 Choreo Extension. Save the file with the following code.  

{{<code id="0" />}}

There are two ways to run this.
1. Execute it directly using `bal run main.bal` command.
1. First build the executable `jar` file using `bal build main.bal`. Then run it using `bal run main.jar`  


## Ballerina Basics

To become familiar with the syntax of Ballerina Language, I will explain the **Hello World** program step by step. It uses a syntax and paradigm inspired by C-style programming languages such as C, Java, and C++.

### Functions

Functions are the building blocks of a program in Ballerina. To create a Function, you use the `function` keyword, followed by an identifier for the Function's name, any input parameters, an optional `returns` keyword and type, and lastly the Function's body. When you call the Function, you use its name and any associated parameters. The Function then processes these inputs and returns a result. Here is the main function. 

{{< balcode "1 2">}}
public function main() {
}
{{</ balcode >}}

This main function does not return a value. A function that does not return a value in Ballerina is equivalent to returning *nil* - `()`. As a best practice, we can omit the `returns ()` from the function signature and simply write `public function main() { }`.

The *`main`* function is the primary entry point into a Ballerina program. It must be declared as *`public`* in order to be visible to the outside. Additionally, Services are also entry points for a Ballerina program, which enable parallelism. I will discuss services in details later.

### Modules and Packages

A **Module** in Ballerina is a collection of Ballerina code, and is the unit of compilation. It can consist of one or more source files, such as `main.bal` in this example. Modules are shareable and reusable. Ballerina has a well-structured directory structure for modules. 

One or more modules can be grouped together into a Ballerina **Package**, which also has its own directory structure. Ballerina packages can be published or retrieved from [Ballerina Central](https://central.ballerina.io). I will discuss this further in more detail later.

{{< balcode "1">}}
import ballerina/io;

public function main() {
}
{{</ balcode >}}

Let's use the `ballerina/io` module, a standard library for IO operations, to write to **stdout**. Before calling its operations, we must first import the module using an **Import declaration**, specifying the organization name **ballerina** and the module name **io**. 

The last part of the imported module name acts as a prefix, i.e., *`io:`*. This prefix will then be used to call the io module's operations. Alternatively, we can define our own prefix, such as `bio`, using the syntax `import ballerina/io as bio;`.

### Function Call Syntax and Expressions

Using the `io` module's `println()` function, I can write to the **stdout** by simply calling its name followed by parentheses. Inside the parentheses, I can pass input parameters, such as the string value `"Hello, World!"`.  

{{< balcode "4">}}
import ballerina/io;

public function main() {
  io:println("Hello, World...!");
}
{{</ balcode >}}

Here `io:println("Hello, World...!")` is a **Call Expression**. An **Expression** is a combination of values, variables, operations, or even expressions that produce a result or an error.  There are many expressions in Ballerina, which I will cover in detail laster.

### Statements and Actions

A **Statement** is a line of code that performs a specific task. In the last step, the `io:println()` call statement was used to print a message. This statement consists of a call expression followed by a semicolon `;`. Additionally, a statement can be a declaration, variable assignment, flow control, etc. Ballerina has a wide variety of statements, such as `if`, `while`, `foreach`, `match`, and more, which will be discussed in detail in upcoming posts.

In Ballerina, there is another syntactic category called **Actions**, which are like expressions, but they yield a value. The syntax for actions is carefully designed such that there is parity between the source and the graphical diagram. That is a topic for another post.

Let us add a variable declaration statement to our example. Ballerina is a C-style language, so variable definitions start with the type then followed by a variable name. Optionally, you can give an initial value expression after the equal sign `=`. The statement is then terminated with a semicolon `;`.

{{< balcode "6 7">}}
import ballerina/io;

public function main() {
    io:println("Hello, World...!");

    string greeting = "👋🌏";
    io:println(greeting);
}
{{</ balcode >}}

In the example, I have defined a `string` variable called `greeting` and printed its value using the `io:println()` function.  
