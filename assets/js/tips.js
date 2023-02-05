function highlightID(id) {
  document.getElementById(id).animate({
    color: ["#fff", "auto"],
    backgroundColor: ["#77baff", "transparent"],
    easing: ['ease-out'],
    borderRadius: ['2em'],
    pseudoElement: '::before'
  }, 2000);
}
function insertUrlParam(key, value) {
  if (history.pushState) {
      let searchParams = new URLSearchParams(window.location.search);
      searchParams.set(key, value);
      let newurl = window.location.protocol + "//" + window.location.host + window.location.pathname + '?' + searchParams.toString();
      window.history.pushState({path: newurl}, '', newurl);
  }
}
function removeUrlParameter(paramKey) {
  const url = window.location.href
  var r = new URL(url)
  r.searchParams.delete(paramKey)
  const newUrl = r.href
  window.history.pushState({ path: newUrl }, '', newUrl)
}
function debounce(func, delay = 1000) {
  let timeoutId;
  return function (...arguments) {
    clearTimeout(timeoutId);

    timeoutId = setTimeout(() => {
      func(...arguments);
    }, delay);
  };
}
