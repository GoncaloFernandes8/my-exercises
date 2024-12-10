// Constants
const CHOICES = ["rock", "paper", "scissors"];
const NOT_SELECTED_IMAGE = "src/notSelected.png";
const TIE_IMAGE = "src/espada.png";
const GAME_IMAGES = {
    rock: "src/rock.png",
    paper: "src/paper.png",
    scissors: "src/scissors.png"
};
const AVATAR_IMAGES = {
    "0": { src: "src/0.png", name: "Gustavo" },
    "1": { src: "src/1.png", name: "Mekie" },
    "5": { src: "src/5.png", name: "Jorge" },
    "7": { src: "src/7.png", name: "Mafalda" }
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

    Object.entries(AVATAR_IMAGES).forEach(([key, value]) => {
        const img1 = createAvatarImage(key, 'player1');
        const img2 = createAvatarImage(key, 'player2');
        img1.title = value.name;
        img2.title = value.name;
        player1ImageSelection.appendChild(img1);
        player2ImageSelection.appendChild(img2);
    });
}

function createAvatarImage(avatar, player) {
    const img = document.createElement('img');
    img.src = AVATAR_IMAGES[avatar].src;  // Corrigido para acessar a propriedade 'src'
    img.alt = AVATAR_IMAGES[avatar].name;
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

    const avatarKey = clickedImage.dataset.avatar;
    const avatarName = AVATAR_IMAGES[avatarKey].name;

    if (playerSelection.id === 'player1Setup') {
        player1Avatar = avatarKey;
        document.querySelector('#player1Area h2').textContent = avatarName;
    } else {
        player2Avatar = avatarKey;
        document.querySelector('#player2Area h2').textContent = avatarName;
    }

    checkIfBothPlayersSelectedAvatar();
    updatePlayerAvatars(); // Adicione esta linha
}

// Check if both players have selected their avatars
function checkIfBothPlayersSelectedAvatar() {
    if (player1Avatar && player2Avatar) {
        startGameButton.disabled = false;
        startGameButton.style.display = 'inline-block';
        console.log("Both players selected avatars, Start Game button enabled");
    } else {
        startGameButton.disabled = true;
        startGameButton.style.display = 'none';
        console.log("Not all players selected avatars, Start Game button disabled");
    }
}

function handleAvatarSelection(event, player) {
    const selectedAvatar = event.target.getAttribute('data-avatar');
    if (player === 'player1') {
        player1Avatar = selectedAvatar;
        updateAvatarImage('player1', selectedAvatar);
    } else {
        player2Avatar = selectedAvatar;
        updateAvatarImage('player2', selectedAvatar);
    }
    checkIfBothPlayersSelectedAvatar();
}

function updateAvatarImage(player, avatar) {
    const setupArea = document.querySelector(`#${player}Setup`);
    const gameArea = document.querySelector(`#${player}Area`);
    
    // Atualiza a imagem na área de configuração
    setupArea.querySelector('.selectedImage img').src = AVATAR_IMAGES[avatar].src;
    
    // Atualiza a imagem e o nome na área do jogo
    gameArea.querySelector('.avatar').src = AVATAR_IMAGES[avatar].src;
    gameArea.querySelector('h2').textContent = AVATAR_IMAGES[avatar].name;
}

// Start the game
// Start the game
function startGame() {
    console.log("Start Game function called");
    playerSetup.style.display = 'none';
    gameArea.style.display = 'block';
    startGameButton.style.display = 'none';
    playButton.style.display = 'inline-block';
    resetButton.style.display = 'inline-block';
    updatePlayerAvatars();
    resultText.textContent = 'Choose your weapon!';
    updateScoreDisplay();
}

function updatePlayerAvatars() {
    updateAvatarImage('player1', player1Avatar);
    updateAvatarImage('player2', player2Avatar);
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
    const resultDisplay = document.createElement('div');
    resultDisplay.className = 'result-display';

    const resultImg = document.createElement('img');
    resultImg.className = 'winner-avatar';
    
    const resultText = document.createElement('p');

    if (result === 'tie') {
        resultImg.src = TIE_IMAGE;
        resultImg.alt = "It's a tie!";
        resultText.textContent = "It's a tie!";
    } else {
        const winnerAvatar = result === 'player1' ? player1Avatar : player2Avatar;
        resultImg.src = AVATAR_IMAGES[winnerAvatar].src;
        resultImg.alt = `${AVATAR_IMAGES[winnerAvatar].name} wins`;
        resultText.textContent = `${AVATAR_IMAGES[winnerAvatar].name} WINS!`;
    }

    resultDisplay.appendChild(resultImg);
    resultDisplay.appendChild(resultText);

    // Atualizar as imagens selecionadas e exibi-las
    player1SelectedImg.src = GAME_IMAGES[player1Selection];
    player2SelectedImg.src = GAME_IMAGES[player2Selection];
    player1SelectedImg.style.display = 'block';
    player2SelectedImg.style.display = 'block';

    // Atualizar as imagens na área do jogo
    player1Img.src = GAME_IMAGES[player1Selection];
    player2Img.src = GAME_IMAGES[player2Selection];
    player1Img.style.display = 'block';
    player2Img.style.display = 'block';

    // Limpar o conteúdo anterior e adicionar o novo resultado
    resultText.innerHTML = '';
    resultText.appendChild(resultDisplay);
}
function initializeGame() {
    resetGame();
    setupAvatarSelection();
    
    startGameButton.addEventListener('click', startGame);
    playButton.addEventListener("click", playRound);
    resetButton.addEventListener("click", resetGame);
}

function resetGame() {
    player1Selection = '';
    player2Selection = '';
    player1Avatar = '';
    player2Avatar = '';
    player1Score = 0;
    player2Score = 0;
    
    hidePlayerImages();
    resetScores();
    
    playerSetup.style.display = 'block';
    gameArea.style.display = 'none';
    startGameButton.style.display = 'none';
    playButton.style.display = 'none';
    resetButton.style.display = 'none';
    
    resultText.textContent = '';
    
    // Reset avatar selections
    document.querySelectorAll('.imageSelection img').forEach(img => img.classList.remove('selected'));
    player1SelectedImg.src = NOT_SELECTED_IMAGE;
    player2SelectedImg.src = NOT_SELECTED_IMAGE;
    
    updateScoreDisplay();
}
// Initialize the game when the script loads
initializeGame();

document.addEventListener('DOMContentLoaded', initializeGame);