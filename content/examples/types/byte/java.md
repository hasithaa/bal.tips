---
title : "Byte - Ballerina vs Java"
date : 2022-07-26T08:20:35+05:30
kind : tip 
tags : [byte, java] 
code : [] 
weight : 2006120010 
size : "small"
disableNavChevron : true 
seeMore : false
---

Ballerina byte type vs Java byte Comparison

{{<md class="center-ele center-txt tip-data">}}
| | Ballerina | Java |
|--|--|--|
| Type | *byte* | *byte* or *java.lang.Byte* |
| Signed | Unsigned | Signed**|
| Max value | 255 | 127 |
| Min value | 0 | -128 |
| `0000 0000` | 0 | 0 |
| `0000 0001` | 1 | 1 |
| `0111 1111` | 127 | 127 |
| `1000 0000` | 128 | -128 |
| `1000 0001` | 129 | -127 (= -128 + 1) |
| `1111 1111` | 255 | -1 (= -128 + 127)|
{{</md>}}

** Read [Two's Complement](https://en.wikipedia.org/wiki/Two%27s_complement)
<!--more-->
