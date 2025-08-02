import javax.swing.*;
import java.awt.*;

public class CustomPanel extends JPanel {
    public CustomPanel() {
        setLayout(null);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        var g2d = (Graphics2D) g;

        g2d.drawRect(100, 100, 1, 1);
    }
}
