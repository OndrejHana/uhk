import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class Canvas {

    private JFrame frame;
    private JPanel panel;
    private BufferedImage img;
    private JButton clearButton;

    public Canvas(int width, int height) {
        this.frame = new JFrame();

        this.frame.setLayout(new BoxLayout(this.frame.getContentPane(), BoxLayout.Y_AXIS));
        this.frame.setSize(width, height);
        this.frame.setTitle("kek");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        this.panel = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                present(g);
            }
        };

        this.panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("clicked");
                draw(e.getX(), e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        this.panel.setPreferredSize(new Dimension(width, height));

        this.clearButton = new JButton("clear");

        this.clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });

        this.frame.add(this.clearButton);
        this.frame.add(this.panel);

        this.frame.pack();
        this.frame.setVisible(true);
    }

    public void present(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    public void clear() {
        var gr = this.img.getGraphics();
        gr.setColor(new Color(0x2f2f2f));
        gr.fillRect(0, 0, img.getWidth(), img.getHeight());
        panel.repaint();
    }

    public void draw(int x, int y) {
        img.setRGB(x, y, 0xffffff);
        panel.repaint();
    }

    public void start() {
        this.clear();
    }
}
