package View;

import javax.swing.*;

public class Window extends JFrame {
    private final Panel panel;

    public Window() {
        panel = new Panel();
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hána PGRF1 p1");
        add(panel);
        setVisible(true);
        pack();

        panel.setFocusable(true);
        panel.grabFocus();
    }

    public Panel getPanel() {
        return panel;
    }
}
