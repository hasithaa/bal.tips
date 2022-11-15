---
title : "Ballerina Syntax Guide"
date : 2022-07-01T22:17:58+05:30
kind : collection 
tags : []
tips : []
weight : 50
---

Let's see various Ballerina syntaxes.

## **Basics**

<div class="rowList">
{{<md tag="span" class="column3List" link="#">}}`identifier` &nbsp; `'key`{{</md>}}
{{<md tag="span" class="column3List" link="#">}}`// A comment`{{</md>}}
</div>

## **Types** 

<div class="rowList">
{{<md tag="span" class="column2List" link="#types">}}`()` &nbsp; `boolean` &nbsp; `int` &nbsp; `float` &nbsp; `decimal`{{</md>}}
{{<md tag="span" class="column2List" link="#types">}}`string` &nbsp; `xml`{{</md>}}
{{<md tag="span" class="column2List" link="#types">}}`T[]` &nbsp; `[T, R...]`{{</md>}}
{{<md tag="span" class="column2List" link="#types">}}`map<T>` &nbsp; `record{ T a; R b; }` &nbsp; `record{| T a; R...; |}`{{</md>}}
{{<md tag="span" class="column2List" link="#types">}}`table <T>` &nbsp; `table <T> key (a, b)`{{</md>}}
{{<md tag="span" class="column2List" link="#types">}}`error <T>`{{</md>}}
{{<md tag="span" class="column2List" link="#types">}}`function` &nbsp; `function (T a) returns R`{{</md>}}
{{<md tag="span" class="column2List" link="#types">}}`object { }` &nbsp; `object { T a; function b (R c) returns S; }`{{</md>}}
{{<md tag="span" class="column2List" link="#types">}}`future` &nbsp; `future <T>`{{</md>}}
{{<md tag="span" class="column2List" link="#types">}}`typedesc` &nbsp; `typedesc <T>`{{</md>}}
{{<md tag="span" class="column2List" link="#types">}}`stream <T>`{{</md>}}
{{<md tag="span" class="column2List" link="#types">}}`T` &nbsp; `m:T`{{</md>}}
{{<md tag="span" class="column2List" link="#types">}}`"Hello"` &nbsp; `123` &nbsp; `45.6` &nbsp; `true`{{</md>}}
{{<md tag="span" class="column2List" link="#types">}}`any` &nbsp; `never` &nbsp; `readonly`{{</md>}}
{{<md tag="span" class="column2List" link="#types">}}`T | R`{{</md>}}
{{<md tag="span" class="column2List" link="#types">}}`T & R`{{</md>}}
{{<md tag="span" class="column2List" link="#types">}}`T?`{{</md>}}
{{<md tag="span" class="column2List" link="#types">}}`distinct T`{{</md>}}
{{<md tag="span" class="column2List" link="#types">}}`anydata` &nbsp; `json` &nbsp; `byte`{{</md>}}
{{<md tag="span" class="column2List" link="#types">}}`handle`{{</md>}}
</div>

`a` &nbsp; `b` and `c` are identifiers,
`T` &nbsp; `R` and `S` are types,
`m` is a module prefix.

## **Expressions**

