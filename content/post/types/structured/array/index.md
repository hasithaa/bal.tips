---
title : Array Type
description : About type array
author: Hasitha
date: 2023-01-01
weight : 5210
btype : [list]
blang : [type]
bmodule : [array]
highlight : []
draft : true
---
{{<md class="summary">}}
An Array type describes a set of list values. A list value is a container that keeps its members in an ordered list and the index of the member is used to access an member. The Array syntax specifies a type, and all members of the list must belongs to that type. The Array syntax is variable length (open) by default unless its length is specified.
{{</md>}}
{{<md class="syntax">}}

* Variable Length :  `𝓣[]`
* Fixed Length :  `𝓣[𝓲]`
* Fixed Length - Inferred :  `𝓣[*]`
* Multi Dimension :  `𝓣[][][]`, `T[𝓲][𝓳][𝓴]`

<small>Here 𝓣 is the member type, 𝓲, 𝓳 and 𝓴 are integer values(or integer constants)</small>
{{</md>}}
{{<md class="tldr">}}

* List Constructor<br> e.g. `[1, 2, 3, 4]`, `[[1,2], [3,4]]`
* Lang Library : [*ballerina/lang.array*]({{< linkh "#" >}})
* Iterable 🔁

{{</md>}}

<!--more-->

🚧 More Details Coming Soon!
