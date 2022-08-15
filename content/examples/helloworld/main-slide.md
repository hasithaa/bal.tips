+++
title = "Let's Write a Hello, World!"
date = 2022-08-13T01:06:51+05:30
type = "slideshow"
kind = "slide"
theme = "league"
weight = "1100000000"
summary = "Let's learn how to write a 'Hello, World!' program."
[revealOptions]
transition= 'concave'
controls= true
progress= true
history= true
center= true
+++

##  `Hello, World!`

Let's learn how to write a simple Ballerina program.

{{< snext txt="Start Learning" >}}

-->>>--

### Create a File

{{< scode did="main.bal" >}}{{< /scode >}}

Create *`main.bal`* file and open it.

<div class="details" >
💡 Use VSCode with Ballerina Extension for the best experience.  
</div>

  

-->>>--

### Add *`main`* function

{{< scodef did="main.bal" file="/examples/helloworld/main.bal1">}}

{{< sdown >}}

--vvv--

### *`main`* function Explained

{{<md class="details">}}
- Functions are building blocks of a program.
- A function is a code block, written to perform specific tasks.  
- The *`main`* function is the program entry point.
- The *`public`* keyword is required to make it visible outside.
{{</md >}}

{{< scodef did="main.bal" file="/examples/helloworld/main.bal1">}}
  
-->>>--

### Import *`ballerina/io`* module

{{< scodef did="main.bal" file="/examples/helloworld/main.bal2" lines="1">}}
{{< sdown >}}

--vvv--

### Module Explained

{{< md class="details">}}
- A module is a collection of Ballerina codes, also it is the unit of the compilation.
- A module can contain one or more source files. Here `main.bal` work as a module.
- Modules are sharable and reusable. 
- Import a module using an organization name and a module name.
  - Here organization name is *`ballerina`*, the module name is *`io`*
{{< /md >}}

{{< scodef did="main.bal" file="/examples/helloworld/main.bal2" lines="1">}}
  
-->>>--

### Call *`io:println`* function

{{< scodef did="main.bal" file="/examples/helloworld/main.bal3" lines="4">}}
{{< sdown >}}

--vvv--

### *`io:println`* function call explained

{{< md class="details">}}
- The last part of the imported module name works as a prefix, i.e., *`io:`*
  - Or define the prefix using the syntax `import ballerina/io as bio;`

- Use the *`io`* module's *`println`* function to write to the *`stdout`*.
- A string value *`"Hello, World!"`* is passed to the function.
{{< /md >}}

{{< scodef did="main.bal" file="/examples/helloworld/main.bal3" lines="4">}}

-->>>--

### Let's add one more line

{{< scodef did="main.bal" file="/examples/helloworld/main.bal">}}
  
{{< md class="details">}}
😊 string type supports Unicode code points too. 
{{< /md >}}

-->>>--

### Compile and Run

Open the terminal and execute.

{{< scode >}}bal run main.bal{{< /scode >}}

{{< sfrag >}}
{{< scodef did="main.bal" file="/examples/helloworld/main.bal.out" method="hugo">}}

{{<md class="details">}}
[🔁Start Over](#/0) or [💡 Learn More Tips](/)
{{</md>}}
{{< /sfrag >}}