<div class="rowList">
{{<md tag="span" class="column2List" link="learn-syntax/expr/literals.md">}}`"Hello"` &nbsp; `123` &nbsp; `45.6` &nbsp; `true` &nbsp; `()`{{</md>}}
{{<md tag="span" class="column2List" link="learn-syntax/expr/template.md">}}``string `Hello` `` &nbsp; ``xml `<A>B</A>` ``{{</md>}}
{{<md tag="span" class="column2List" link="learn-syntax/expr/constructors.md">}}`[1,2,3]` &nbsp; `{a : "A", b : "B"}`{{</md>}}
{{<md tag="span" class="column2List" link="learn-syntax/expr/object-construction.md">}}`object {}` &nbsp; `new` &nbsp; `new T( ... )`{{</md>}}
{{<md tag="span" class="column2List" link="learn-syntax/expr/object-construction.md">}}`a` &nbsp; `m:a`{{</md>}}
{{<md tag="span" class="column2List" link="learn-syntax/expr/field-access.md">}}`x.a` &nbsp; `x?.a` &nbsp; `x.@a`{{</md>}}
{{<md tag="span" class="column2List" link="learn-syntax/expr/member-access.md">}}`x[a]`{{</md>}}
{{<md tag="span" class="column2List" link="learn-syntax/expr/function-call.md">}}`a()`{{</md>}}
{{<md tag="span" class="column2List" link="learn-syntax/expr/method-call.md">}}`x.a()`{{</md>}}
{{<md tag="span" class="column2List" link="#expressions">}}`error ()`{{</md>}}
{{<md tag="span" class="column2List" link="#expressions">}}`function (string a) returns int { return x; }` &nbsp; `() => x`{{</md>}}
{{<md tag="span" class="column2List" link="#expressions">}}`let int a = 10 in a + x`{{</md>}}
{{<md tag="span" class="column2List" link="#expressions">}}`<T> x`{{</md>}}
{{<md tag="span" class="column2List" link="#expressions">}}`typeof x`{{</md>}}
{{<md tag="span" class="column2List" link="#expressions">}}`+ x` &nbsp; `- x` &nbsp; `~ x` &nbsp; `! x`{{</md>}}
{{<md tag="span" class="column2List" link="#expressions">}}`x * y` &nbsp; `x / y` &nbsp; `x % y`{{</md>}}
{{<md tag="span" class="column2List" link="#expressions">}}`x + y` &nbsp; `x - y`{{</md>}}
{{<md tag="span" class="column2List" link="#expressions">}}`x << y` &nbsp; `x >> y` &nbsp; `x >>> y`{{</md>}}
{{<md tag="span" class="column2List" link="#expressions">}}`x ... y` &nbsp; `x ..< y`{{</md>}}
{{<md tag="span" class="column2List" link="#expressions">}}`x < y` &nbsp; `x > y` &nbsp; `x <= y` &nbsp; `x >= y`{{</md>}}
{{<md tag="span" class="column2List" link="#expressions">}}`x is T` &nbsp; `x !is T`{{</md>}}
{{<md tag="span" class="column2List" link="#expressions">}}`x == y` &nbsp; `x != y` &nbsp; `x === y` &nbsp; `x !== y`{{</md>}}
{{<md tag="span" class="column2List" link="#expressions">}}`x & y` &nbsp; `x ^ y` &nbsp; `x | y`{{</md>}}
{{<md tag="span" class="column2List" link="#expressions">}}`x | y` &nbsp; `x && y` &nbsp; `x || y`{{</md>}}
{{<md tag="span" class="column2List" link="#expressions">}}`x ? y : z` &nbsp; `x ?: y`{{</md>}}
{{<md tag="span" class="column2List" link="#expressions">}}`check x` &nbsp; `checkpanic x`{{</md>}}
{{<md tag="span" class="column2List" link="#expressions">}}`trap x`{{</md>}}
{{<md tag="span" class="column2List" link="#expressions">}}`from var a in x select y`{{</md>}}
{{<md tag="span" class="column2List" link="#expressions">}}`x.<*>`{{</md>}}
{{<md tag="span" class="column2List" link="#expressions">}}`transactional`{{</md>}}
</div>

`a` and `b` are identifiers,
`T` is a type,
`x` &nbsp; `y` and `z` are expressions,
`m` is a module prefix.
[Read more >>]({{<relref "learn-syntax/expr/_index.md" >}})

## **Actions**

<div class="rowList">
{{<md tag="span" class="column2List" link="#actions">}}`x->a()`{{</md>}}
{{<md tag="span" class="column2List" link="#actions">}}`x->/a/b` &nbsp; `x->/a/b.c()` &nbsp; `x->/a/[y]/b()`{{</md>}}
{{<md tag="span" class="column2List" link="#actions">}}`start a()`{{</md>}}
{{<md tag="span" class="column2List" link="#actions">}}`wait x` &nbsp; `wait { a : x, b : y}`  &nbsp; `wait x|y`{{</md>}}
{{<md tag="span" class="column2List" link="#actions">}}`x ->> w` &nbsp; `x -> w` &nbsp; `x ->> function` &nbsp; `x -> function`{{</md>}}
{{<md tag="span" class="column2List" link="#actions">}}`<- w` &nbsp; `<- function` &nbsp; `<- {w, v}` &nbsp; `<- {a : w, b : v}`{{</md>}}
{{<md tag="span" class="column2List" link="#actions">}}`flush w`{{</md>}}
{{<md tag="span" class="column2List" link="#actions">}}`from var a in x do { stmt } `{{</md>}}
</div>

`a` &nbsp; `b` and `c` are identifiers,
`w` and `v` are worker name identifiers,
`x` and `y` are expressions,
`stmt` is zero or more statements.

## **Statements**

