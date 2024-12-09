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
    body.style.flexDirection = "column";
    body.style.alignItems = "center";
    body.style.margin = "0";
    body.style.height = "100vh";

    const columnsContainer = document.createElement("div");
    columnsContainer.style.display = "flex";
    columnsContainer.style.width = "100%";
    columnsContainer.style.flex = "1";

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
        column.style.transition = "background-color 0.5s ease";

        columnsContainer.appendChild(column);
    }

    body.appendChild(columnsContainer);

    const changeColorButton = document.createElement("button");
    changeColorButton.innerText = "Change Colors";
    changeColorButton.style.marginTop = "20px";
    changeColorButton.style.padding = "10px 20px";
    changeColorButton.style.fontSize = "18px";
    changeColorButton.style.cursor = "pointer";

    changeColorButton.addEventListener("click", () => {
        const columns = columnsContainer.children;
        for (let column of columns) {
            const newColor = getRandomColor();
            column.style.backgroundColor = newColor;
            column.innerText = newColor;
        }
    });

    body.appendChild(changeColorButton);
}

// Initialize the script when the page loads
window.onload = createColumns;