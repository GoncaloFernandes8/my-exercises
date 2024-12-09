import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    private int positionY;
    private int positionX;
    private Rectangle rectangle;
    private boolean isClicked;
    private MyPicture myPicture;
    private String imagePath;

    public Cell(int positionX, int positionY, int cellSize) {
        this.rectangle = new Rectangle(positionX, positionY, cellSize, cellSize);
        this.positionX = positionX;
        this.positionY = positionY;
        this.isClicked = false;  // Definido como false inicialmente
        this.myPicture = new MyPicture(positionX, positionY, isClicked);
        this.imagePath = myPicture.getAnImagePath();
        rectangle.draw();
        rectangle.setColor(Color.WHITE);
    }

    public void setIsClicked(boolean isClicked) {
        this.isClicked = isClicked;
    }

    public boolean getIsClicked() {
        return this.isClicked;
    }

    public int getCellPositionX() {
        return this.positionX;
    }

    public int getCellPositionY() {
        return this.positionY;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public void showImage() {
        myPicture.showImage(imagePath, positionX, positionY);
    }

    public void hideImage() {
        myPicture.showIcon(positionX, positionY);
    }



}
