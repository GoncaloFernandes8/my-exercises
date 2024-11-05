import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import java.awt.event.MouseListener;
import java.util.Objects;

public class Grid implements MouseHandler, MouseListener {

    int cols = 4;
    int rows = 4;
    int cellSize = 130;
    int PADDING = 10;
    public Text triesCounter;
    public Cell[][] cellsArray;
    String firstCellPicture;
    String secondCellPicture;
    public String difficulty;
    public Picture tryAgainButton;
    public Picture exitButton;
    public Picture gameOver= new Picture(50,0,"src/rsc/flip_n_fail-06.png");
    public Picture winImage= new Picture(50,0,"src/rsc/flip_n_fail-05.png");
    public boolean gameStop = false;
    public int tries;

    Cell firstCell;
    Cell secondCell;

    boolean cell1created = false;
    boolean cell2created = false;


    public Grid(String difficulty) {
        this.difficulty = difficulty;
        setGameDifficulty(difficulty);
        drawGrid();
        initMouse();
        drawTriesCounter();


    }

    private int setGameDifficulty(String difficulty) {

        if (Objects.equals(difficulty, "Hard")) {
            return tries = 5;
        }
        if (Objects.equals(difficulty, "Medium")) {
            return tries = 10;
        }
        if (Objects.equals(difficulty, "Easy")) {
            return tries = 15;
        }

        return 0;
    }

    private void initMouse() {
        Mouse mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    private void drawGrid() {
        cellsArray = new Cell[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                Cell cell = new Cell(j * cellSize + PADDING, i * cellSize + PADDING, cellSize);
                cellsArray[i][j] = cell;
                cell.hideImage();
            }
        }

    }


    private void drawTryAgainButton() {
        tryAgainButton = new Picture(100, 550, "src/rsc/flip_n_fail-04.png");
        tryAgainButton.draw();
    }


    private boolean isInside(int mouseX, int mouseY, Picture button) {
        return mouseX >= button.getX() && mouseX <= button.getX() + button.getWidth() &&
                mouseY >= button.getY() && mouseY <= button.getY() + button.getHeight();
    }
    private void drawTriesCounter() {
        triesCounter = new Text(600, 250, "Tries left: " + tries); // Posiciona à direita
        triesCounter.setColor(Color.BLACK);
        triesCounter.grow(50, 25); // Aumenta o tamanho da caixa de texto
        triesCounter.draw();
    }

    private void updateTriesCounter() {
        triesCounter.setText("Tries left: " + tries);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int clickedX = (int) mouseEvent.getX();
        int clickedY = (int) mouseEvent.getY();


        if (tryAgainButton != null && isInside(clickedX, clickedY, tryAgainButton)) {
            System.out.println("clicaste no try again");
            restartGame();
            hideCards();
            tryAgainButton.delete();
            exitButton.delete();
            tryAgainButton = null;
            exitButton = null;
            gameStop = false;
            gameOver.delete();
            winImage.delete();
            setGameDifficulty(difficulty);
            updateTriesCounter();
            return;
        }

        if (exitButton != null && isInside(clickedX, clickedY, exitButton)) {
            System.out.println("clicaste exit");
            System.exit(0);

        }

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                Cell cell = cellsArray[i][j];


                if (!gameStop){


                if (clickedX >= cell.getCellPositionX() && clickedX <= cell.getCellPositionX() + cellSize &&
                        clickedY >= cell.getCellPositionY() && clickedY <= cell.getCellPositionY() + cellSize &&
                        !cell.getIsClicked()) {

                    // Se a primeira célula ainda não foi criada
                    if (!cell1created) {
                        firstCell = cell;
                        firstCellPicture = cell.getImagePath();
                        cell.showImage();
                        cell.setIsClicked(true);  // Define como clicada
                        cell1created = true;
                        System.out.println("Primeira célula selecionada");
                        return;
                    }

                    // Se a segunda célula ainda não foi criada e é diferente da primeira
                    if (!cell2created && cell != firstCell) {
                        secondCell = cell;
                        secondCellPicture = cell.getImagePath();
                        cell.showImage();
                        cell.setIsClicked(true);  // Define como clicada
                        cell2created = true;

                        System.out.println("Segunda célula selecionada");

                        // Comparar as imagens das duas células
                        if (compareCellsPicture(firstCellPicture, secondCellPicture)) {
                            System.out.println("Cartas iguais!");
                            resetSelection();
                            if(checkAllCellsFlipped()){
                                System.out.println("Ganhou o jogo!");
                                winImage.draw();
                                drawExitButton();
                                drawTryAgainButton();
                                gameStop = true;
                            }
                        } else {
                            System.out.println("Cartas diferentes!");
                            hideCards();
                            tries--;
                            updateTriesCounter();

                        }
                        if (tries == 0) {
                            drawTryAgainButton();
                            drawExitButton();
                            gameOver.draw();
                            gameStop = true;
                        }

                    }
                    }
                }
            }
        }
    }

    private void drawExitButton() {
        exitButton = new Picture(300,550,"src/rsc/flip_n_fail-03.png");
        exitButton.draw();
    }

    private boolean checkAllCellsFlipped(){
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (!cellsArray[i][j].getIsClicked()){
                    return false;
                }
            }
        }
        return true;
    }


    private boolean compareCellsPicture(String firstCellPicture, String secondCellPicture) {
        return firstCellPicture.equals(secondCellPicture);
    }

    // Reseta a seleção após a comparação
    private void resetSelection() {
        cell1created = false;
        cell2created = false;

    }


    private void restartGame() {
        tries = setGameDifficulty(difficulty);
        drawGrid();
        updateTriesCounter();
    }

    // Esconde as cartas se elas não forem iguais
    private void hideCards() {
        // Utiliza um temporizador para esconder as cartas após a comparação
        new Thread(() -> {
            try {
                Thread.sleep(1000);  // Pausa por 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            firstCell.hideImage();
            secondCell.hideImage();
            firstCell.setIsClicked(false);
            secondCell.setIsClicked(false);
            resetSelection();
        }).start();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
    }
}
