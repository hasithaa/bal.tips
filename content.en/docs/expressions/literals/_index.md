---
title: "Literals"
description: A literal is a value that is specified directly in the source code.
date : 2023-01-01
weight : 6030
type : docs
bookToc: true
images: [/docs/expressions/literals/numeric-algo.png]
ballerina_lang : [literal]
highlight : [numeric-literals.bal]
bookCollapseSection : true
aliases : 
  - /learn-syntax/expr/literals/
  - /examples/expr/literals/numeric-literals/
---

# Literals

A literal is a value that is specified directly in the source code. 
<!--more-->
Ballerina supports the following literals.

{{< md class="post_table center">}}

| Literals               | Example                                          |
| ---------------------- | ------------------------------------------------ |
| Nil Literal            | `()`, `null`                                     |
| Boolean Literal        | `true` or `false`                                |
| Integer Literal        | `123`, `0x1A`                                    |
| Floating Point Literal | `456.78`, `12.3f`, `12.3d`, `1.23e3`, `0X1a.A`   |
| String Literal         | `"Hello, World!"`                                |
| Byte Array Literal     | ``base16 `AB 12 34` `` <br/>  ``base64 `A1z+` `` |

{{< /md >}}
{{< section >}}

# Inferring the Type of a Numeric Literal - The Algorithm.

A value written in a numeric literal always represents a specific type, which is determined by the literal itself. The type of a literal can be one of the basic types, such as int, float, or decimal.

For example, the literal 10 represents the integer value 10, and its basic type is int. However, in some contexts, the same literal 10 can also represent a floating-point value 10.0 or a decimal value 10. Depending on the context, the compiler determines the appropriate type of the literal to be used.

{{< code id="0" title="Numeric literal type" >}}
{{< highlight >}}
📌:::7 ::: The basic type of the literal `10` is `int`.
📌:::8 ::: The basic type of the literal `10` is `float`.
📌:::9 ::: The basic type of the literal `10` is `decimal`.
📌:::11::: The basic type of the literal `10` is `int`.
📌:::12::: The basic type of the literal `10` is `float`.
📌:::14::: The basic type of the literal `10` is `int`.
📌:::15::: The basic type of the literal `10.0` is `float`.
{{</ highlight >}}
{{< /code >}}

