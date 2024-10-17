package View;

import Controller.Controller2D;
import Controller.KeyboardController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModeButton extends JButton {
    private final Controller2D controller;

    public ModeButton(Controller2D controller, Panel panel) {
        this.controller = controller;
        setText(controller.getController().getMode().toString() + " mode");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var c = controller.getController();
                c.switchMode();
                setText(c.getMode().toString() + " mode");
                controller.clear();
                controller.draw();
                panel.grabFocus();
            }
        });
    }
}
