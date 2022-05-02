package FINAL;

import java.util.Random;
import java.util.ArrayList;

/**
 * UserBoard is a Board. This class can be used to make a computer move against this board. The toString method
 * will return a string of the board for the user to view. Because the player knows what their own board looks like,
 * the position of each of the player's ships will be visible on the board.
 */
public class UserBoard extends Board{
    private ArrayList<Move> moves;
    private Random rand;

    /**
     * constructor that calls superconstructor and initializes rand object
     */
    public UserBoard(String fileName) throws InvalidMoveException {
        super(fileName);
        rand = new Random();
    }

    /**
     * method makes a move against the user's board
     * @return array of two strings: the move made by the computer ("E2", "A4", etc.) and a message displaying which ship had been sunk, if any
     */
    public String[] makeComputerMove() throws InvalidMoveException {
        // generates random move
        Move move = generateRandomMove();

        CellStatus cell = super.applyMoveToLayout(move);
        Fleet fleet = super.getFleet();

        // switch statement checks what type of ship was sunk, if any
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
        // returns an array containing the move made by the computer and the message given by the above switch statement
        String[] rtn = {move.toString(), returnMessage};
        return rtn;
    }
    /**
     * Changes the layout's _HIT values to _SUNK values
     * @param st ShipType
     */
    private void updateLayout(ShipType st){
        ArrayList<ArrayList<CellStatus>> layout = super.getLayout();
        // for each row, go through each column and change the CellStatus from a _HIT value to a _SUNK value
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

    /**
     * method that will generate a random move to be played by the computer
     * @return move
     */
    private Move generateRandomMove() throws InvalidMoveException {
        String[] columns = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String[] rows = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        // creates new move using a random column and row
        Move move = new Move(columns[rand.nextInt(10)] + rows[rand.nextInt(10)]);
       
        if(moves != null){
            // while loop to verify the move hasn't already been made
            while(moves.contains(move)){
                move = new Move(columns[rand.nextInt(10)] + rows[rand.nextInt(10)]);
            }
        }
         
        
        // will return a move object from the string in the format of "B2", "E5", etc.
        return move;
    }

    /**
     * toString method that returns the board layout
     * @return string of the board
     */
    @Override
    public String toString(){
        ArrayList<ArrayList<CellStatus>> layout = super.getLayout();
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String userBoard = "";

        userBoard += "USER\n";
        userBoard += "   1  2  3  4  5  6  7  8  9  10\n";

        // generate the board, with each row stating with the appropriate letter
        for(int i = 0; i < Math.sqrt(SIZE); i++){
            userBoard += letters[i] + "  ";
            for(int j = 0; j < Math.sqrt(SIZE); j++){
                userBoard += layout.get(i).get(j).toString().charAt(1) + "  ";
            }
            userBoard += "\n";
        }
        return userBoard;
    }
}
