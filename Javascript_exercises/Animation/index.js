const box = document.querySelector("#box");
const container = document.querySelector("#container");
let direction = "right";
let bateu = false;

function move({ target }) {
  
  const currentLeft = parseInt(getComputedStyle(target).left);
  const containerWidth = container.clientWidth;
  const boxWidth = target.clientWidth;

  
  if (direction === "right") {
    target.style.left = (currentLeft + 1) + "px";

  } 
  if (direction === "left") {
    target.style.left = (currentLeft - 1) + "px";
  }

  if (direction === null) {
    target.style.left = 0 + "px";
  }

  if (currentLeft + boxWidth >= containerWidth) {
    bateu = true;
    direction = "left";
  } 
  if (currentLeft <= 0 && bateu == true) {
    clearInterval(interval);
    direction = null;
  }
  console.log("batata")
}

box.addEventListener("click", (e) => {
  bateu = false;
  interval = setInterval(() => move({ target: box }), 5);

});

