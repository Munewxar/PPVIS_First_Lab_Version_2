package Controller;

import Model.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JPanel implements ActionListener {

    private Image backgroundImage = new ImageIcon("background.jpg").getImage();
    private Timer timer = new Timer(20, this);
    private JFrame frame;
    private Map mapObject;

    public Main(JFrame frame){
        this.frame = frame;
        mapObject = new Map();
    }

    public void paint(Graphics g){
        g.drawImage(backgroundImage, 0, 0, frame.getWidth(), frame.getHeight(), null);

        for(int yCounter = 0; yCounter<15; yCounter++){
            for(int xCounter = 0; xCounter<30; xCounter++){
                g.drawImage(mapObject.getMap().get(yCounter).get(xCounter).getImage(),
                        mapObject.getMap().get(yCounter).get(xCounter).getCoordinateX(),
                        mapObject.getMap().get(yCounter).get(xCounter).getCoordinateY(),
                        64, 64, null);
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
