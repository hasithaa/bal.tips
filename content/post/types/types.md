---
title: "Types"
description: Ballerina Type Cheat Sheet
date : 2022-12-16
author: Hasitha
menu : main
weight : 5000
toc : true
tocOpen : false
draft : true
---

<label class="toggle">
  <input id="toggle-details" type="checkbox"></input>
  <span class="labels" data-on="Details" data-off="Just Syntax"></span>
</label>
<label class="toggle">
  <input id="toggle-summary" type="checkbox"></input>
  <span class="labels" data-on="Summary" data-off="No Summary"></span>
</label>
<label class="toggle">
  <input id="toggle-syntax" type="checkbox"></input>
  <span class="labels" data-on="Syntax Hints" data-off="Syntax Hints"></span>
</label>
<label class="toggle">
  <input id="toggle-tldr" type="checkbox"></input>
  <span class="labels" data-on="Highlights" data-off="No Highlights"></span>
</label>

<hr>

#### Simple Data Values

{{<summary title="" class="cl_summary" icon="💡">}}
`()`      ::: post/types/simple/nil
`boolean` ::: post/types/simple/boolean
`int`     ::: post/types/simple/int
`float`   ::: post/types/simple/float
`decimal` ::: post/types/simple/decimal
{{</summary>}}
<hr>

#### Sequence Data Values

{{<summary title="" class="cl_summary" icon="💡">}}
`string`  ::: post/types/sequence/string
`xml`     ::: post/types/sequence/xml
{{</summary>}}
<hr>

#### Tagged Data Values

{{<summary title="" class="cl_summary" icon="💡">}}
`regexp:RegExp` ::: post/types/tagged-data/regex
{{</summary>}}
<hr>

#### Structured Values

{{<summary title="" class="cl_summary" icon="💡">}}
`𝓣[]` ::: post/types/structured/array
`[𝓣, 𝓢]` ::: post/types/structured/tuple
`map<𝓣>` ::: post/types/structured/map
`record { 𝓣 𝓪; }` ::: post/types/structured/record
`table <𝓣>` ::: post/types/structured/table
{{</summary>}}
<hr>

#### Type References And Values as Types

{{<summary class="cl_summary" icon="💡">}}
`𝓣` &nbsp; `𝓶:𝓣` ::: post/types/other/typeref
`"Hello"` &nbsp; `123` &nbsp; `45.6` &nbsp; `true` ::: post/types/other/singleton
{{</summary>}}
<hr>

#### Behavioral Values

{{<summary class="cl_summary" icon="💡">}}

{{</summary>}}

#### Type-Level Operations

#### Built-In Types

{{<summary class="cl_summary" icon="💡">}}
`any` ::: post/types/builtin/any
`anydata` ::: post/types/builtin/anydata
`json` ::: post/types/builtin/json
`byte` ::: post/types/builtin/byte
`never` ::: post/types/builtin/never
`readonly` ::: post/types/builtin/readonly
{{</summary>}}
<hr>

#### Language Defined Subtypes

{{<summary title="" class="cl_summary" icon="💡">}}
`int:Signed32`<br> `int:Signed16`<br> `int:Signed8`<br> `int:Unsigned32`<br> `int:Unsigned16`<br> `int:Unsigned8` ::: post/types/builtin/subtypes/int
`string:char` ::: post/types/builtin/subtypes/string
`xml:Element` ::: post/types/builtin/subtypes/xml
{{</summary>}}
<hr>

<script type="text/javascript">
function toggleView(ch, cls) {
  document.body.querySelectorAll(cls).forEach((e) => {
    e.style.display = ch.checked ? "block" : "none";
  });
}
function disableToggle(chs) {
  chs.forEach((e) => { e.parentElement.style.visibility = "hidden"; e.disabled = true; e.parentElement.classList.add('disable'); });
}
function enableToggle(chs) {
  chs.forEach((e) => { e.parentElement.style.visibility = "visible"; e.disabled = false; e.parentElement.classList.remove('disable'); });
}
document.addEventListener('DOMContentLoaded', function () {
  var details =  document.getElementById('toggle-details');
  var summary =  document.getElementById('toggle-summary');
  var syntax =  document.getElementById('toggle-syntax');
  var tldr =  document.getElementById('toggle-tldr');

  details.addEventListener('change', function () {
    if (details.checked) {
      enableToggle([summary, syntax, tldr]);
      document.body.querySelectorAll(".cl_summary").forEach((e) => { e.style.display  = 'block'; });
      document.body.querySelectorAll(".cl_summary_list").forEach((e) => { e.style.display  = 'none'; });
    } else {
      disableToggle([summary, syntax, tldr]);
      document.body.querySelectorAll(".cl_summary").forEach((e) => { e.style.display  = 'none'; });
      document.body.querySelectorAll(".cl_summary_list").forEach((e) => { e.style.display  = 'flex'; });
    }
  });
  syntax.addEventListener('change', function () { toggleView(syntax, ".syntax");});
  tldr.addEventListener('change', function () { toggleView(tldr, ".tldr");});
  summary.addEventListener('change', function () { toggleView(summary, ".summary");});
  details.checked = true;
  summary.checked = true; toggleView(summary, ".summary");
  syntax.checked = true; toggleView(syntax, ".syntax");
  tldr.checked = true; toggleView(tldr, ".tldr");
});
</script>