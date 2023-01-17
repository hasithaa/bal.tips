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
Let us write a simple Ballerina program and Learn Ballerina Basic Concepts.
{{</md>}}

{{<md class="tldr">}} 
* Ballerina is a C-style language.
* Main function acts as an entry point for a program.
* A Module is a collection of Ballerina codes.
* Variable declaration <br> `type identifier = expr;`
{{</md>}}
<!--more-->

## Hello, World ! Example

Let us write 'Hello, World!' to *stdout*.

{{<code id="0" />}}

### How To Run This Example?

- Download the `main.bal` file.
- Open the terminal and `cd` to the `main.bal` file location.
- There are two ways to run this.
  - Execute it directly using `bal run main.bal` command.
  - Build the executable `jar` file first using `bal build main.bal`. Then run it using `bal run main.jar`  


## Ballerina Basics Explained

Here I will explain the **Hello, World!** program step by step. First Create the *`main.bal`* file and open it using the VSCode editor. Install Ballerina and WSO2 Choreo Extension for the best experience.  

### The *`main function`*

{{< balcode "1 2">}}
public function main() {
}
{{</ balcode >}}

- Functions are building blocks of a program.
- A function is a code block, written to perform specific tasks.  
- The *`main`* function acts as the entry point for the program. It is one of the entry points into a Ballerina program. Services are other entry points to a Ballerina program, which enables parallelism by default.  
- The *`public`* keyword is required to make it visible to the outside.


### *`import ballerina/io`* 

{{< balcode "1">}}
import ballerina/io;

public function main() {
}
{{</ balcode >}}

- In Ballerina, a module is a collection of Ballerina codes, also it is the unit of the compilation.
- A module can contain one or more source files. Here `main.bal` work as a module.
- Modules are sharable and reusable. 
- You can import a module using import declaration by giving the organization name and the module name.
  - Here organization name is *`ballerina`*, the module name is *`io`*

### *`io:println()`*

{{< balcode "4">}}
import ballerina/io;

public function main() {
  io:println("Hello, World...!");
}
{{</ balcode >}}

- The last part of the imported module name works as a prefix, i.e., *`io:`*
  - Or define the prefix using the syntax `import ballerina/io as bio;`
- Here, I am using the *`io`* module's *`println`* function to write to the *`stdout`*.
- A string value *`"Hello, World!"`* is passed to the function.

### Statements, Expressions, and Actions

- In the last step, `io:println("Hello, World...!");` is a Call statement. The Call Statement has a call expression followed by a semi-colon `;`.
- **A statement** is a line of code that performs a specific task. It can be a declaration, variable assignment, and flow control,  among others. Ballerina has a rich set of statements, such as `if`, `while`, `foreach`, `match`, and many more. I will discuss these in details in later posts.
- **An expression** is a combination of values, variables, operations, or even expressions, that produce a result (or error). `io:println("Hello, World...!")` is a call expression, similarly there are many expressions in Ballerina, which I will cover in details in later posts. 
- In Ballerina, there is another syntactic category called **Actions**, which are like expressions, but they yield a value. The syntax for actions is carefully designed such that there is parity between the source and the graphical diagram. That is a topic for another post.
- Let us add a variable declaration statement to our example. Ballerina is a C-style language, so variable definitions start with the type then followed by a variable name. Optionally, you can give an initial value expression after the equal sign `=`. The statement is then terminated with a semicolon `;`.
- In the example, I have defined a `string` variable called `greeting` and printed its value using the `io:println()` function.  

{{< balcode "6 7">}}
import ballerina/io;

public function main() {
    io:println("Hello, World...!");

    string greeting = "👋🌏";
    io:println(greeting);
}
{{</ balcode >}}
