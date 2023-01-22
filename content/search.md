---
title: 🔎 Search Examples
description: All Ballerina Examples
date : 2022-12-16
author: Hasitha
menu : main
share : []
weight : 99000
skipsearch : true
toc : false
---

<link href="/_pagefind/pagefind-ui.css" rel="stylesheet">
<script src="/_pagefind/pagefind-ui.js" type="text/javascript"></script>

<div id="search"></div>
<script type="text/javascript">
 window.addEventListener('DOMContentLoaded', (event) => {
        new PagefindUI({ 
          element: "#search",
          showEmptyFilters: false
        });
        let searchParams = new URLSearchParams(window.location.search);
        var inputbox = document.getElementById("search").querySelector('input');
        if (searchParams.has('q')) {
          // Handle direct url.
          let value = searchParams.get('q');
          inputbox.value = value;
          var ev = new Event('input');
          inputbox.dispatchEvent(ev);
        }
        inputbox.addEventListener('keyup', (event) => {
          event.preventDefault();
          if (event.keyCode === 13) {
            searchParams.set("q", inputbox.value);
            window.location.search = searchParams.toString();
          } else if (event.keyCode == 27) {
            inputbox.value = "";
          } else {
            return true;
          }
        });
    });
</script>
