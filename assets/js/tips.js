function highlightID(id) {
  document.getElementById(id).animate({
    color: ["#fff", "auto"],
    backgroundColor: ["#77baff", "transparent"],
    easing: ['ease-out'],
    borderRadius: ['2em'],
    pseudoElement: '::before'
  }, 2000);
}
