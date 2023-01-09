---
title : Record Type
description : About type record
author: Hasitha
date: 2023-01-01
weight : 5210
btype : [maps]
blang : [type]
bmodule : [map]
highlight : []
draft : true
---
{{<md class="summary">}} 
Similar to map type, A Record type describes mapping values too. Similar to Tuple syntax, a Record type specify a separate type for each member of the mapping value. The term **field** is used to represent both the type of the member and its key together.
{{</md>}}
{{<md class="syntax">}}
* Open Record - Inclusive (Open to *anydata*) <br> `record { 𝓣 𝓪; 𝓢 𝓫; }`
* Open Record - Exclusive <br> `record {| 𝓣 𝓪; 𝓡...; |}`
* Close Record - *(No Rest Field)* <br> `record {| 𝓣 𝓪; 𝓢 𝓫; |}`
* Optional Field <br> `record {| 𝓣 𝓪?; |}`
* Readonly Field <br> `record {| readonly 𝓣 𝓪?; |}`
* Record Inclusion <br>`record {| *𝓣; |}`

<small>Here 𝓣 and 𝓢 are member types with their field names 𝓪 and 𝓫. 𝓡 is the rest member type.</small>
{{</md>}}
{{<md class="tldr">}}
* Mapping Constructor<br> e.g. `{𝓪 : 1, 𝓫 : true}` <br> <small>Here 𝓪 and 𝓫 are filed names.</small>
* Lang Library : [*ballerina/lang.map*]({{< linkh "#" >}})
* Iterable 🔁
{{</md>}}
<!--more-->
<hr>
