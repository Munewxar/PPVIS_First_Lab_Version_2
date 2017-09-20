package View;

import javax.swing.*;

public class Window {
    private JFrame frame;

    private JFrame buildFrame(){
        frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setUndecorated(true);

        return frame;
    }

    public JFrame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        JFrame mainFrame = new Window().buildFrame();
        mainFrame.setVisible(true);
    }
}