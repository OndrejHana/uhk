package view;

import javax.swing.*;

public class Window extends JFrame {
    private final Panel panel;

    public Window() {
        panel = new Panel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("idk");
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
