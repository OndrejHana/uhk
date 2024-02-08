// classList - shows/gets all classes
// toggle - toggles class

const navToggle = document.querySelector(".nav-toggle");
const links = document.querySelector(".links");

function toggleClass() {
  links.classList.toggle("show-links");
}

navToggle.addEventListener("click", toggleClass);
