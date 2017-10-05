package Controller;

import Model.Cell;
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
    private static final int UP = 4;
    private static final int DOWN = 5;

    private static final int SUCCESS = 0;
    private static final int FAIL = -1;

    private static final int TILE_SIDE_SIZE = 64;

    private static final int STAIRS = 2;
    private static final int FLOOR = 1;
    private static final int BOOK = 3;
    private static final int EMPTY = 0;
    private static final int DOOR = 4;

    private int bookCounter = 11;

    private Map map;

    private Image playerImage;

    Player(Map map){
        this.map = map;

        playerImage = new ImageIcon("Zhen.jpg").getImage();
    }

    void move(int direction){

        switch(direction){

            case LEFT:
                pX -= SPEED;
                break;

            case RIGHT:
                pX += SPEED;
                break;

            case UP:
                pY -= SPEED;
                break;

            case DOWN:
                pY += SPEED;
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
            checkBook();
        }

        if (key == KeyEvent.VK_D){
            if (checkCollisions(RIGHT) == SUCCESS)
                move(RIGHT);
            checkBook();
        }

        if (key == KeyEvent.VK_W){
            if (checkCollisions(UP) == SUCCESS)
                move(UP);
            checkBook();
        }

        if (key == KeyEvent.VK_S){
            if (checkCollisions(DOWN) == SUCCESS)
                move(DOWN);
        }

    }

    private void checkBook(){

        if (map.getCell(pX, pY).getType() == BOOK) {
            bookCounter--;
            map.getMap().get(pY / TILE_SIDE_SIZE).set(pX / TILE_SIDE_SIZE, new Cell(null, true, EMPTY,
                    pX, pY));
        }

    }

    void keyReleased(KeyEvent e){
        move(-1);
    }

    private int checkCollisions (int direction){

        switch(direction){

            case LEFT:

                if (map.getCell(pX - TILE_SIDE_SIZE, pY).isFree()){
                    return SUCCESS;
                }else {
                    return FAIL;
                }

            case RIGHT:

                if (map.getCell(pX, pY).getType() == DOOR && checkCounter()){
                    System.exit(0);
                }

                if (map.getCell(pX + TILE_SIDE_SIZE, pY).isFree()){
                    return SUCCESS;
                }else {
                    return FAIL;
                }

            case UP:

                if (map.getCell(pX, pY).getType() == STAIRS){
                    return SUCCESS;
                }else {
                    return FAIL;
                }

            case DOWN:
                if (map.getCell(pX, pY + TILE_SIDE_SIZE).isFree() &&
                        map.getCell(pX, pY + TILE_SIDE_SIZE).getType() != FLOOR){
                    return SUCCESS;
                }else {
                    return FAIL;
                }

            default:
                break;
        }

        return FAIL;
    }

    private boolean checkCounter(){
        if (bookCounter == 0){
            return true;
        }else{
            return false;
        }
    }

    void fall (){

        if(map.getCell(pX, pY + TILE_SIDE_SIZE).isFree() &&
                map.getCell(pX, pY).getType() != STAIRS &&
                map.getCell(pX, pY + TILE_SIDE_SIZE).getType() != STAIRS)
            move(DOWN);
        checkBook();

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

    public int getBookCounter(){
        return bookCounter;
    }
}
