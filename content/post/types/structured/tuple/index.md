---
title : Tuple Type
description : About type tuple
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
Like an [Array]({{< relref "../array" >}}), a Tuple type describes a set of list values. However, The Tuple syntax specifies a set of types separately for each member of the list. The Tuple syntax is fixed in length by default, but it can be variable length with a **rest field**.
{{</md>}}
{{<md class="syntax">}}
* Fixed Length : `[𝓣, 𝓢]`
* Open Length : `[𝓣, 𝓡...]`

<small>Here 𝓣 and 𝓢 are member types. 𝓡 is the rest field type.</small>
{{</md>}}
{{<md class="tldr">}}
* List Constructor<br> e.g. `[1, 2, 3, 4]`
* Lang Library : [*ballerina/lang.array*]({{< linkh "#" >}})
* Iterable 🔁
{{</md>}}

<!--more-->
<hr>
