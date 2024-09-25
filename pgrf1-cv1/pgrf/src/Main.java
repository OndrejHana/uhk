import javax.swing.*;
import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                var cv = new Canvas(800, 600);
                cv.start();
            }
        });
    }
}