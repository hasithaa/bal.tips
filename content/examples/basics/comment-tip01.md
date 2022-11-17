---
title : "No Multiline Comments"
date : 2022-11-17T07:53:29+05:30
kind : tip 
tags : ["comment"] 
code : [""] 
weight  : 10400000011
size : "small"
disableNavChevron : true
---

Multi-line comments are useful when providing large text descriptions or commenting on multiple lines of the code. Many languages use `/*  */` syntax for multiline comments. 

**Ballerina doesn't support this syntax**. Instead, you can use multiple `//` comments for the same purpose.

<!--more-->

### IDE Support

IDEs such as **VSCode** provide better support when commenting out multi-line code blocks.

- Select lines you want to comment.
- Press `Ctrl` + `/` key.
