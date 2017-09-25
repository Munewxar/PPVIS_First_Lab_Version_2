package View;

import Controller.Main;

import javax.swing.*;
import java.awt.*;

public class Window {
    private JFrame frame;
    private Image background;

    private JFrame buildFrame(){
        frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setUndecorated(true);

       frame.add(new Main(frame));

        return frame;
    }

    public JFrame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        JFrame mainFrame = new Window().buildFrame();
        mainFrame.setVisible(true);
        System.out.println(mainFrame.getHeight());
        System.out.println(mainFrame.getWidth());
    }
}