import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                var c = new Canvas(800, 600);
                c.start();
            }
        });


    }
}
