---
title : Error Type
description : About error types
author: Hasitha
date: 2023-01-01
weight : 5150
btype : [error]
blang : [type]
bmodule : []
highlight : []
draft : true
---
{{<md class="summary">}}
Errors values allow developers to communicate information about errors that have occurred in a program. Error values live separately from other values, which allows language constructs to handle errors differently.
{{</md>}}
{{<md class="syntax">}}

* Error type with detail mapping 𝓣<br>`error <𝓣>`
* Any Error : `error`
* Distinct Error type with detail mapping 𝓣<br> `distinct error <𝓣>`

<small>Here 𝓣 is a subtype of `map<error:Cloneable>`</small>
{{</md>}}
{{<md class="tldr">}}

* Error Constructor<br> e.g. `error ("error message")`
* Error values are immutable.
* Lang Library : [*ballerina/lang.error*]({{< linkh "#" >}})
{{</md>}}
<!--more-->

🚧 More Details Coming Soon!

### Constructing Error Values

Error values can be constructed using the `error` constructor as follows: here 𝓔 is an error value, Here 𝓪 and 𝓫 are error detail names. 𝓣 is an error type.

* Error with message : <br> `error ("error message")`
* Error with message and cause : <br> `error ("error message", 𝓔)`
* Error with message and details : <br> `error ("error message", 𝓪 = 10 , 𝓫 = true )`
* Error with message and details : <br> `error ("error message", 𝓔, 𝓪 = 10 , 𝓫 = true )`
* Error with Type 𝓣 and message (cause and details as above) : <br> `error 𝓣 ("error message")`