<div class="rowList">
{{<md tag="span" class="column2List" link="#statements">}}`T a = x;` &nbsp; `T a;`{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}`ex;`{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}`a();` &nbsp; `x.a();`{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}`x = ex;` &nbsp; `x.a = ex;` &nbsp; `x[y] = ex;`{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}`x += ex;` &nbsp; `x -= ex;` &nbsp; `x *= ex;` ...{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}`_ = ex;` &nbsp; `[a, b] = ex;` &nbsp; `{ a, b } = ex;` ...{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}`check ex;` &nbsp; `checkpanic ex;`{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}`trap ex;`{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}
```
if x {
  stmt
} else if y {
  stmt
} else {
  stmt
}
```
{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}
```
match ex {
  "Hello" => { stmt}
  var [a,b, ...c] => { stmt}
  var {a, b, ...c} => { stmt}
  [var a, var b, ... var c] => { stmt}
  {a : var b, ... var c} => { stmt}
  var a => { stmt}
  _ => { stmt}
}
```
{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}
```
foreach T a in ex {
  stmt
}
```
{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}
```
while x {
  stmt
}
```
{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}`continue;`{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}`break;`{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}
```
do {
  stmt
}
```
{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}
```
lock {
  stmt
}
```
{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}
```
do {
  stmt
} on fail T a {
  stmt
}
```
{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}
```
retry <T> (R a, S b) {
  stmt
}
```
{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}
```
transaction {
  stmt
}
```
{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}
```
retry <T> (R a, S b) transaction {
  stmt
}
```
{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}`fail x;`{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}`commit;`{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}`rollback x;`{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}`panic x;`{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}`return ex;`{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}`xmlns "www.example.com" as a`{{</md>}}
{{<md tag="span" class="column2List" link="#statements">}}
```
fork {
  worker w {
    stmt
  }
  worker v {
    stmt
  }
}
```
{{</md>}}
</div>

`a` &nbsp; `b` and `c` are identifiers,
`w` and `v` are worker name identifiers,
`T` &nbsp; `R` and `S` are types,
`x`, `y` and `z` are expressions,
`ex` is an action or expression,
`stmt` is zero or more statements.

## **Functions**

<div class="rowList">
{{<md tag="span" class="column2List" link="#functions">}}
```
function name (T a, R b) returns S {
  stmt
}
```
{{</md>}}
{{<md tag="span" class="column2List" link="#functions">}}
```
public isolated function name (T a, R b) returns S {
  stmt
}
```
{{</md>}}
{{<md tag="span" class="column2List" link="#functions">}}
```
function a (T a, R b) returns S => expr
```
{{</md>}}
{{<md tag="span" class="column2List" link="#functions">}}
```
function a (T a, R b) returns S => external
```
{{</md>}}
{{<md tag="span" class="column2List" link="#functions">}}
```
function a () {
  stmt
  worker b returns T {
    stmt
  }
  stmt
}
```
{{</md>}}
</div>

`a` &nbsp; `b` and `name` are identifiers,
`T` &nbsp; `R` and `S` are types,
`expr` is an expression.
`stmt` is zero or more statements,


## **Module level declarations**

<div class="rowList">
{{<md tag="span" class="column2List" link="#module-level-declarations">}}`import org/name;` &nbsp; `import org/name as a;` &nbsp; `import org/name as _;`{{</md>}}
{{<md tag="span" class="column2List" link="#module-level-declarations">}}`listener T a = expr`{{</md>}}
{{<md tag="span" class="column2List" link="#module-level-declarations">}}`T a = expr`{{</md>}}
{{<md tag="span" class="column2List" link="#module-level-declarations">}}`configurable T a = expr` &nbsp; `configurable T a = ?`{{</md>}}
{{<md tag="span" class="column2List" link="#module-level-declarations">}}`const a = expr`{{</md>}}
{{<md tag="span" class="column2List" link="#module-level-declarations">}}`type a T;`{{</md>}}
{{<md tag="span" class="column2List" link="#module-level-declarations">}}
```
service /a/b on expr {
}
```
{{</md>}}
{{<md tag="span" class="column2List" link="#module-level-declarations">}}
```
class name {
}
```
{{</md>}}
{{<md tag="span" class="column2List" link="#module-level-declarations">}}
```
enum name {
  a,
  b
}
```
{{</md>}}
{{<md tag="span" class="column2List" link="#module-level-declarations">}}`xmlns "www.example.com" as a`{{</md>}}
</div>

`a` &nbsp; `b` &nbsp; `org` and `name` are identifiers,
`T` &nbsp; `R` and `S` are types,
`expr` is an expression.
