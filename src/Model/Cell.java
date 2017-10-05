package Model;

import java.awt.*;

public class Cell {

    private Image image;
    private boolean isFree;
    private int type;
    private int coordinateX;
    private int coordinateY;

    public Cell(Image image, boolean isFree, int type, int coordinateX, int coordinateY){
        this.image = image;
        this.isFree = isFree;
        this.type = type;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    Cell(){}

    public Image getImage() {
        return image;
    }

    public boolean isFree() {
        return isFree;
    }

    public int getType(){
        return type;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setFree(boolean isFree) {
        this.isFree = isFree;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }
}
