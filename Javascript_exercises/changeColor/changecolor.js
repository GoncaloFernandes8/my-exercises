function getRandomColor() {
    const letters = "0123456789ABCDEF";
    let color = "#";
    for (let i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}

function createColumns() {
    const body = document.body;
    body.style.display = "flex";
    body.style.margin = "0";
    body.style.height = "100vh";

    for (let i = 0; i < 5; i++) {
        const color = getRandomColor();
        const column = document.createElement("div");
        column.style.flex = "1";
        column.style.backgroundColor = color;
        column.innerText = color;
        column.style.textAlign = "center";
        column.style.alignContent = "end";
        column.style.fontSize = "24px";
        column.style.padding = "10px";
        column.style.color = "white";
        column.style.fontWeight = "bold";
        column.style.textShadow = "2px 2px 4px rgba(0, 0, 0, 0.5)";
        column.style.boxShadow = "0 4px 8px rgba(0, 0, 0, 0.1)";
        column.style.cursor = "pointer";
        column.style.transition = "background-color 0.5s ease";

        body.appendChild(column);

        // Call the function to add the click event
        addClickEvent(column);
    }
}

// Add this at the top of your file, outside any function
const activeColumns = new Set();

function addClickEvent(column) {
    column.addEventListener("click", () => {
        if (!activeColumns.has(column)) {
            const newColor = getRandomColor();
            column.style.backgroundColor = newColor;
            column.innerText = newColor;

            repeatedColorChange(column);
            activeColumns.add(column);
        }
    });
}

function repeatedColorChange(column) {
    const intervalId = setInterval(() => {
        const delayedColor = getRandomColor();
        column.style.backgroundColor = delayedColor;
        column.innerText = delayedColor;
    }, 400);

    column.addEventListener("dblclick", () => {
        clearInterval(intervalId);
        activeColumns.delete(column);
    });
}




// Initialize the script when the page loads
window.onload = createColumns;
