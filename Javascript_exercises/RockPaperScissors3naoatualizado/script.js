// Constants
const CHOICES = ["rock", "paper", "scissors"];
const NOT_SELECTED_IMAGE = "src/notSelected.png";

const GAME_IMAGES = {
    rock: "src/rock.png",
    paper: "src/paper.png",
    scissors: "src/scissors.png"
};
const AVATAR_IMAGES = {
    "0": "src/0.png",
    "1": "src/1.png",
    "5": "src/5.png",
    "7": "src/7.png"
};
const WINNING_COMBINATIONS = {
    rock: ["scissors"],
    paper: ["rock"],
    scissors: ["paper"]
};

// DOM Elements

const playerSetup = document.getElementById('playerSetup');
const gameArea = document.getElementById('gameArea');
const startGameButton = document.getElementById('start-game');
const playButton = document.getElementById('play-button');
const resetButton = document.getElementById('reset-button');
const player1Img = document.getElementById('player1-img');
const player2Img = document.getElementById('player2-img');
const resultText = document.getElementById('result');
const player1ScoreElement = document.getElementById("player1-score");
const player2ScoreElement = document.getElementById("player2-score");
const player1SelectedImg = document.getElementById('player1SelectedImg');
const player2SelectedImg = document.getElementById('player2SelectedImg');

// Game State
let player1Score = 0;
let player2Score = 0;
let player1Selection = '';
let player2Selection = '';
let player1Avatar = '';
let player2Avatar = '';

// Initialize game
function initializeGame() {
    hidePlayerImages();
    resetScores();
    setupAvatarSelection();
    startGameButton.addEventListener('click', startGame);
    playButton.addEventListener("click", playRound);
    resetButton.addEventListener("click", resetGame);
    
    // Inicialize as imagens selecionadas com a imagem "notSelected"
    player1SelectedImg.src = NOT_SELECTED_IMAGE;
    player2SelectedImg.src = NOT_SELECTED_IMAGE;
}
// Hide player images
function hidePlayerImages() {
    player1Img.style.display = 'none';
    player2Img.style.display = 'none';
}

// Reset scores
function resetScores() {
    player1Score = 0;
    player2Score = 0;
    updateScoreDisplay();
}

// Update score display
function updateScoreDisplay() {
    player1ScoreElement.textContent = player1Score;
    player2ScoreElement.textContent = player2Score;
}

// Setup avatar selection
function setupAvatarSelection() {
    const player1ImageSelection = document.querySelector('#player1Setup .imageSelection');
    const player2ImageSelection = document.querySelector('#player2Setup .imageSelection');

    Object.keys(AVATAR_IMAGES).forEach(avatar => {
        const img1 = createAvatarImage(avatar, 'player1');
        const img2 = createAvatarImage(avatar, 'player2');
        player1ImageSelection.appendChild(img1);
        player2ImageSelection.appendChild(img2);
    });
}

// Create avatar image
function createAvatarImage(avatar, player) {
    const img = document.createElement('img');
    img.src = AVATAR_IMAGES[avatar];
    img.alt = avatar;
    img.dataset.avatar = avatar;
    img.addEventListener('click', selectPlayerAvatar);
    return img;
}

// Select player avatar
function selectPlayerAvatar(event) {
    const clickedImage = event.target;
    const playerSelection = clickedImage.closest('.playerSetup');
    const allImages = playerSelection.querySelectorAll('.imageSelection img');
    
    allImages.forEach(img => img.classList.remove('selected'));
    clickedImage.classList.add('selected');

    const selectedImg = playerSelection.querySelector('.selectedImage img');
    selectedImg.src = clickedImage.src;
    selectedImg.alt = clickedImage.alt;

    if (playerSelection.id === 'player1Setup') {
        player1Avatar = clickedImage.dataset.avatar;
    } else {
        player2Avatar = clickedImage.dataset.avatar;
    }

    checkIfBothPlayersSelectedAvatar();
}

// Check if both players have selected their avatars
function checkIfBothPlayersSelectedAvatar() {
    if (player1Avatar && player2Avatar) {
        startGameButton.style.display = 'inline-block';
        startGameButton.disabled = false;  // Habilita o botão
    } else {
        startGameButton.style.display = 'none';
        startGameButton.disabled = true;  // Desabilita o botão
    }
}

// Start the game
// Start the game
function startGame() {
    playerSetup.style.display = 'none';
    gameArea.style.display = 'block';
    updatePlayerAvatars();
    resultText.textContent = 'Choose your weapon!';
    updateScoreDisplay();
    playButton.style.display = 'inline-block';
    resetButton.style.display = 'inline-block';
    startGameButton.style.display = 'none';  // Oculta o botão Start Game
}

// Update player avatars
// Update player avatars
function updatePlayerAvatars() {
    const player1AvatarImg = document.getElementById('player1-avatar');
    const player2AvatarImg = document.getElementById('player2-avatar');
    player1AvatarImg.src = AVATAR_IMAGES[player1Avatar];
    player2AvatarImg.src = AVATAR_IMAGES[player2Avatar];
}

// Play a round
function playRound() {
    player1Selection = CHOICES[Math.floor(Math.random() * CHOICES.length)];
    player2Selection = CHOICES[Math.floor(Math.random() * CHOICES.length)];
    
    player1Img.src = GAME_IMAGES[player1Selection];
    player2Img.src = GAME_IMAGES[player2Selection];
    player1Img.style.display = 'block';
    player2Img.style.display = 'block';

    const result = determineWinner(player1Selection, player2Selection);
    updateScore(result);
    displayResult(result);
}

// Determine the winner
function determineWinner(player1Choice, player2Choice) {
    if (player1Choice === player2Choice) return 'tie';
    if (WINNING_COMBINATIONS[player1Choice].includes(player2Choice)) return 'player1';
    return 'player2';
}

// Update score
function updateScore(result) {
    if (result === 'player1') player1Score++;
    if (result === 'player2') player2Score++;
    updateScoreDisplay();
}

// Display result
function displayResult(result) {
    if (result === 'tie') {
        resultText.textContent = "It's a tie!";
    } else if (result === 'player1') {
        resultText.textContent = "Player 1 wins!";
    } else {
        resultText.textContent = "Player 2 wins!";
    }
}

// Reset game
// Reset game
function resetGame() {
    player1Selection = '';
    player2Selection = '';
    player1Avatar = '';
    player2Avatar = '';
    resetScores();
    hidePlayerImages();
    resultText.textContent = 'Choose your weapon!';
    playerSetup.style.display = 'block';
    gameArea.style.display = 'none';
    startGameButton.style.display = 'none';
    startGameButton.disabled = true;
    playButton.style.display = 'none';
    resetButton.style.display = 'none';
    document.querySelectorAll('.imageSelection img').forEach(img => img.classList.remove('selected'));
    
    // Use a imagem "notSelected" para as imagens selecionadas
    player1SelectedImg.src = NOT_SELECTED_IMAGE;
    player2SelectedImg.src = NOT_SELECTED_IMAGE;
    player1SelectedImg.alt = 'Not Selected';
    player2SelectedImg.alt = 'Not Selected';
}

// Initialize the game when the script loads
initializeGame();