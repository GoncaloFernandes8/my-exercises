import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {
    private Clip clip;

    public void playMusic(String filePath) {
        try {
            // Carregar o arquivo de áudio
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Toca a música em loop
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop(); // Para a música
        }
    }

    public void startMusic() {
        if (clip != null && !clip.isRunning()) {
            clip.start(); // Começa a música
        }
    }
}
