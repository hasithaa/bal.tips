---
title : "`length`"
description : Returns the number of members of an array.
example : "`[🔵,🟡,🟢,🔴].length()` ➜ `4`"
date: 2023-02-01
weight : 110505
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : [length.bal]
---

# `length`

{{< example >}}

{{< spec title="length documentation" >}}

```ballerina
# Returns the number of members of an array.
#
# + arr - the array
# + return - number of members in `arr`
public isolated function length((any|error)[] arr) returns int = external;
```

{{< /spec >}}

## Examples

{{< code id="0" title="`array:length()` Usage" />}}
