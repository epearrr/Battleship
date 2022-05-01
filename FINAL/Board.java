package FINAL;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Board {
    private ArrayList<ArrayList<CellStatus>> layout;
    private Fleet fleet;
    public static final int SIZE = 100;

    /**
     * Constructor that initialies the layout by setting all cells to CellStatus.NOTHING, gets information from a file and adds ships to the layout, and initializes fleet
     * @param fileName
     */
    public Board(String fileName) throws InvalidMoveException{
        String fileLoc = "FINAL/" + fileName;
        layout = new ArrayList<>();

        // fill every cell in layout with CellStatus.NOTHING
        for(int i=0; i<Math.sqrt(SIZE); i++){
            ArrayList<CellStatus> rowList = new ArrayList<CellStatus>();
            for(int j=0; j<Math.sqrt(SIZE); j++){
                rowList.add(CellStatus.NOTHING);
            }
            layout.add(rowList);
        }
        
        // try to read the Board file. if the file wasn't found, the exception will be caught and the program will stop
        try{
            Scanner fileScanner = new Scanner(new File(fileLoc));   
            // read all moves from the file 
            while(fileScanner.hasNext()){
                String moveLine = fileScanner.nextLine();
                String[] moveSplit = moveLine.split(" ");

                Move m1 = new Move(moveSplit[1]);
                Move m2 = new Move(moveSplit[2]);

                // checking which type of ship is being played
                CellStatus status;
                switch(moveSplit[0]){
                    case "A": status = CellStatus.AIRCRAFT_CARRIER;
                    break;
                    case "B": status = CellStatus.BATTLESHIP;
                    break;
                    case "C": status = CellStatus.CRUISER;
                    break;
                    case "D": status = CellStatus.DESTROYER;
                    break;
                    case "S": status = CellStatus.SUB;
                    break;
                    default: status = CellStatus.NOTHING;
                    break;
                }

                // if the ship is placed horizontally
                if(m1.row() == m2.row()){
                    for(int i=m1.col(); i<=m2.col(); i++){
                        layout.get(m1.row()).set(i, status);
                    }
                }

                // if the ship is placaed vertically
                if(m1.col() == m2.col()){
                    for(int i=m1.row(); i<=m2.row(); i++){
                        layout.get(i).set(m1.col(), status);
                    }
                }
            }       
        }
        catch(FileNotFoundException e){
            System.out.println("No file found at " + fileLoc);
            System.exit(0);
        }
        fleet = new Fleet();
    }

    /**
     * method to update the layout when given a move
     * @param move
     * @return the original status of the targeted cell
     */
    public CellStatus applyMoveToLayout(Move move){
        CellStatus cell = layout.get(move.row()).get(move.col());
        if(moveAvailable(move)){
            switch(cell){
                case AIRCRAFT_CARRIER: layout.get(move.row()).set(move.col(), CellStatus.AIRCRAFT_CARRIER_HIT);
                break;
                case BATTLESHIP: layout.get(move.row()).set(move.col(), CellStatus.BATTLESHIP_HIT);
                break;
                case CRUISER: layout.get(move.row()).set(move.col(), CellStatus.CRUISER_HIT);
                break;
                case DESTROYER: layout.get(move.row()).set(move.col(), CellStatus.DESTROYER_HIT);
                break;
                case SUB: layout.get(move.row()).set(move.col(), CellStatus.SUB_HIT);
                break;
                default: layout.get(move.row()).set(move.col(), CellStatus.NOTHING_HIT);
                break;
            }
        }
        return cell;
    }

    /**
     * method that determines if a cell is available for a move
     * @param move
     * @return true/false depending on whether a spot is available
     */
    public boolean moveAvailable(Move move){
        CellStatus cell = layout.get(move.row()).get(move.col());
        
        // the following are all acceptable cells choices, so if any are true, true will be returned
        return 
        cell.equals(CellStatus.NOTHING) ||
        cell.equals(CellStatus.AIRCRAFT_CARRIER) ||
        cell.equals(CellStatus.BATTLESHIP) ||
        cell.equals(CellStatus.CRUISER) ||
        cell.equals(CellStatus.DESTROYER) ||
        cell.equals(CellStatus.SUB);
    }

    /**
     * @return layout
     */
    public ArrayList<ArrayList<CellStatus>> getLayout(){
        return layout;
    }

    /**
     * @return fleet
     */
    public Fleet getFleet(){
        return fleet;
    }

    /**
     * @return true if all ships have sank
     */
    public boolean gameOver(){
        return fleet.gameOver();
    }
}
