const parent = document.getElementById("row1");
const wordList = Array.from(parent.children).map((a) => a.innerText);
const input = document.getElementById("inputfield");

let count = 0;
input.addEventListener("keydown", () => (input.value = wordList[count++]));
