import javax.swing.*;

public class CustomCanvas {
    private JFrame frame;
    private CustomPanel canvas;

    public CustomCanvas() {
        this.frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        var canvas = new CustomPanel();
        frame.add(canvas);
        frame.pack();
    }
}
