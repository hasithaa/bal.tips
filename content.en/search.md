---
title: 🔎 Search
description: Search
date : 2022-12-16
weight : 40000
type: internal
---

<link href="/_pagefind/pagefind-ui.css" rel="stylesheet">
<script src="/_pagefind/pagefind-ui.js" type="text/javascript"></script>

<div id="search"></div>

![thinking mascot](/images/mascot/thinking.png "thinking mascot")

<script type="text/javascript">
    function updateParam(inputbox, name) {
    insertUrlParam(name, inputbox.value);
    }
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
        const debouncedUpdateParam = debounce(updateParam);
        inputbox.addEventListener('keyup', (event) => {
            debouncedUpdateParam(inputbox, "q");
        });
    });
</script>