---
title : How to Use Comments
description : Comments are used to provide more details about the code or temporally disable a section of the source code. <br> A comment starts with two forward slashes `//`. The compiler ignores any characters between `//` and the end of the line. 
keywords: [comments, add more details to code, temporary disable code, markdown syntax for documentation]
images : [/docs/syntax/comments/comment.png]
date: 2023-01-01
weight : 4010
ballerina_lang : [comment]
highlight : [comment01.bal]
menu: 
  main:
    parent: syntax
    name: 'Comments'
    params:
      group: "basic"
---

# Comments

Comments are used to provide more details about the code or temporally disable a section of the source code.

{{<cards>}}

{{< card header="✍ Syntax" col=3 >}}

#### `//`

A comment starts with two forward slashes `//`. The compiler ignores any characters between `//` and the end of the line. Ballerina supports only single-line comments.


{{</card>}}
{{< card header="Highlights" col=5 >}}

<i class="bi bi-info-lg text-primary"></i> Multiline comments are not supported. <br>
<i class="bi bi-check2 text-success"></i> This is solely for comments. For documentation and annotation, different syntax is required.<br>
<i class="bi bi-x-lg text-danger"></i> Refrain from documenting within comments; utilize Markdown syntax instead.<br>
<i class="bi bi-check2 text-success"></i> As much as possible, avoid comments. Prefer using clear, concise code.<br>
{{</ card >}}

{{</cards>}}


## Example

```ballerina {filename="comments.bal" result="output" lines="1 4 6 8 11" codeview=false}
// Hello world Ballerina Program.
import ballerina/io;

// My Main function.
public function main() {
    io:println("Hello World...!!!"); // printing hello world.

    // io:println("No execution."); //$
}

// End of this example.

```

Code Explained

* Line 1: <i class="bi bi-info-circle text-primary"></i> This is a comment. It provides more details about the code. 
* Line 4: <i class="bi bi-exclamation-square text-warning"></i> This is another comment, but **do not** use comments to document functions; Instead, use markdown documentation syntax.
* Line 6: <i class="bi bi-exclamation-square text-warning"></i> This is an inline comment, but the code is self-explanatory. Avoid such comments.
* Line 8: <i class="bi bi-check-circle text-success"></i> This is commented out code. It is used to temporarily disable a section of the source code.
* Line 11: <i class="bi bi-exclamation-square text-warning"></i> This comment is unnecessary and should be avoided in favor of clear, concise code.


## No Multiline Comments

Multi-line comments are useful when providing large text descriptions or commenting on multiple lines of the code. Many languages use `/*  */` syntax for multiline comments. **Ballerina does not support this syntax**. Instead, you can use multiple `//` comments for the same purpose.

IDEs such as **VSCode** provide better support when commenting out multi-line code blocks. Select lines you want to comment on, then press `Ctrl` + `/` key.

## Comments, Docs, and Metadata

It is common to keep documentation within the source code because it is easy to keep up-to-date documentation with the code changes. In many programming languages, Documentation is kept as comments & sometimes formatted in a particular way (e.g.: `/** */` syntax in Java).

In Ballerina, you can use markdown documentation syntax to document Ballerina constructs. Ballerina markdown documentation starts with `#`. It is a common mistake that the developer uses comments (`//`) for documentation purposes.

Some programming languages often use comments to store metadata about the program. In Ballerina, you can use `annotation` for this purpose. But usually, you don't need to define annotations, unless you are building a low-level connector or extending compiler functionalities. If you are not sure whether you need to use annotation, you probably don't need it, get help from the Ballerina Team and Community.

## Code Is Read More Than It Is Written

{{< quote source="Ron Jeffries">}}
"Code never lies, comments sometimes do."
{{</ quote >}}

Rarely, you write perfect code and run forever. Coding is an iterative process; You need to add new features, improve your code, and fix bugs. So, you must continue reading your old code to know how/where to fix it.

So, write your code in a self-documenting or understandable way. Put comments if necessary. Do not make updating comments in sync with the source code is an excessive task.


Below are the main points to remember:

![comments](/docs/syntax/comments/comment.png)
{.tip-50-frame}

* No Multiline Comments.
* Only for Comments.
* Do not document inside comments, use Markdown syntax instead.
* Avoid comments much as possible, use clear, concise code instead.
