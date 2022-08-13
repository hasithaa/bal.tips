---
title : "Hello, World!"
date : 2022-07-03T01:01:27+05:30
kind : tip 
tags : ["hello-world", "io:println"] 
code : ["main.bal"] 
weight  : 0000000001 
size : "small"
disableNavChevron : true
summary : "Let's write 'Hello, World!' to *stdout*."
---

{{< slide url="main-slide" >}}

---

### Source Code

{{< gencode >}}

#### How to run this example?

- Download `main.bal` file.
- Open the terminal and `cd` to the `main.bal` file location.
- There are two ways to run this.
  - Execute it directly using `bal run main.bal` command.
  - Build the executable `jar` file first using `bal build main.bal`. Then run it using `bal run main.jar`  
