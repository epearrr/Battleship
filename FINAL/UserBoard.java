package FINAL;

import java.util.Random;
import java.util.ArrayList;

public class UserBoard extends Board{
    private ArrayList<Move> moves;
    private Random rand;

    public UserBoard(String fileName){
        super(fileName);
        rand = new Random();
    }

    public String[] makeComputerMove(){
        Move move = generateRandomMove();

        CellStatus cell = super.applyMoveToLayout(move);
        Fleet fleet = super.getFleet();

        String returnMessage;
        switch(cell){
            case AIRCRAFT_CARRIER: 
            if(fleet.updateFleet(ShipType.ST_AIRCRAFT_CARRIER)){
                updateLayout(ShipType.ST_AIRCRAFT_CARRIER);
                returnMessage = "You sank my Aircraft Carrier!";
            } returnMessage = null;
            break;
            
            case BATTLESHIP: 
            if(fleet.updateFleet(ShipType.ST_BATTLESHIP)){
                updateLayout(ShipType.ST_BATTLESHIP);
                returnMessage = "You sank my Battleship!";
            } returnMessage = null;
            break;
            
            case CRUISER: 
            if(fleet.updateFleet(ShipType.ST_CRUISER)){
                updateLayout(ShipType.ST_CRUISER);
                returnMessage = "You sank my Cruiser!";
            } returnMessage = null;
            break;
            
            case DESTROYER: 
            if(fleet.updateFleet(ShipType.ST_DESTROYER)){
                updateLayout(ShipType.ST_DESTROYER);
                returnMessage = "You sank my Destroyer!";
            } returnMessage = null;
            break;
            
            case SUB: 
            if(fleet.updateFleet(ShipType.ST_SUB)){
                updateLayout(ShipType.ST_SUB);
                returnMessage = "You sank my Sub!";
            } returnMessage = null;
            break;
            
            default: returnMessage = "Move not available!";
            break;
        }
        String[] rtn = {move.toString(), returnMessage};
        return rtn;
    }
    /**
     * Changes the layout's _HIT values to _SUNK values
     * @param st ShipType
     */
    private void updateLayout(ShipType st){
        ArrayList<ArrayList<CellStatus>> layout = super.getLayout();
        for(int i=0; i<Math.sqrt(SIZE); i++){
            for(int j=0; j<Math.sqrt(SIZE); j++){
                if(st.equals(ShipType.ST_AIRCRAFT_CARRIER) && layout.get(i).get(j).equals(CellStatus.AIRCRAFT_CARRIER_HIT)){
                    layout.get(i).set(j, CellStatus.AIRCRAFT_CARRIER_SUNK);
                }
                else if(st.equals(ShipType.ST_BATTLESHIP) && layout.get(i).get(j).equals(CellStatus.BATTLESHIP_HIT)){
                    layout.get(i).set(j, CellStatus.BATTLESHIP_SUNK);
                }
                else if(st.equals(ShipType.ST_CRUISER) && layout.get(i).get(j).equals(CellStatus.CRUISER_HIT)){
                    layout.get(i).set(j, CellStatus.CRUISER_SUNK);
                }
                else if(st.equals(ShipType.ST_DESTROYER) && layout.get(i).get(j).equals(CellStatus.DESTROYER_HIT)){
                    layout.get(i).set(j, CellStatus.DESTROYER_SUNK);
                }
                else if(st.equals(ShipType.ST_SUB) && layout.get(i).get(j).equals(CellStatus.SUB_HIT)){
                    layout.get(i).set(j, CellStatus.SUB_SUNK);
                }
            }
        }
    }

    private Move generateRandomMove(){
        String[] columns = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String[] rows = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        String col = columns[rand.nextInt(10)];
        String row = rows[rand.nextInt(10)];

        // will return a move object from the string in the format of "B2", "E5", etc.
        return new Move(col+row);
    }

    /**
     * toString method that returns the board layout
     * @return string of the board
     */
    @Override
    public String toString(){
        ArrayList<ArrayList<CellStatus>> layout = super.getLayout();
        String userBoard = "";
        for(ArrayList<CellStatus> row : layout){
            for(CellStatus cell : row){
                userBoard += cell.toString().charAt(0) + " ";
            }
            userBoard += "\n";
        }
        return userBoard;
    }
}
