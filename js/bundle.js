const toggle=document.getElementById("toggle"),menu=document.getElementById("menu");function toggleMenu(){menu.classList.toggle("main-nav__list--active"),this.classList.toggle("main-nav__btn--active"),this.setAttribute("aria-expanded",this.getAttribute("aria-expanded")==="true"?"false":"true")}toggle.addEventListener("click",toggleMenu,!1)
;
function highlightID(e){document.getElementById(e).animate({color:["#fff","auto"],backgroundColor:["#77baff","transparent"],easing:["ease-out"],borderRadius:["2em"],pseudoElement:"::before"},2e3)}