package Model;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {

    private ArrayList<ArrayList <Cell>> map;

    private static final int EMPTY = 0;
    private static final int FLOOR = 1;
    private static final int STAIRS = 2;
    private static final int BOOK = 3;
    private static final int DOOR = 4;

    private static final int TILE_SIZE = 64;

    public Map(){
        map = new ArrayList<>();
        createArrayList();
        initMap();
    }

    private void createArrayList(){
        for(int yCounter = 0; yCounter < 15; yCounter++)
        {
            map.add(yCounter, new ArrayList<>());

            for (int xCounter = 0; xCounter<30; xCounter++){
                map.get(yCounter).add(xCounter, new Cell());
            }
        }
    }

    private void initMap(){

        try(FileReader reader = new FileReader("map.txt")) {

            int xSizeCounter = 0, ySizeCounter = 0;

            Scanner scanner = new Scanner(reader);

            while (scanner.hasNextInt() && scanner.hasNextLine()){

                switch (scanner.nextInt()){
                    case 0:
                        map.get(ySizeCounter).set(xSizeCounter, new Cell(null, true, EMPTY,
                                xSizeCounter * TILE_SIZE, ySizeCounter * TILE_SIZE));
                        break;

                    case 1:
                        map.get(ySizeCounter).set(xSizeCounter, new Cell(new ImageIcon("floor2.png").getImage(),
                                false, FLOOR, xSizeCounter * TILE_SIZE, ySizeCounter * TILE_SIZE));
                        break;

                    case 2:
                        map.get(ySizeCounter).set(xSizeCounter, new Cell(new ImageIcon("stairs.png").getImage(),
                                true, STAIRS, xSizeCounter * TILE_SIZE, ySizeCounter * TILE_SIZE));
                        break;

                    case 3:
                        map.get(ySizeCounter).set(xSizeCounter, new Cell(new ImageIcon("book.png").getImage(),
                                true, BOOK, xSizeCounter * TILE_SIZE, ySizeCounter * TILE_SIZE));
                        break;

                    case 4:
                        map.get(ySizeCounter).set(xSizeCounter, new Cell(new ImageIcon("door.png").getImage(),
                                true, DOOR, xSizeCounter * TILE_SIZE, ySizeCounter * TILE_SIZE));
                        break;

                    default:
                        break;
                }

                if(xSizeCounter<29){
                    xSizeCounter++;
                }else{
                    ySizeCounter++;
                    xSizeCounter = 0;
                }

            }
        }catch (IOException e){
            System.out.println("READING ERROR!");
            System.exit(2);
        }
    }

    public Cell getCell(int mapX, int mapY){

        for (int yCounter = 0; yCounter < 15; yCounter++){
            for (int xCounter = 0; xCounter < 30; xCounter++){
                if(map.get(yCounter).get(xCounter).getCoordinateX() == mapX &&
                        map.get(yCounter).get(xCounter).getCoordinateY() == mapY )
                    return map.get(yCounter).get(xCounter);
            }
        }

        return null;
    }

    public ArrayList<ArrayList<Cell>> getMap() {
        return map;
    }
}
