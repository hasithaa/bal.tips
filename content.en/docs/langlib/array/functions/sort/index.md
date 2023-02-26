---
title : "`sort`"
description : Sorts an array.
example : "`[🍎, 🍇, 🍌, 🍓].sort(byName)` ➜ `[🍎, 🍌, 🍇, 🍓]`"
date: 2023-02-01
weight : 11068
type : docs
ballerina_type : [list]
ballerina_module : [array]
highlight : []
---

# `sort`

{{< example >}}

The `sort` function sorts the members of a given list. The _arr_ argument specifies the list to be sorted. The _direction_ argument specifies the direction in which to sort the list, which can be either **ASCENDING** or **DESCENDING**. The _key_ argument is an optional function that returns a key to use to sort the members.

If the member type of the list is not sortable, then the **key function** must be specified to extract a comparable key from each member.

Sorting works the same as with the sort clause of query expressions.


## Examples

{{<hint>}}🚧 More Details Coming Soon!{{</hint>}}

## Spec Definition

{{< spec title="`sort` documentation" >}}

```ballerina
# A type parameter that is a subtype of `any|error`.
# Has the special semantic that when used in a declaration
# all uses in the declaration must refer to same type.
@typeParam
type Type any|error;

# Direction for `sort` function.
public enum SortDirection {
   ASCENDING = "ascending",
   DESCENDING = "descending"
}

# A type of which any ordered type must be a subtype.
# Whether a type is an ordered type cannot be defined in
# terms of being a subtype of a type, so being a subtype
# of `OrderedType` is a necessary but not sufficient condition
# for a type to be an ordered type.
public type OrderedType ()|boolean|int|float|decimal|string|OrderedType[];

# Sorts an array.
# If the member type of the array is not sorted, then the `key` function
# must be specified.
# Sorting works the same as with the `sort` clause of query expressions.
#
# + arr - the array to be sorted; 
# + direction - direction in which to sort
# + key - function that returns a key to use to sort the members
# + return - new array consisting of the members of `arr` in sorted order
public isolated function sort(Type[] arr, SortDirection direction = ASCENDING,
        (isolated function(Type val) returns OrderedType)? key = ()) returns Type[] = external;
```

{{< /spec >}}
