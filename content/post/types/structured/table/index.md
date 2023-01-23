---
title : Table Type
description : About type table
author: Hasitha
date: 2023-01-01
weight : 5210
btype : [table]
blang : [type]
bmodule : [table]
highlight : []
draft : true
---
{{<md class="summary">}}
A Table type represents a tabular data structure, where members are mapping values. The table keeps members in order, but unlike list values, you cannot access members using an index. The Table syntax defines a key to access its members.
{{</md>}}
{{<md class="syntax">}}

* Table with Individual Keys <br> `table <𝓣> key (𝓪, 𝓫)`
* Table with Key Constrain 𝓢 <br> `table <𝓣> key <𝓢>`
* Keyless Table <br> `table <𝓣>` or `table <𝓣> key <never>`
* Any Table Value <br> `table`

<small>Here 𝓣 and 𝓢 are Record types. 𝓪 and 𝓫 are table keys which are required and readonly field names with subtype of `anydata` of the 𝓣.</small>
{{</md>}}
{{<md class="tldr">}}

* Table Constructor, e.g. <br>`table [{𝓪 : 1, 𝓫 : true}, {𝓪 : 2, 𝓫 : false}]` <br>  <small>Here 𝓪 and 𝓫 are filed names.</small>
* Lang Library : [*ballerina/lang.table*]({{< linkh "#" >}})
* Iterable 🔁
{{</md>}}
<!--more-->

🚧 More Details Coming Soon!
