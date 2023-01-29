---
title : Object Type
description : About object types
author: Hasitha
date: 2023-01-01
weight : 5070
btype : [object]
blang : [type]
bmodule : []
highlight : []
draft : true
---
{{<md class="summary">}}
An Object value encapsulates data and functions that operate on data. They are composed of named members which are either a field or a method. In Ballerina, network primitives such as client, service, and listeners are built using object types. Client and service objects are two specific kinds of objects that are used for network communication. Additionally language defines a set of built-in object types (i.e. Listener, Iterator, etc.) that are used for various language constructs.
{{</md>}}
{{<md class="syntax">}}
{{</md>}}
{{<md class="syntax">}}

* Object with a Field 𝓪<br> `object { 𝓣 𝓪; }`
* Object with a Method 𝔁<br> `object { function 𝔁 (𝓣 a, 𝓢 𝓫) returns 𝓡; }`
* Object Inclusion : `object { *𝓞; }`
* Any Object : `object { }`
* Client Object : `client object { }`
* Service Object : `service object { }`
* Remote and Resource methods

<small>Here 𝓣, 𝓢 and 𝓡 are types, 𝓞 is an object type, 𝔁, 𝓪 and 𝓫 are identifiers.</small>
{{</md>}}
{{<md class="tldr">}}

* Object Constructor
* Lang Library : `ballerina/lang.object`
{{</md>}}
<!--more-->

🚧 More Details Coming Soon!
