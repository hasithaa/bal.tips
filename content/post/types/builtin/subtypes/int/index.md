---
title : Integer Subtypes
description : About type built-in integer subtypes
author: Hasitha
date: 2023-01-01
weight : 5501
btype : [int]
blang : [type]
bmodule : [int]
highlight : []
draft : true
---
{{<md class="summary">}}

{{</md>}}
{{<md class="syntax">}}

* `int:Signed32`
* `int:Signed16`
* `int:Signed8`
* `int:Unsigned32`
* `int:Unsigned16`
* `int:Unsigned8`

{{</md>}}
{{<md class="tldr">}}

{{</md>}}
<!--more-->

There are multiple `int` subtypes defined in the language library.

* `int:Signed32` - an `int` between `-2³¹` and `2³¹ - 1` inclusive. (32 bits using two's complement)
* `int:Signed16` - an `int` between `-2¹⁵` and `2¹⁵ - 1` inclusive. - 1 inclusive, (16 bits using two's complement)
* `int:Signed8` - an `int` between `-128` and `127` inclusive. - 1 inclusive, (8 bits using two's complement)
* `int:Unsigned32` - an `int` between `0` and `2³² - 1` inclusive. (32 bits)
* `int:Unsigned16` - an `int` between `0` and `2¹⁶ - 1` inclusive. - 1 inclusive, (16 bits)
* `int:Unsigned8` - an `int` between `0` and `255` inclusive. - 1 inclusive, (8 bits, Same as `byte`)

🚧 More Details Coming Soon!
