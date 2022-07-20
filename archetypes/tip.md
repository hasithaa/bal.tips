---
title : "{{ replace .TranslationBaseName "-" " " | title }}"
date : {{ .Date }}
kind : tip 
tags : [] # Include tips based on keywords
code : [] # List of files to be included as code.
weight : 0000000001  # First 4 pairs - Based on spec topic levels, last pair - custom
size : "small" # defaults to small, large otherwise. Size of the tip is based on this value.
disableNavChevron : true 
seeMore : true
---

{{ replace .TranslationBaseName "-" " " | title }}
<!-- Add page summary here -->

<!--more-->

{{< gencode >}}