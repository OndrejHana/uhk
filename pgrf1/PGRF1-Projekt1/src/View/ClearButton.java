package View;

import Controller.Controller2D;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButton extends JButton {
    private final Controller2D controller;

    public ClearButton(Controller2D controller) {
        this.controller = controller;
        this.setText("Clear");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.clearModel();
            }
        });
    }
}
