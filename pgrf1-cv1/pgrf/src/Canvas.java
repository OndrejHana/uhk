import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Canvas {
    private JFrame frame;
    private JPanel panel;
    private BufferedImage img;

    public Canvas(int width, int height) {
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Canvas");
        frame.setResizable(false);

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                present(g);
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println( e.getX() + " " + e.getY() );
                drawPixelOnPoint(e.getX(), e.getY());

            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(width, height);

    }

    public void present(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    public void clear() {
        var g = img.getGraphics();
        g.setColor(new Color(0xFF000000, true));
        g.fillRect(0, 0, img.getWidth(), img.getHeight());
    }

    public void drawPixelOnPoint(int x, int y) {
        img.setRGB(x,y, 0xFFFFFF);
    }

    public void drawLine(int x1, int x2, int y1, int y2) {
        int temp;
        if (x1 == x2) {
            temp = x1;
        } else {
            temp = Math.abs(x2-x1);
        }

        float k = (float)(y2-y1)/(float)temp;
        var q = y1-k*x1;

        for (int x=x1; x<=x2; x++) {
            var y = Math.round(k*x + q);
            img.setRGB(x,y, 0xFFFFFF);
        }

    }

    public void draw() {
        clear();

        img.setRGB(5, 5 , 0xFFFFFF);

    }

    public void start() {
        draw();
        panel.repaint();
    }
}