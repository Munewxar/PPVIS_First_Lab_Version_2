package View;

import Controller.Main;

import javax.swing.*;

public class Window {
    private JFrame frame;

    private JFrame buildFrame(){
        frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setUndecorated(true);

       frame.add(new Main(frame));

        return frame;
    }

    public static void main(String[] args) {
        JFrame mainFrame = new Window().buildFrame();
        mainFrame.setVisible(true);
        System.out.println(mainFrame.getHeight());
        System.out.println(mainFrame.getWidth());
    }
}