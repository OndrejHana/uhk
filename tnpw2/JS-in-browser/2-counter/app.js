// set inital value to zero
let count = 0;
// select value and buttons
const value = document.querySelector("#value");
const btns = document.querySelectorAll(".btn");
const decreaseBtn = document.querySelector(".decrease");
const increaseBtn = document.querySelector(".increase");
const resetBtn = document.querySelector(".reset");

function resetValue() {
  count = 0;
  setCounter(count);
  styleCounter(count);
}

function increaseValue() {
  count = count + 1;
  setCounter(count);
  styleCounter(count);
}

function decreaseValue() {
  count = count - 1;
  setCounter(count);
  styleCounter(count);
}

function setCounter(count) {
  value.textContent = count;
}

function styleCounter(count) {
  if (count === 0) {
    value.style.color = "#222";
  }
  if (count > 0) {
    value.style.color = "green";
  }
  if (count < 0) {
    value.style.color = "red";
  }
}

decreaseBtn.addEventListener("click", decreaseValue);
increaseBtn.addEventListener("click", increaseValue);
resetBtn.addEventListener("click", resetValue);
