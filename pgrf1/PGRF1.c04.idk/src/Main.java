import controller.Controller2D;
import controller.HoverController;
import controller.KeyboardController;
import rasterizer.RasterBufferedImage;
import view.Window;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Window window = new Window();
                var controller = new Controller2D(window.getPanel(), window.getPanel().getRasterBufferedImage());
                var hoverController = new HoverController(controller);
                var keyboardController = new KeyboardController(window.getPanel());
                keyboardController.initListeners();
                controller.initListeners(window.getPanel());
                hoverController.initListeners(window.getPanel());
            }
        });
    }
}