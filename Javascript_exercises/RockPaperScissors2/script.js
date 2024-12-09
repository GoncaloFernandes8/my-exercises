const choices = ["ROCK", "PAPER", "SCISSORS"];
const images = {
    ROCK: "src/rock.png",
    PAPER: "src/paper.png",
    SCISSORS: "src/scissors.png",
};

let score1 = 0;
let score2 = 0;

function getRandomChoice() {
    return choices[Math.floor(Math.random() * choices.length)];
}

function determineWinner(choice1, choice2) {
    if (choice1 === choice2) return "draw";
    if (
        (choice1 === "ROCK" && choice2 === "SCISSORS") ||
        (choice1 === "PAPER" && choice2 === "ROCK") ||
        (choice1 === "SCISSORS" && choice2 === "PAPER")
    ) {
        return "player1";
    }
    return "player2";
}

function playRound() {
    const choice1 = getRandomChoice();
    const choice2 = getRandomChoice();

    document.getElementById("choice1").src = images[choice1];
    document.getElementById("choice1Text").innerText = choice1;
    document.getElementById("choice2").src = images[choice2];
    document.getElementById("choice2Text").innerText = choice2;

    const winner = determineWinner(choice1, choice2);

    if (winner === "player1") {
        score1++;
        document.getElementById("score1").innerText = score1;
    } else if (winner === "player2") {
        score2++;
        document.getElementById("score2").innerText = score2;
    }
}

document.getElementById("playRound").addEventListener("click", playRound);
