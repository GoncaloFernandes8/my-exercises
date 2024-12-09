const style = document.createElement("style");
style.textContent = `
  body {
    font-family: 'Arial', sans-serif;
    text-align: center;
    margin: 0;
    padding: 0;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    min-height: 100vh;
    background-color: #f0f0f0;
  }
  #game-container {
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 90%;
    max-width: 800px;
    margin-bottom: 20px;
    background-color: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
  }
  #player1, #player2 {
    flex: 1;
    text-align: center;
  }
  .player-name {
    font-size: 18px;
    font-weight: bold;
    margin-bottom: 10px;
  }
  .score {
    font-size: 24px;
    font-weight: bold;
    color: #007bff;
    margin-bottom: 10px;
  }
  img {
    width: 120px;
    height: auto;
    margin-bottom: 10px;
    transition: transform 0.3s ease;
  }
  img:hover {
    transform: scale(1.1);
  }
  #result {
    font-size: 28px;
    font-weight: bold;
    margin: 20px;
    color: #28a745;
  }
  
  #choices {
    display: flex;
    justify-content: center;
    margin-bottom: 20px;
  }
  .choice {
    margin: 0 10px;
    cursor: pointer;
    transition: transform 0.3s ease;
  }
  .choice:hover {
    transform: scale(1.1);
  }
`;
document.head.appendChild(style);

const choices = ["rock", "paper", "scissors"];
const images = {
  rock: "src/rock.png",
  paper: "src/paper.png",
  scissors: "src/scissors.png",
};

let playerScore = 0;
let computerScore = 0;

function getRandomChoice() {
  return choices[Math.floor(Math.random() * choices.length)];
}

function determineWinner(playerChoice, computerChoice) {
  if (playerChoice === computerChoice) return "It's a draw!";
  if (
    (playerChoice === "rock" && computerChoice === "scissors") ||
    (playerChoice === "paper" && computerChoice === "rock") ||
    (playerChoice === "scissors" && computerChoice === "paper")
  ) {
    playerScore++;
    return "You Win!";
  }
  computerScore++;
  return "Computer Wins!";
}

function updateScores() {
  document.getElementById("player-score").textContent = playerScore;
  document.getElementById("computer-score").textContent = computerScore;
}

function playGame(playerChoice) {
  const computerChoice = getRandomChoice();

  document.getElementById("player1-img").src = images[playerChoice];
  document.getElementById("player1-img").alt = playerChoice;

  document.getElementById("player2-img").src = images[computerChoice];
  document.getElementById("player2-img").alt = computerChoice;

  const result = determineWinner(playerChoice, computerChoice);
  document.getElementById("result").textContent = result;

  updateScores();
}

// Create the game structure
const gameContainer = document.createElement("div");
gameContainer.id = "game-container";

const player1 = document.createElement("div");
player1.id = "player1";
player1.innerHTML = `
  <div class="player-name">You</div>
  <div class="score">Score: <span id="player-score">0</span></div>
  <img id="player1-img" src="${images.rock}" alt="rock">
`;

const player2 = document.createElement("div");
player2.id = "player2";
player2.innerHTML = `
  <div class="player-name">Computer</div>
  <div class="score">Score: <span id="computer-score">0</span></div>
  <img id="player2-img" src="${images.rock}" alt="rock">
`;

gameContainer.appendChild(player1);
gameContainer.appendChild(player2);

const result = document.createElement("div");
result.id = "result";
result.textContent = "Choose your weapon!";

const choicesContainer = document.createElement("div");
choicesContainer.id = "choices";

choices.forEach(choice => {
  const choiceElement = document.createElement("img");
  choiceElement.src = images[choice];
  choiceElement.alt = choice;
  choiceElement.classList.add("choice");
  choiceElement.addEventListener("click", () => playGame(choice));
  choicesContainer.appendChild(choiceElement);
});

document.body.appendChild(gameContainer);
document.body.appendChild(result);
document.body.appendChild(choicesContainer);