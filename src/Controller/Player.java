package Controller;

import Model.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    private int pX = 64;
    private int pY = 832;

    private static final int SPEED = 64;

    private static final int LEFT = 2;
    private static final int RIGHT = 3;

    private static final int SUCCESS = 0;
    private static final int FAIL = -1;

    private static final int TILE_SIDE_SIZE = 64;

    private JFrame frame;
    private Map map;

    private Image playerImage;

    Player(JFrame frame, Map map){
        this.frame = frame;
        this.map = map;

        playerImage = new ImageIcon("p.png").getImage();
    }

    void move(int direction){

        switch(direction){
            case LEFT:
                pX -= SPEED;
                break;
            case RIGHT:
                pX += SPEED;
                break;
            default:
                break;

        }
    }

    void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A){
            if(checkCollisions(LEFT) == SUCCESS)
            move(LEFT);
        }

        if (key == KeyEvent.VK_D){
            if (checkCollisions(RIGHT) == SUCCESS)
            move(RIGHT);
        }
    }

    void keyReleased(KeyEvent e){
        move(-1);
    }

    private int checkCollisions(int direction){

        switch(direction){

            case LEFT:

                if (map.getCell(pX - TILE_SIDE_SIZE, pY).isFree()){
                    return SUCCESS;
                }else {
                    return FAIL;
                }

            case RIGHT:

                if (map.getCell(pX + TILE_SIDE_SIZE, pY).isFree()){
                    return SUCCESS;
                }else {
                    return FAIL;
                }

            default:
                break;
        }

        return FAIL;
    }

    int getpX() {
        return pX;
    }

    int getpY() {
        return pY;
    }

    Image getPlayerImage() {
        return playerImage;
    }
}
