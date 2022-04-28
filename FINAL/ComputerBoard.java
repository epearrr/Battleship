package FINAL;

import java.util.ArrayList;

public class ComputerBoard extends Board {
    /**
     * constructor that calls the superconstructor with the given fileName
     * @param fileName
     */
    public ComputerBoard(String fileName){
        super(fileName);
    }

    /**
     * makes a move against the computer's board. if a ship is sunk, the layout values will be changes from _HIT to _SUNK.
     * @param move
     * @return
     */
    public String makePlayerMove(Move move){
        CellStatus cell = super.applyMoveToLayout(move);
        Fleet fleet = super.getFleet();

        switch(cell){
            case AIRCRAFT_CARRIER: 
            if(fleet.updateFleet(ShipType.ST_AIRCRAFT_CARRIER)){
                updateLayout(ShipType.ST_AIRCRAFT_CARRIER);
                return "You sank my Aircraft Carrier!";
            } return null;
            
            case BATTLESHIP: 
            if(fleet.updateFleet(ShipType.ST_BATTLESHIP)){
                updateLayout(ShipType.ST_BATTLESHIP);
                return "You sank my Battleship!";
            } return null;
            
            case CRUISER: 
            if(fleet.updateFleet(ShipType.ST_CRUISER)){
                updateLayout(ShipType.ST_CRUISER);
                return "You sank my Cruiser!";
            } return null;
            
            case DESTROYER: 
            if(fleet.updateFleet(ShipType.ST_DESTROYER)){
                updateLayout(ShipType.ST_DESTROYER);
                return "You sank my Destroyer!";
            } return null;
            
            case SUB: 
            if(fleet.updateFleet(ShipType.ST_SUB)){
                updateLayout(ShipType.ST_SUB);
                return "You sank my Sub!";
            } return null;
            
            default: return "Move not available!";
        }
    }

    /**
     * toString method that returns the board layout
     * @return string of the board
     */
    @Override
    public String toString(){
        ArrayList<ArrayList<CellStatus>> layout = super.getLayout();
        String compBoard = "";
        for(ArrayList<CellStatus> row : layout){
            for(CellStatus cell : row){
                compBoard += cell.toString().charAt(0) + " ";
            }
            compBoard += "\n";
        }
        return compBoard;
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
}
