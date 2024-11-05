import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {
    public static void main(String[] args) {

        MusicPlayer musicPlayer= new MusicPlayer();
        Picture introducePicture = new Picture(0, 0, "src/rsc/ai_cover.jpeg");
        introducePicture.draw();
        musicPlayer.playMusic("src/rsc/game-music-teste-204327.wav");


        new Thread(() -> {
            try {
                Thread.sleep(4000);  // Pausa por 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Menu menu = new Menu();
            introducePicture.delete();
        }).start();


    }
}
