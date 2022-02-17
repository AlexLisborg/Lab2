import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private CarGroup carGroup;
    private Timer timer;

    // Just a single image, TODO: Generalize

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.magenta);
        // Print an error message in case file is not found with a try/catch block
        this.timer = new Timer(delay, new TimerListener());
        this.timer.start();
        this.carGroup = new CarGroup();
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car: carGroup.getCars()) {
            BufferedImage texture;
            try {
                texture = ImageIO.read(DrawPanel.class.getResourceAsStream(car.getTexture()));
            } catch (IOException ex)
            {
                texture = null;
                ex.printStackTrace();
            }
            g.drawImage(texture,(int)car.getX(), (int)car.getY(), null);
        }
    }

    public CarGroup getCarGroup() {
        return carGroup;
    }


   //DRAWPANEL UPDATE TIMER
    private final int delay = 50;



    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : carGroup.getCars()) {
                car.move();
                // repaint() calls the paintComponent method of the panel
                repaint();
                if (car.getX() > 700) {
                    car.stopEngine();
                    car.setAngle(180);
                    car.startEngine();
                }
                else if (car.getX() < 0) {
                    car.stopEngine();
                    car.setAngle(0);
                    car.startEngine();
                }
            }
        }
    }
}
