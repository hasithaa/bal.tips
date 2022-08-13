+++
title = "Let's Write a Hello, World!"
date = 2022-08-13T01:06:51+05:30
type = "slideshow"
kind = "slide"
theme = "league"
summary = "Let's learn how to write a 'Hello, World!' program."
[revealOptions]
transition= 'concave'
controls= true
progress= true
history= true
center= true
+++

## Hello, World!

-->>>--

### Create *`main.bal`*

Create *`main.bal`* file and Open it.

{{< scode did="main.bal" >}}{{< /scode >}}

{{< sfrag class="details">}}
💡 Use VSCode with Ballerina Extension. 
{{< /sfrag >}}

-->>>--

### Add *`main`* function

{{< scodef did="main.bal" file="/examples/helloworld/main.bal1">}}

{{< sfrag class="details">}}
- The *`main`* function is the program entry point.
- The *`public`* keyword is required to make it visible outside.
{{< /sfrag >}}

-->>>--

### Import *`ballerina/io`* module

{{< scodef did="main.bal" file="/examples/helloworld/main.bal2" lines="1">}}

{{< sfrag class="details">}}
- A module is a collection of Ballerina codes.
- Refer a module using an organization (eg: *`ballerina`*) name and a module name (eg: *`io`*).
{{< /sfrag >}}

-->>>--

### Call *`io:println`* function

{{< scodef did="main.bal" file="/examples/helloworld/main.bal3" lines="4">}}

{{< sfrag class="details">}}
- Imported module name works as a prefix, i.e *`io:`*
- We use the *`io`* module's *`println`* function to write to the *`stdout`*.
- Let's pass a string value *`"Hello, World!"`* to the function.
{{< /sfrag >}}

-->>>--

### Let's add one more line

{{< scodef did="main.bal" file="/examples/helloworld/main.bal">}}

{{< sfrag class="details">}}
😊 string type supports unicode code points too. 
{{< /sfrag >}}

-->>>--

### Run *`main.bal`*

Open the terminal and execute.

{{< scode >}}bal run main.bal{{< /scode >}}

{{< sfrag >}}
{{< scodef did="main.bal" file="/examples/helloworld/main.bal.out" method="hugo">}}
{{< /sfrag >}}
