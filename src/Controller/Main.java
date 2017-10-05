package Controller;

import Model.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main extends JPanel implements ActionListener {

    private Image backgroundImage = new ImageIcon("background.jpg").getImage();
    private Timer timer = new Timer(20, this);
    private JFrame frame;
    private Map mapObject;
    private Player player;

    public Main(JFrame frame){
        this.frame = frame;
        mapObject = new Map();
        player = new Player(mapObject);
        timer.start();

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                player.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.keyReleased(e);
            }
        });
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

        g.drawImage(player.getPlayerImage(),
                player.getpX(), player.getpY(),
                64, 64,
                null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.move(-1);
        player.fall();
        repaint();
    }
}
