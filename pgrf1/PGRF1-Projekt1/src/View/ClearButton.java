package View;

import Controller.Controller2D;

import javax.swing.*;

public class ClearButton extends JButton {
    private final Controller2D controller;

    public ClearButton(Controller2D controller) {
        this.controller = controller;
        this.setText("Clear");
        this.addActionListener(e -> controller.clearModel());
    }
}
