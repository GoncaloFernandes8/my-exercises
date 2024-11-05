import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MyPicture {
    private boolean isClicked;


    String noImage = "src/rsc/no_image.png";
    String image0 = "src/rsc/0.png";
    String image1 = "src/rsc/1.png";
    String image2 = "src/rsc/2.png";
    String image3 = "src/rsc/3.png";
    String image4 = "src/rsc/4.png";
    String image5 = "src/rsc/5.png";
    String image6 = "src/rsc/6.png";
    String image7 = "src/rsc/7.png";


    //Array with images paths
    public String[] imagesArray = {image0, image1, image2, image3, image4, image5, image6, image7,
                                   image0, image1, image2, image3, image4, image5, image6, image7};
    //turn array in a list to remove a random index from de list when a card is chosen
    public static ArrayList<String> imagesList;



    public MyPicture(int positionX, int positionY, boolean isClicked) {
        this.isClicked = isClicked;

        if (imagesList == null || imagesList.isEmpty()) {
            prepareImagesList();
        }


    }

    private void prepareImagesList() {
        imagesList = new ArrayList<>(Arrays.asList(imagesArray));
        Collections.shuffle(imagesList);
    }


    public void showImage(String imagePath, int positionX, int positionY) {
        Picture image = new Picture(positionX, positionY, imagePath);
        image.draw();
    }


    public void showIcon(int positionX, int positionY) {
        Picture noImage = new Picture(positionX, positionY, this.noImage);
        noImage.draw();
    }

    public String getAnImagePath() {
        return imagesList.remove(0);

    }



}