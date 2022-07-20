---
title : "Hello World API"
date : 2022-07-04T01:05:24+05:30
kind : tip 
tags : ["hello-world", "http:service"] 
code : ["service.bal"] 
weight  : 1000000001 
size : "large"
disableNavChevron : true
---

Let's create a *Hello, World* HTTP API. This API will accept HTTP get request at `http://localhost:8080/greeting`.

<!--more-->

I will use `ballerina/http` module to implement this API.

{{< gencode >}}

#### How to run this example?

- Download `service.bal` file and start the program using `bal run service.bal` command.
- Visit <a href="http://localhost:8080/greeting" target="_blank">http://localhost:8080/greeting</a>. You will see `{"content":"Hello, World!"}` JSON output.
-  Now let's try providing a value to the `name` query parameter. Visit <a href="http://localhost:8080/greeting?name=Ballerina" target="_blank">http://localhost:8080/greeting?name=Ballerina</a>. You will see `{"content":"Hello, Ballerina!"}` JSON output.
