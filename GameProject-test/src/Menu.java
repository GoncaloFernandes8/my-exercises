import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements MouseHandler {

    private boolean startGame = false;
    private final Picture startButton;
    private final Picture exitButton;

    private final Picture easyButton;
    private final Picture mediumButton;
    private final Picture hardButton;





    String easyButtonImage = "src/rsc/botoes-03.png";
    String mediumButtonImage= "src/rsc/botoes-02_360.png";
    String hardButtonImage = "src/rsc/botoes-01.png";

    String easyButtonSelectedImage = "src/rsc/botoes-06.png";
    String mediumButtonSelectedImage = "src/rsc/botoes-05.png";
    String hardButtonSelectedImage = "src/rsc/botoes-04_360.png";



    private String difficulty = "Medium";

    private boolean clicked = true;



    public Menu() {
        // Fundo do menu
        Rectangle background = new Rectangle(0, 0, 500, 500);
        background.setColor(Color.WHITE);
        background.fill();

        // Botão "Iniciar Jogo"

        this.startButton = new Picture(220, 150, "src/rsc/flip_n_fail-02.png");
        startButton.draw();


        // Botão "Sair"
        this.exitButton = new Picture(220, 250, "src/rsc/flip_n_fail-03.png");
        exitButton.draw();

        //========================

        this.easyButton = new Picture(20, 350, easyButtonImage);
        easyButton.draw();


        this.mediumButton = new Picture(220, 350, mediumButtonImage);
        mediumButton.draw();

        this.hardButton = new Picture(420, 350, hardButtonImage);
        hardButton.draw();



        // Adicionar handler do mouse
        Mouse mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    private boolean isInside(int mouseX, int mouseY, Picture button) {
        return mouseX >= button.getX() && mouseX <= button.getX() + button.getWidth() &&
                mouseY >= button.getY() && mouseY <= button.getY() + button.getHeight();
    }


    private void closeMenu() {
        startButton.delete(); // Remove o botão "Iniciar Jogo"
        exitButton.delete();  // Remove o botão "Sair"
        easyButton.delete();
        mediumButton.delete();
        hardButton.delete();

    }


    public boolean isStartGame() {
        Game game = new Game(difficulty);
        closeMenu();
        // Você pode adicionar lógica aqui para iniciar o jogo visualmente
        return false;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        // Ignora cliques se o jogo já começou
        if (startGame) {
            return;
        }

        int x = (int) mouseEvent.getX();
        int y = (int) mouseEvent.getY();

        // Verifica se o clique foi dentro do botão "Iniciar Jogo"
        if (isInside(x, y, startButton)) {
            startGame = true; // Sinaliza que o jogo deve começar
            closeMenu(); // Fecha o menu
            isStartGame(); // Inicia o jogo
        }


        // Verifica se o clique foi dentro do botão "Sair"
        if (isInside(x, y, exitButton)) {
            System.exit(0); // Sai do programa
        }


         //=======================

        if (isInside(x, y, easyButton)) {
            difficulty = "Easy";  // Define a dificuldade como "Fácil"
            System.out.println("Dificuldade selecionada: Easy");
            changeEasyImage();
        }

        if (isInside(x, y, mediumButton)) {
            difficulty = "Medium";  // Define a dificuldade como "Média"
            System.out.println("Dificuldade selecionada: Medium");
            changeMediumImage();
        }

        if (isInside(x, y, hardButton)) {
            difficulty = "Hard";  // Define a dificuldade como "Difícil"
            System.out.println("Dificuldade selecionada: Hard");
            changeHardImage();
        }

    }

    private void changeEasyImage() {
        if(!clicked){
            easyButton.load(easyButtonSelectedImage);
            clicked = true;
            return;
        }
        easyButton.load(easyButtonImage);
        clicked = false;
    }

    private void changeMediumImage() {
        if(!clicked){
            mediumButton.load(mediumButtonSelectedImage);
            clicked = true;
            return;
        }
        mediumButton.load(mediumButtonImage);
        clicked = false;
    }
    private void changeHardImage() {
        if(!clicked){
            hardButton.load(hardButtonSelectedImage);
            clicked = true;
            return;
        }
        hardButton.load(hardButtonImage);
        clicked = false;
    }


    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }
}



