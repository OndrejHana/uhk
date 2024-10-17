package View;

import Controller.Controller2D;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModeButton extends JButton {

    public ModeButton(Controller2D controller, Panel panel) {
        setText(controller.getController().getMode().toString() + " mode");
        this.addActionListener(e -> {
            var c = controller.getController();
            c.switchMode();
            setText(c.getMode().toString() + " mode");
            controller.clear();
            controller.draw();
            panel.grabFocus();
        });
    }
}
