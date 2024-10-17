package Controller;


import View.Panel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardController {
    private final Controller2D controller;

    public KeyboardController(Controller2D controller) {
        this.controller = controller;
    }

    public void initListeners(Panel panel) {
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 67) {
                    controller.clearModel();
                }
            }
        });

    }
}