When determining the type basic of a literal, following 3 steps [algorithm](https://ballerina.io/spec/lang/master/#numeric-literal) is used.

Let's see how this works with different examples <select id="numericAlgoSelect">
  <option value="a-00000-0000-0000000-000-0000-000-0000" select><code></code></option>
  <option value="b-11111-0001-1111111-110-0100-100-1000"><code>int a1 = 10;</code></option>
  <option value="c-11111-0001-1111111-111-0010-010-0100"><code>float a2 = 10;</code></option>
  <option value="d-11111-0001-1111111-111-0001-001-0010"><code>decimal a3 = 10;</code></option>
  <option value="e-11000-1000-1111111-111-0010-010-0100"><code>float f1 = 10.12f;</code></option>
  <option value="f-11100-1000-1111111-111-0010-010-0100"><code>float f2 = 0x1b.a2;</code></option>
  <option value="g-11110-0100-1111111-111-0001-001-0010"><code>decimal d1 = 10d;</code></option>
  <option value="h-11111-0001-1111111-110-0100-100-1000"><code>TEN a4 = 10;</code></option>
  <option value="i-11111-0001-1111111-111-0010-011-0110"><code>float|decimal a5 = 10;</code></option>
  <option value="j-11000-1000-1111111-111-0010-010-0110"><code>float|decimal a6 = 10.12f;</code></option>
  <option value="k-11111-0001-1111111-110-0100-111-0001"><code>var a7 = 10;</code></option>
  <option value="l-11111-0010-1111111-111-0010-011-0001"><code>var a8 = 10.0;</code></option>
  <option value="m-11110-0100-1111001-100-1000-000-0100"><code>float e1 = 10.0d; //Error</code></option>
  <option value="n-11111-0010-1111001-100-1000-000-1000"><code>int e1 = 10.0; //Error</code></option>
</select>.
Please note that, after deciding the basic type of the literal, precise type of a literal is applied by the type checking algorithm.

<figure style="max-width=100%;"><?xml version="1.0" encoding="UTF-8"?>
<svg width="100%" version="1.1" viewBox="0 0 207.4 262.96" xmlns="http://www.w3.org/2000/svg">
 <g transform="translate(-1.7576 -2.1356)">
  <rect x="1.8874" y="2.2654" width="207.14" height="262.7" rx="1.5372" ry="1.3435" fill="#fff" stop-color="#000000" stroke="#fff" stroke-width=".25966" style="paint-order:stroke fill markers"/>
  <path id="algo_22" d="m126.98 252.89a5.0196 3.4018 0 0 0-5.0197 3.4019 5.0196 3.4018 0 0 0 5.0197 3.4019 5.0196 3.4018 0 0 0 0.34162-8e-3c0.12223 0.012 0.24625 0.0196 0.3744 0.0196h6.9672c0.11536 0 0.22786-7e-3 0.33855-0.0165a5.0196 3.4018 0 0 0 0.26002 5e-3 5.0196 3.4018 0 0 0 5.0197-3.4019 5.0196 3.4018 0 0 0-5.0197-3.4019 5.0196 3.4018 0 0 0-0.35685 9e-3c-0.0795-5e-3 -0.15999-8e-3 -0.24172-8e-3h-6.9672c-0.0976 0-0.19241 5e-3 -0.28672 0.0119a5.0196 3.4018 0 0 0-0.4293-0.0124z" fill="#87deaa" stop-color="#000000" style="paint-order:stroke fill markers"/>
  <path id="algo_23" d="m160.99 252.94a5.0196 3.4018 0 0 0-5.0197 3.4019 5.0196 3.4018 0 0 0 5.0197 3.4019 5.0196 3.4018 0 0 0 0.34162-8e-3c0.12223 0.012 0.24625 0.0196 0.3744 0.0196h6.9672c0.11536 0 0.22786-7e-3 0.33855-0.0165a5.0196 3.4018 0 0 0 0.26002 5e-3 5.0196 3.4018 0 0 0 5.0197-3.4019 5.0196 3.4018 0 0 0-5.0197-3.4019 5.0196 3.4018 0 0 0-0.35685 9e-3c-0.0795-5e-3 -0.15999-8e-3 -0.24172-8e-3h-6.9672c-0.0976 0-0.19241 5e-3 -0.28672 0.0119a5.0196 3.4018 0 0 0-0.4293-0.0124z" fill="#87deaa" stop-color="#000000" style="paint-order:stroke fill markers"/>
  <rect transform="matrix(1 0 -.44952 .89327 0 0)" x="93.373" y="55.413" width="135.03" height="26.728" rx=".85231" ry=".039647" fill="#ececec" stop-color="#000000" style="paint-order:stroke fill markers"/>
  <g fill="#ccc">
   <rect id="algo_7" transform="matrix(1 0 -.25882 .96593 0 0)" x="119.51" y="54.734" width="16.536" height="17.12" rx=".85231" ry=".1803" stop-color="#000000" style="paint-order:stroke fill markers"/>
   <rect id="algo_8" transform="matrix(1 0 -.25882 .96593 0 0)" x="151.26" y="54.734" width="16.536" height="17.12" rx=".85231" ry=".1803" stop-color="#000000" style="paint-order:stroke fill markers"/>
   <rect id="algo_9" transform="matrix(1 0 -.25882 .96593 0 0)" x="188.95" y="54.734" width="16.536" height="17.12" rx=".85231" ry=".1803" stop-color="#000000" style="paint-order:stroke fill markers"/>
   <rect id="algo_6" transform="matrix(1 0 -.25882 .96593 0 0)" x="86.548" y="54.734" width="16.536" height="17.12" rx=".85231" ry=".1803" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <text x="9.260417" y="10.772321" font-family="Arial" font-size="4.2333px" font-weight="bold" stroke-width=".26458" style="line-height:1.25" xml:space="preserve"><tspan x="9.260417" y="10.772321" stroke-width=".26458">Step 1 - Check Syntatic Form</tspan></text>
  <circle cx="14.552" cy="27.167" r="3.4018" fill="#87deaa" stop-color="#000000" style="paint-order:stroke fill markers"/>
  <g transform="translate(-4.3987 -4.0869)">
   <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
   <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <rect id="algo_1" x="26.365" y="18.899" width="16.536" height="16.536" rx=".85231" ry=".19085" fill="#ccc" stop-color="#000000" style="paint-order:stroke fill markers"/>
  <text x="34.485897" y="26.037394" font-family="Arial" font-size="4.2333px" stroke-width=".26458" text-anchor="middle" style="line-height:1.25" xml:space="preserve"><tspan x="34.485897" y="26.037394" text-align="center">Check</tspan><tspan x="34.485897" y="31.329056" text-align="center">Literal</tspan></text>
  <g transform="translate(20.735 -4.0869)">
   <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
   <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <rect id="algo_2" transform="rotate(45)" x="55.409" y="-33.525" width="16.536" height="16.536" rx=".85231" ry=".19085" fill="#ccc" stop-color="#000000" style="paint-order:stroke fill markers"/>
  <text x="62.567013" y="20.690186" font-size="4.2333px" stroke-width=".26458" text-anchor="middle" style="line-height:1.25" xml:space="preserve"><tspan x="62.567013" y="20.690186" font-family="Arial" text-align="center">Ends</tspan><tspan x="62.567013" y="25.981848" font-family="Arial" text-align="center">with</tspan><tspan x="62.567013" y="31.27351" fill="#0000ff" font-family="'Source Code Pro'" font-style="italic" text-align="center">f/F</tspan><tspan x="62.567013" y="36.674198" font-family="Arial" text-align="center">?</tspan></text>
  <rect id="algo_3" transform="rotate(45)" x="78.75" y="-56.867" width="16.536" height="16.536" rx=".85231" ry=".19085" fill="#ccc" stop-color="#000000" style="paint-order:stroke fill markers"/>
  <text x="95.768089" y="20.719894" font-family="Arial" font-size="4.2333px" stroke-width=".26458" text-anchor="middle" style="line-height:1.25" xml:space="preserve"><tspan x="95.768089" y="20.719894" text-align="center">Floating</tspan><tspan x="95.768089" y="26.011557" text-align="center">Point</tspan><tspan x="95.768089" y="31.303219" text-align="center">HEX</tspan><tspan x="95.768089" y="36.594879" text-align="center">Literal?</tspan></text>
  <rect id="algo_4" transform="rotate(45)" x="102.09" y="-80.208" width="16.536" height="16.536" rx=".85231" ry=".19085" fill="#ccc" stop-color="#000000" style="paint-order:stroke fill markers"/>
  <text x="128.62868" y="20.690186" font-size="4.2333px" stroke-width=".26458" text-anchor="middle" style="line-height:1.25" xml:space="preserve"><tspan x="128.62868" y="20.690186" font-family="Arial" text-align="center">Ends</tspan><tspan x="128.62868" y="25.981848" font-family="Arial" text-align="center">with</tspan><tspan x="128.62868" y="31.27351" fill="#0000ff" font-family="'Source Code Pro'" font-style="italic" text-align="center">d/D</tspan><tspan x="128.62868" y="36.674198" font-family="Arial" text-align="center">?</tspan></text>
  <rect id="algo_5" transform="rotate(45)" x="125.43" y="-103.55" width="16.536" height="16.536" rx=".85231" ry=".19085" fill="#ccc" stop-color="#000000" style="paint-order:stroke fill markers"/>
  <text x="161.59677" y="23.365725" font-family="Arial" font-size="4.2333px" stroke-width=".26458" text-anchor="middle" style="line-height:1.25" xml:space="preserve"><tspan x="161.59677" y="23.365725" text-align="center">Floating</tspan><tspan x="161.59677" y="28.657387" text-align="center">Point</tspan><tspan x="161.59677" y="33.949051" text-align="center">Literal?</tspan></text>
  <g transform="matrix(1.4009 0 0 1 41.815 -4.0869)">
   <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
   <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <g transform="matrix(1.4009 0 0 1 74.543 -4.0869)">
   <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
   <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <g transform="matrix(1.4009 0 0 1 107.55 -4.0869)">
   <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
   <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <g font-family="Arial" font-size="3.5278px" font-weight="bold" stroke-width=".26458">
   <text x="75.702164" y="43.920826" style="line-height:1.25" xml:space="preserve"><tspan x="75.702164" y="43.920826" font-family="Arial" font-size="3.5278px" font-style="italic" font-weight="normal" stroke-width=".26458">Yes</tspan></text>
   <text x="76.540184" y="26.64732" style="line-height:1.25" xml:space="preserve"><tspan x="76.540184" y="26.64732" font-family="Arial" font-size="3.5278px" font-style="italic" font-weight="normal" stroke-width=".26458">No</tspan></text>
   <text x="109.5186" y="26.080355" style="line-height:1.25" xml:space="preserve"><tspan x="109.5186" y="26.080355" font-family="Arial" font-size="3.5278px" font-style="italic" font-weight="normal" stroke-width=".26458">No</tspan></text>
   <text x="142.49702" y="26.080355" style="line-height:1.25" xml:space="preserve"><tspan x="142.49702" y="26.080355" font-family="Arial" font-size="3.5278px" font-style="italic" font-weight="normal" stroke-width=".26458">No</tspan></text>
   <text x="108.68058" y="43.920826" style="line-height:1.25" xml:space="preserve"><tspan x="108.68058" y="43.920826" font-family="Arial" font-size="3.5278px" font-style="italic" font-weight="normal" stroke-width=".26458">Yes</tspan></text>
   <text x="141.65901" y="43.920826" style="line-height:1.25" xml:space="preserve"><tspan x="141.65901" y="43.920826" font-family="Arial" font-size="3.5278px" font-style="italic" font-weight="normal" stroke-width=".26458">Yes</tspan></text>
   <text x="177.91335" y="43.920826" style="line-height:1.25" xml:space="preserve"><tspan x="177.91335" y="43.920826" font-family="Arial" font-size="3.5278px" font-style="italic" font-weight="normal" stroke-width=".26458">No</tspan></text>
  </g>
  <g fill="#0000ff" font-size="4.2333px" stroke-width=".26458">
   <text x="78.331131" y="62.644714" font-family="Arial" font-weight="bold" style="line-height:1.25" xml:space="preserve"><tspan x="78.331131" y="62.644714" fill="#0000ff" font-family="'Source Code Pro'" font-weight="normal" stroke-width=".26458" text-align="center" text-anchor="middle">float</tspan></text>
   <text x="111.40405" y="62.627781" font-family="Arial" font-weight="bold" style="line-height:1.25" xml:space="preserve"><tspan x="111.40405" y="62.627781" fill="#0000ff" font-family="'Source Code Pro'" font-weight="normal" stroke-width=".26458" text-align="center" text-anchor="middle">decimal</tspan></text>
   <text x="143.15405" y="59.944366" font-family="'Source Code Pro'" text-anchor="middle" style="line-height:1.25" xml:space="preserve"><tspan x="143.15405" y="59.944366" text-align="center">float,</tspan><tspan x="143.15405" y="65.345055" text-align="center">decimal</tspan></text>
   <text x="180.83823" y="51.826401" font-family="'Source Code Pro'" text-anchor="middle" style="line-height:1.25" xml:space="preserve"><tspan x="180.83823" y="51.826401" text-align="center"/><tspan x="180.83823" y="57.227089" text-align="center">int,</tspan><tspan x="180.83823" y="62.627781" text-align="center">float,</tspan><tspan x="180.83823" y="68.028465" text-align="center">decimal</tspan></text>
  </g>
  <g transform="matrix(0 1.5304 -1 0 174.24 38.059)">
   <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
   <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <g transform="rotate(90 60.489 82.596)">
   <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
   <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <g transform="rotate(90 76.979 99.085)">
   <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
   <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <g transform="rotate(90 94.687 116.79)">
   <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
   <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <g fill="none" stroke="#000" stroke-width=".26458px">
   <path d="m62.886 38.86c15.967 6.6334 15.967 6.6334 15.967 6.6334"/>
   <path d="m95.896 38.86-17.043 6.6334"/>
   <path d="m128.91 38.86-17.074 6.6334"/>
   <path d="m144.81 45.494c17.106-6.6334 17.106-6.6334 17.106-6.6334l18.31 6.6334"/>
  </g>
  <text x="38.565525" y="62.456554" font-family="Arial" font-size="4.2333px" font-weight="bold" stroke-width=".26458" style="line-height:1.25" xml:space="preserve"><tspan x="38.565525" y="62.456554" font-family="Arial" font-weight="normal" stroke-width=".26458" text-align="center" text-anchor="middle">Possible Candidates</tspan></text>
  <rect id="algo_11" transform="rotate(45)" x="160.98" y="-41.232" width="16.536" height="16.536" rx=".85231" ry=".19085" fill="#ccc" stop-color="#000000" style="paint-order:stroke fill markers"/>
  <text x="142.91347" y="95.209137" font-size="4.2333px" stroke-width=".26458" text-anchor="middle" style="line-height:1.25" xml:space="preserve"><tspan x="142.91347" y="95.209137" font-family="Arial" text-align="center">Loop</tspan><tspan x="142.91347" y="100.5008" font-family="'Source Code Pro'" font-style="italic" text-align="center">N</tspan></text>
  <text x="9.260417" y="80.886902" font-family="Arial" font-size="4.2333px" font-weight="bold" stroke-width=".26458" style="line-height:1.25" xml:space="preserve"><tspan x="9.260417" y="80.886902" stroke-width=".26458">Step 2 - Check with Contextual Type</tspan></text>
  <rect id="algo_10" x="25.787" y="88.097" width="35.057" height="16.536" rx=".85231" ry=".19085" fill="#ccc" stop-color="#000000" style="paint-order:stroke fill markers"/>
  <text x="43.298428" y="95.260818" font-size="4.2333px" stroke-width=".26458" text-anchor="middle" style="line-height:1.25" xml:space="preserve"><tspan x="43.298428" y="95.260818" font-family="Arial" text-align="center">Contextual Type</tspan><tspan x="43.298428" y="100.55248" fill="#0000ff" font-family="'Source Code Pro'" font-style="italic" text-align="center">T</tspan></text>
  <rect id="algo_12" x="78.591" y="88.097" width="35.057" height="16.536" rx=".85231" ry=".19085" fill="#ccc" stop-color="#000000" style="paint-order:stroke fill markers"/>
  <text x="96.068199" y="95.260818" font-size="4.2333px" stroke-width=".26458" text-anchor="middle" style="line-height:1.25" xml:space="preserve"><tspan x="96.068199" y="95.260818" font-family="Arial" text-align="center">Intersection</tspan><tspan x="96.068199" y="100.55248" fill="#0000ff" font-family="'Source Code Pro'" font-style="italic" text-align="center">T &amp; N</tspan></text>
  <g transform="matrix(1.5304 0 0 1 -21.429 65.112)">
   <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
   <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <rect id="algo_13" transform="rotate(45)" x="150.42" y="13.424" width="16.536" height="16.536" rx=".85231" ry=".19085" fill="#ccc" stop-color="#000000" style="paint-order:stroke fill markers"/>
  <text x="96.699944" y="123.61919" font-size="4.2333px" stroke-width=".26458" text-anchor="middle" style="line-height:1.25" xml:space="preserve"><tspan x="96.699944" y="123.61919" fill="#0000ff" font-family="'Source Code Pro'" font-style="italic" text-align="center">T &amp; N</tspan><tspan x="96.699944" y="129.01988" font-family="Arial" text-align="center">Empty</tspan><tspan x="96.699944" y="134.31154" font-family="Arial" text-align="center">?</tspan></text>
  <g transform="matrix(0 1.5304 -1 0 128.13 69.245)">
   <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
   <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <rect id="algo_14" x="26.743" y="119.28" width="35.057" height="16.536" rx=".85231" ry=".19085" fill="#ccc" stop-color="#000000" style="paint-order:stroke fill markers"/>
  <g font-family="Arial" font-size="4.2333px">
   <text x="44.247814" y="126.39491" fill="#000000" stroke-width=".26458" text-anchor="middle" style="line-height:1.25" xml:space="preserve"><tspan x="44.247814" y="126.39491" text-align="center">Add</tspan><tspan x="44.247814" y="131.68657" text-align="center">Candidate</tspan></text>
   <text font-weight="bold" style="line-height:1.25;shape-inside:url(#rect1853);white-space:pre" xml:space="preserve"/>
   <text font-weight="bold" style="line-height:1.25;shape-inside:url(#rect1861);white-space:pre" xml:space="preserve"/>
  </g>
  <g transform="matrix(-1 0 0 1 206.51 -61.991)">
   <g transform="matrix(1.5304 0 0 1 46.694 127.1)">
    <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
    <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
   </g>
   <path d="m75.217 158.37 7.2686-0.0155" fill="none" stroke="#000" stroke-width=".26458px"/>
  </g>
  <g transform="matrix(0 1.5304 -1 0 128.13 103.45)">
   <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
   <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <rect id="algo_16" transform="rotate(45)" x="174.61" y="37.612" width="16.536" height="16.536" rx=".85231" ry=".19085" fill="#ccc" stop-color="#000000" style="paint-order:stroke fill markers"/>
  <g font-family="Arial" stroke-width=".26458">
   <text x="97.300362" y="157.9821" font-size="4.2333px" text-anchor="middle" style="line-height:1.25" xml:space="preserve"><tspan x="97.300362" y="157.9821" text-align="center">Has </tspan><tspan x="97.300362" y="163.27376" text-align="center">Next </tspan><tspan x="97.300362" y="168.56543" text-align="center">?</tspan></text>
   <g font-size="3.5278px" font-weight="bold">
    <text x="110.13182" y="160.13901" style="line-height:1.25" xml:space="preserve"><tspan x="110.13182" y="160.13901" font-family="Arial" font-size="3.5278px" font-style="italic" font-weight="normal" stroke-width=".26458">Yes</tspan></text>
    <text x="98.853195" y="145.89697" style="line-height:1.25" xml:space="preserve"><tspan x="98.853195" y="145.89697" font-family="Arial" font-size="3.5278px" font-style="italic" font-weight="normal" stroke-width=".26458">Yes</tspan></text>
    <text x="71.016808" y="125.67709" style="line-height:1.25" xml:space="preserve"><tspan x="71.016808" y="125.67709" font-family="Arial" font-size="3.5278px" font-style="italic" font-weight="normal" stroke-width=".26458">No</tspan></text>
   </g>
  </g>
  <circle cx="13.728" cy="96.366" r="3.4018" fill="#87deaa" stop-color="#000000" style="paint-order:stroke fill markers"/>
  <rect id="algo_15" transform="matrix(1 0 -.29356 .95594 0 0)" x="77.32" y="160.56" width="35.057" height="17.299" rx=".85231" ry=".17796" fill="#ccc" stop-color="#000000" style="paint-order:stroke fill markers"/>
  <text x="45.150833" y="160.6021" fill="#000000" font-family="Arial" font-size="4.2333px" stroke-width=".26458" text-anchor="middle" style="line-height:1.25" xml:space="preserve"><tspan x="45.150833" y="160.6021" text-align="center">Updated</tspan><tspan x="45.150833" y="165.89375" text-align="center">Candidates</tspan></text>
  <g transform="translate(-12.851 -30.616)" stroke="#000">
   <g transform="matrix(0 1.5304 -1 0 88.99 136.14)">
    <path d="m23.387 31.254h5.8114" stroke-width=".26458px"/>
    <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" stroke-width=".15708" style="paint-order:stroke fill markers"/>
   </g>
   <path d="m57.736 166.59v5.3366" stroke-width=".26458px"/>
  </g>
  <g transform="translate(-14.422 -61.991)">
   <g transform="matrix(1.5304 0 0 1 46.694 127.1)">
    <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
    <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
   </g>
   <path d="m75.217 158.37 7.2686-0.0155" fill="none" stroke="#000" stroke-width=".26458px"/>
  </g>
  <g transform="matrix(-1 0 0 1 154.78 -30.805)">
   <g transform="matrix(1.5304 0 0 1 46.694 127.1)">
    <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
    <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
   </g>
   <path d="m75.217 158.37 7.2686-0.0155" fill="none" stroke="#000" stroke-width=".26458px"/>
  </g>
  <path d="m79.568 127.57 5.613-0.0155" fill="none" stroke="#000" stroke-width=".26458px"/>
  <g transform="matrix(0 -1.5304 -1 0 174.24 154.67)">
   <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
   <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <path d="m108.57 161.76h34.423l-5e-3 -42.879" fill="none" stroke="#000" stroke-width=".26458px"/>
  <g transform="matrix(-.95216 0 0 1 143.72 34.207)">
   <g transform="matrix(-1 0 0 1 154.78 -30.805)">
    <g transform="matrix(1.5304 0 0 1 46.694 127.1)">
     <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
     <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
    </g>
    <path d="m75.217 158.37 7.2686-0.0155" fill="none" stroke="#000" stroke-width=".26458px"/>
   </g>
   <path d="m79.568 127.57 5.613-0.0155" fill="none" stroke="#000" stroke-width=".26458px"/>
  </g>
  <text x="99.931984" y="179.3497" font-family="Arial" font-size="3.5278px" font-weight="bold" stroke-width=".26458" style="line-height:1.25" xml:space="preserve"><tspan x="99.931984" y="179.3497" font-family="Arial" font-size="3.5278px" font-style="italic" font-weight="normal" stroke-width=".26458">No</tspan></text>
  <g transform="matrix(0 1.5304 -1 0 128.13 137.66)">
   <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
   <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <rect id="algo_17" transform="rotate(45)" x="198.8" y="61.801" width="16.536" height="16.536" rx=".85231" ry=".19085" fill="#ccc" stop-color="#000000" style="paint-order:stroke fill markers"/>
  <text x="96.724686" y="194.83511" font-family="Arial" font-size="4.2333px" stroke-width=".26458" text-anchor="middle" style="line-height:1.25" xml:space="preserve"><tspan x="96.724686" y="194.83511" text-align="center">Empty</tspan><tspan x="96.724686" y="200.12677" text-align="center">?</tspan></text>
  <rect id="algo_18" transform="rotate(45)" x="222.99" y="85.989" width="16.536" height="16.536" rx=".85231" ry=".19085" fill="#ccc" stop-color="#000000" style="paint-order:stroke fill markers"/>
  <text x="97.300369" y="226.34196" font-family="Arial" font-size="4.2333px" stroke-width=".26458" text-anchor="middle" style="line-height:1.25" xml:space="preserve"><tspan x="97.300369" y="226.34196" text-align="center">Has </tspan><tspan x="97.300369" y="231.63362" text-align="center"><tspan fill="#0000ff" font-family="'Source Code Pro'">int</tspan> </tspan><tspan x="97.300369" y="237.03432" text-align="center">?</tspan></text>
  <text x="9.260417" y="196.08006" font-family="Arial" font-size="4.2333px" font-weight="bold" stroke-width=".26458" style="line-height:1.25" xml:space="preserve"><tspan x="9.260417" y="196.08006">Step 3 : Calculate Type</tspan><tspan x="9.260417" y="201.37172"/></text>
  <path id="algo_20" d="m123.53 192.56a4.2947 3.4018 0 0 0-4.2948 3.4019 4.2947 3.4018 0 0 0 4.2948 3.4019 4.2947 3.4018 0 0 0 0.29228-8e-3c0.10458 0.012 0.21069 0.0196 0.32033 0.0196h5.961c0.0987 0 0.19495-7e-3 0.28966-0.0165a4.2947 3.4018 0 0 0 0.22247 5e-3 4.2947 3.4018 0 0 0 4.2948-3.4019 4.2947 3.4018 0 0 0-4.2948-3.4019 4.2947 3.4018 0 0 0-0.30532 9e-3c-0.068-5e-3 -0.13688-8e-3 -0.20681-8e-3h-5.961c-0.0835 0-0.16462 5e-3 -0.24531 0.0119a4.2947 3.4018 0 0 0-0.3673-0.0124z" fill="#fac" stop-color="#000000" style="paint-order:stroke fill markers"/>
  <text x="126.8797" y="197.45615" font-family="Arial" font-size="4.2333px" stroke-width=".26458" style="line-height:1.25" xml:space="preserve"><tspan x="126.8797" y="197.45615" font-family="Arial" stroke-width=".26458" text-align="center" text-anchor="middle">Error</tspan></text>
  <g transform="matrix(1.5304 0 0 1 72.775 164.71)">
   <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
   <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <text x="110.13182" y="194.27275" font-family="Arial" font-size="3.5278px" font-weight="bold" stroke-width=".26458" style="line-height:1.25" xml:space="preserve"><tspan x="110.13182" y="194.27275" font-family="Arial" font-size="3.5278px" font-style="italic" font-weight="normal" stroke-width=".26458">Yes</tspan></text>
  <text x="99.931984" y="213.55688" font-family="Arial" font-size="3.5278px" font-weight="bold" stroke-width=".26458" style="line-height:1.25" xml:space="preserve"><tspan x="99.931984" y="213.55688" font-family="Arial" font-size="3.5278px" font-style="italic" font-weight="normal" stroke-width=".26458">No</tspan></text>
  <g transform="matrix(0 1.5304 -1 0 128.13 171.87)">
   <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
   <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <rect id="algo_19" transform="rotate(45)" x="247.18" y="61.801" width="16.536" height="16.536" rx=".85231" ry=".19085" fill="#ccc" stop-color="#000000" style="paint-order:stroke fill markers"/>
  <text x="131.50755" y="226.34195" font-family="Arial" font-size="4.2333px" stroke-width=".26458" text-anchor="middle" style="line-height:1.25" xml:space="preserve"><tspan x="131.50755" y="226.34195" text-align="center">Has </tspan><tspan x="131.50755" y="231.63361" text-align="center"><tspan fill="#0000ff" font-family="'Source Code Pro'">float</tspan> </tspan><tspan x="131.50755" y="237.0343" text-align="center">?</tspan></text>
  <g transform="matrix(1.5304 0 0 1 72.775 198.92)">
   <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
   <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <text x="99.093964" y="245.31792" font-family="Arial" font-size="3.5278px" font-weight="bold" stroke-width=".26458" style="line-height:1.25" xml:space="preserve"><tspan x="99.093964" y="245.31792" font-family="Arial" font-size="3.5278px" font-style="italic" font-weight="normal" stroke-width=".26458">Yes</tspan></text>
  <g transform="matrix(0 1.5304 -1 0 128.13 206.07)">
   <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
   <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <text x="110.96984" y="227.8558" font-family="Arial" font-size="3.5278px" font-weight="bold" stroke-width=".26458" style="line-height:1.25" xml:space="preserve"><tspan x="110.96984" y="227.8558" font-family="Arial" font-size="3.5278px" font-style="italic" font-weight="normal" stroke-width=".26458">No</tspan></text>
  <text x="133.74527" y="245.31792" font-family="Arial" font-size="3.5278px" font-weight="bold" stroke-width=".26458" style="line-height:1.25" xml:space="preserve"><tspan x="133.74527" y="245.31792" font-family="Arial" font-size="3.5278px" font-style="italic" font-weight="normal" stroke-width=".26458">Yes</tspan></text>
  <g transform="matrix(0 1.5304 -1 0 162.33 206.07)">
   <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
   <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <g transform="matrix(0 1.5304 -1 0 196.76 206.22)">
   <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
   <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <text x="169.2346" y="245.31792" font-family="Arial" font-size="3.5278px" font-weight="bold" stroke-width=".26458" style="line-height:1.25" xml:space="preserve"><tspan x="169.2346" y="245.31792" font-family="Arial" font-size="3.5278px" font-style="italic" font-weight="normal" stroke-width=".26458">No</tspan></text>
  <path d="m142.77 230.17h22.733v11.84l-0.21878-0.14654" fill="none" stroke="#000" stroke-width=".26458px"/>
  <g>
   <path id="algo_21" d="m92.372 253.09a5.0196 3.4018 0 0 0-5.0197 3.4019 5.0196 3.4018 0 0 0 5.0197 3.4019 5.0196 3.4018 0 0 0 0.34161-8e-3c0.12223 0.012 0.24625 0.0196 0.3744 0.0196h6.9672c0.11536 0 0.22786-7e-3 0.33855-0.0165a5.0196 3.4018 0 0 0 0.26002 5e-3 5.0196 3.4018 0 0 0 5.0197-3.4019 5.0196 3.4018 0 0 0-5.0197-3.4019 5.0196 3.4018 0 0 0-0.35685 9e-3c-0.0795-5e-3 -0.15999-8e-3 -0.24172-8e-3h-6.9672c-0.09759 0-0.19241 5e-3 -0.28672 0.0119a5.0196 3.4018 0 0 0-0.4293-0.0124z" fill="#87deaa" stop-color="#000000" style="paint-order:stroke fill markers"/>
   <text x="96.410973" y="257.99271" fill="#ffaacc" font-family="Arial" font-size="3.8806px" stroke-width=".26458" style="line-height:1.25" xml:space="preserve"><tspan x="96.410973" y="257.99271" fill="#0000ff" font-family="'Source Code Pro'" font-size="3.8806px" font-style="italic" stroke-width=".26458" text-align="center" text-anchor="middle">int</tspan></text>
   <text x="130.99579" y="257.80371" fill="#ffaacc" font-family="Arial" font-size="3.8806px" stroke-width=".26458" style="line-height:1.25" xml:space="preserve"><tspan x="130.99579" y="257.80371" fill="#0000ff" font-family="'Source Code Pro'" font-size="3.8806px" font-style="italic" stroke-width=".26458" text-align="center" text-anchor="middle">float</tspan></text>
  </g>
  <text font-family="Arial" font-size="4.2333px" font-weight="bold" style="line-height:1.25;shape-inside:url(#rect2380);white-space:pre" xml:space="preserve"/>
  <text id="asdasd" x="165.29713" y="257.70923" fill="#ffaacc" font-family="Arial" font-size="3.8806px" stroke-width=".26458" style="line-height:1.25" xml:space="preserve"><tspan x="165.29713" y="257.70923" fill="#0000ff" font-family="'Source Code Pro'" font-size="3.8806px" font-style="italic" stroke-width=".26458" text-align="center" text-anchor="middle">decimal</tspan></text>
  <g transform="rotate(90 44 66.106)">
   <path d="m23.387 31.254h5.8114" stroke="#000" stroke-width=".26458px"/>
   <path d="m29.202 31.979v-1.4498l1.2556 0.72492-0.6278 0.36246z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <g fill="#fff">
   <path id="algo_25" d="m40.333 170.03a5.0196 3.4018 0 0 0-5.0197 3.4019 5.0196 3.4018 0 0 0 5.0197 3.4019 5.0196 3.4018 0 0 0 0.34162-8e-3c0.12223 0.012 0.24625 0.0196 0.3744 0.0196h6.9671c0.11536 0 0.22786-7e-3 0.33855-0.0165a5.0196 3.4018 0 0 0 0.26002 5e-3 5.0196 3.4018 0 0 0 5.0197-3.4019 5.0196 3.4018 0 0 0-5.0197-3.4019 5.0196 3.4018 0 0 0-0.35685 9e-3c-0.0795-5e-3 -0.15999-8e-3 -0.24172-8e-3h-6.9671c-0.0976 0-0.19241 5e-3 -0.28672 0.0119a5.0196 3.4018 0 0 0-0.4293-0.0124z" stop-color="#000000" style="paint-order:stroke fill markers"/>
   <path id="algo_26" d="m60.164 170.03a5.0196 3.4018 0 0 0-5.0197 3.4019 5.0196 3.4018 0 0 0 5.0197 3.4019 5.0196 3.4018 0 0 0 0.34162-8e-3c0.12223 0.012 0.24625 0.0196 0.3744 0.0196h6.9672c0.11536 0 0.22786-7e-3 0.33855-0.0165a5.0196 3.4018 0 0 0 0.26002 5e-3 5.0196 3.4018 0 0 0 5.0197-3.4019 5.0196 3.4018 0 0 0-5.0197-3.4019 5.0196 3.4018 0 0 0-0.35685 9e-3c-0.0795-5e-3 -0.15999-8e-3 -0.24172-8e-3h-6.9672c-0.0976 0-0.19241 5e-3 -0.28672 0.0119a5.0196 3.4018 0 0 0-0.4293-0.0124z" stop-color="#000000" style="paint-order:stroke fill markers"/>
   <path id="algo_24" d="m20.654 170.03a5.0196 3.4018 0 0 0-5.0197 3.4019 5.0196 3.4018 0 0 0 5.0197 3.4019 5.0196 3.4018 0 0 0 0.34161-8e-3c0.12223 0.012 0.24625 0.0196 0.3744 0.0196h6.9672c0.11536 0 0.22786-7e-3 0.33855-0.0165a5.0196 3.4018 0 0 0 0.26002 5e-3 5.0196 3.4018 0 0 0 5.0197-3.4019 5.0196 3.4018 0 0 0-5.0197-3.4019 5.0196 3.4018 0 0 0-0.35685 9e-3c-0.0795-5e-3 -0.15999-8e-3 -0.24172-8e-3h-6.9672c-0.09759 0-0.19241 5e-3 -0.28672 0.0119a5.0196 3.4018 0 0 0-0.4293-0.0124z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <g fill="#ffffff" font-family="Arial" font-size="3.8806px" stroke-width=".26458">
   <text x="24.692797" y="174.79074" style="line-height:1.25" xml:space="preserve"><tspan x="24.692797" y="174.79074" fill="#ffffff" font-family="'Source Code Pro'" font-size="3.8806px" font-style="italic" stroke-width=".26458" text-align="center" text-anchor="middle">int</tspan></text>
   <text x="44.348576" y="174.81596" style="line-height:1.25" xml:space="preserve"><tspan x="44.348576" y="174.81596" fill="#ffffff" font-family="'Source Code Pro'" font-size="3.8806px" font-style="italic" stroke-width=".26458" text-align="center" text-anchor="middle">float</tspan></text>
   <text x="64.475807" y="174.79268" style="line-height:1.25" xml:space="preserve"><tspan x="64.475807" y="174.79268" fill="#ffffff" font-family="'Source Code Pro'" font-size="3.8806px" font-style="italic" stroke-width=".26458" text-align="center" text-anchor="middle">decimal</tspan></text>
  </g>
  <g fill="#fff">
   <path id="algo_28" d="m40.584 104.62a5.0196 3.4018 0 0 0-5.0197 3.4019 5.0196 3.4018 0 0 0 5.0197 3.4019 5.0196 3.4018 0 0 0 0.34162-8e-3c0.12223 0.012 0.24625 0.0196 0.3744 0.0196h6.9671c0.11536 0 0.22786-7e-3 0.33855-0.0165a5.0196 3.4018 0 0 0 0.26002 5e-3 5.0196 3.4018 0 0 0 5.0197-3.4019 5.0196 3.4018 0 0 0-5.0197-3.4019 5.0196 3.4018 0 0 0-0.35685 9e-3c-0.0795-5e-3 -0.15999-8e-3 -0.24172-8e-3h-6.9671c-0.0976 0-0.19241 5e-3 -0.28672 0.0119a5.0196 3.4018 0 0 0-0.4293-0.0124z" stop-color="#000000" style="paint-order:stroke fill markers"/>
   <path id="algo_29" d="m60.415 104.62a5.0196 3.4018 0 0 0-5.0197 3.4019 5.0196 3.4018 0 0 0 5.0197 3.4019 5.0196 3.4018 0 0 0 0.34162-8e-3c0.12223 0.012 0.24625 0.0196 0.3744 0.0196h6.9672c0.11536 0 0.22786-7e-3 0.33855-0.0165a5.0196 3.4018 0 0 0 0.26002 5e-3 5.0196 3.4018 0 0 0 5.0197-3.4019 5.0196 3.4018 0 0 0-5.0197-3.4019 5.0196 3.4018 0 0 0-0.35685 9e-3c-0.0795-5e-3 -0.15999-8e-3 -0.24172-8e-3h-6.9672c-0.0976 0-0.19241 5e-3 -0.28672 0.0119a5.0196 3.4018 0 0 0-0.4293-0.0124z" stop-color="#000000" style="paint-order:stroke fill markers"/>
   <path id="algo_27" d="m20.905 104.62a5.0196 3.4018 0 0 0-5.0197 3.4019 5.0196 3.4018 0 0 0 5.0197 3.4019 5.0196 3.4018 0 0 0 0.34161-8e-3c0.12223 0.012 0.24625 0.0196 0.3744 0.0196h6.9672c0.11536 0 0.22786-7e-3 0.33855-0.0165a5.0196 3.4018 0 0 0 0.26002 5e-3 5.0196 3.4018 0 0 0 5.0197-3.4019 5.0196 3.4018 0 0 0-5.0197-3.4019 5.0196 3.4018 0 0 0-0.35685 9e-3c-0.0795-5e-3 -0.15999-8e-3 -0.24172-8e-3h-6.9672c-0.09759 0-0.19241 5e-3 -0.28672 0.0119a5.0196 3.4018 0 0 0-0.4293-0.0124z" stop-color="#000000" style="paint-order:stroke fill markers"/>
  </g>
  <g fill="#ffffff" font-family="Arial" font-size="3.8806px" stroke-width=".26458">
   <text x="24.943941" y="109.38479" style="line-height:1.25" xml:space="preserve"><tspan x="24.943941" y="109.38479" fill="#ffffff" font-family="'Source Code Pro'" font-size="3.8806px" font-style="italic" stroke-width=".26458" text-align="center" text-anchor="middle">int</tspan></text>
   <text x="44.59972" y="109.41001" style="line-height:1.25" xml:space="preserve"><tspan x="44.59972" y="109.41001" fill="#ffffff" font-family="'Source Code Pro'" font-size="3.8806px" font-style="italic" stroke-width=".26458" text-align="center" text-anchor="middle">float</tspan></text>
   <text x="64.726952" y="109.38673" style="line-height:1.25" xml:space="preserve"><tspan x="64.726952" y="109.38673" fill="#ffffff" font-family="'Source Code Pro'" font-size="3.8806px" font-style="italic" stroke-width=".26458" text-align="center" text-anchor="middle">decimal</tspan></text>
  </g>
  <path id="algo_30" d="m40.584 81.338a5.0196 3.4018 0 0 0-5.0197 3.4018 5.0196 3.4018 0 0 0 5.0197 3.4018 5.0196 3.4018 0 0 0 0.34162-8e-3c0.12223 0.012 0.24625 0.0196 0.3744 0.0196h6.9671c0.11536 0 0.22786-7e-3 0.33855-0.0165a5.0196 3.4018 0 0 0 0.26002 5e-3 5.0196 3.4018 0 0 0 5.0197-3.4018 5.0196 3.4018 0 0 0-5.0197-3.4018 5.0196 3.4018 0 0 0-0.35685 9e-3c-0.0795-5e-3 -0.15999-8e-3 -0.24172-8e-3h-6.9671c-0.0976 0-0.19241 5e-3 -0.28672 0.0119a5.0196 3.4018 0 0 0-0.4293-0.0124z" fill="#fff" stop-color="#000000" style="paint-order:stroke fill markers"/>
  <text x="44.59972" y="86.126656" fill="#ffffff" font-family="Arial" font-size="3.8806px" stroke-width=".26458" style="line-height:1.25" xml:space="preserve"><tspan x="44.59972" y="86.126656" fill="#ffffff" font-family="'Source Code Pro'" font-size="3.8806px" font-style="italic" stroke-width=".26458" text-align="center" text-anchor="middle">any</tspan></text>
 </g>
</svg>

<figcaption>Type checking Algorithm - Numeric Literal Type</figcaption>
</figure>

<script>
const dropdown = document.getElementById("numericAlgoSelect");

dropdown.addEventListener("change", function() {
  localStorage.setItem("numericLiteralExample", this.value);
  const value = this.value.replace(/[a-z]|-/g, '');;

  for (let i = 0; i < value.length; i++) {
    const element = document.getElementById(`algo_${i + 1}`);
    element.style.fill = value[i] === '1' ? '#89CFF0' : '';
  }
});

const storedValue = localStorage.getItem("numericLiteralExample");
if (storedValue) {
  dropdown.value = storedValue;
  const event = new Event("change");
  dropdown.dispatchEvent(event);
}
</script>
