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

                //System.out.println(scanner.nextInt());

                switch (scanner.nextInt()){
                    case 0:
                        map.get(ySizeCounter).set(xSizeCounter, new Cell(null, true, EMPTY,
                                xSizeCounter * 64, ySizeCounter * 64));
                        break;

                    case 1:
                        map.get(ySizeCounter).set(xSizeCounter, new Cell(new ImageIcon("floor.png").getImage(),
                                false, FLOOR, xSizeCounter * 64, ySizeCounter * 64));
                        break;

                    case 2:
                        map.get(ySizeCounter).set(xSizeCounter, new Cell(new ImageIcon("stairs.png").getImage(),
                                true, STAIRS, xSizeCounter * 64, ySizeCounter * 64));
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

    public ArrayList<ArrayList<Cell>> getMap() {
        return map;
    }
}
