---
title : "Comments, Docs and Metadata!"
date : 2022-11-17T07:53:29+05:30
kind : tip 
tags : ["comment", "annotation"] 
code : [""] 
weight  : 10400000012
size : "small"
disableNavChevron : true
---

It is common to keep documentation within the source code because it is easy to keep up-to-date documentation with the code changes. In many programming languages, Documentation kept as comments & sometimes formatted in a particular way (e.g.: `/** */` syntax in Java). 

In Ballerina, You can use {{< tag "documentation">}} to document Ballerina constructs. Ballerina {{< tag "documentation">}} starts with `#`. It is a common mistake that the developer uses comments (`//`) for documentation purposes. 

<!--more-->

Some programming languages often use comments to store metadata about the program. In Ballerina, you can use {{< tag "annotation">}} for this purpose.