import Controller.Controller;
import Model.Model;
import Model.LineModel;
import Model.Mode;
import View.ClearButton;
import View.ModeButton;
import View.Window;
import Controller.Controller2D;
import Controller.PolygonController;
import Controller.LineController;
import Controller.HoverController;
import Controller.KeyboardController;
import View.rasterizer.LineRasterizerBresenham;
import View.rasterizer.PolygonRasterizer;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Window window = new Window();

                Model model = new Model(null, new LineModel(), Mode.Line);
                Controller controller = new Controller(model);

                LineRasterizerBresenham lrb = new LineRasterizerBresenham(window.getPanel().getRasterBufferedImage());
                PolygonRasterizer pr = new PolygonRasterizer(lrb);

                Controller2D c2d = new Controller2D(controller, lrb, pr, window.getPanel());
                PolygonController pc = new PolygonController(c2d);
                LineController lc = new LineController(c2d);
                HoverController hc = new HoverController(c2d);
                KeyboardController kc = new KeyboardController(c2d);

                pc.initListeners(window.getPanel());
                lc.initListeners(window.getPanel());
                hc.setInitialDraw();
                hc.initListeners(window.getPanel());
                kc.initListeners(window.getPanel());

                ModeButton mb = new ModeButton(c2d, window.getPanel());
                ClearButton cb = new ClearButton(c2d);

                var p = new JPanel(new FlowLayout(FlowLayout.LEFT));
                p.add(mb);
                p.add(cb);
                window.add(p);
                window.pack();


            }
        });
    }
}