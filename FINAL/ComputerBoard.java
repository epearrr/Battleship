package FINAL;

import java.util.ArrayList;

public class ComputerBoard extends Board {
    public ComputerBoard(String fileName){
        super(fileName);
    }

    public String makePlayerMove(Move move){
        if(super.moveAvailable(move)){
            CellStatus cell = super.applyMoveToLayout(move);
            Fleet fleet = super.getFleet();

            switch(cell){
                case AIRCRAFT_CARRIER: 
                if(fleet.updateFleet(ShipType.ST_AIRCRAFT_CARRIER)){
                    return "You sank my Aircraft Carrier!";
                } return null;
                
                case BATTLESHIP: 
                if(fleet.updateFleet(ShipType.ST_BATTLESHIP)){
                    return "You sank my Battleship!";
                } return null;
                
                case CRUISER: 
                if(fleet.updateFleet(ShipType.ST_CRUISER)){
                    return "You sank my Cruiser!";
                } return null;
                
                case DESTROYER: 
                if(fleet.updateFleet(ShipType.ST_DESTROYER)){
                    return "You sank my Destroyer!";
                } return null;
                
                case SUB: 
                if(fleet.updateFleet(ShipType.ST_SUB)){
                    return "You sank my Sub!";
                } return null;
                
                default: return null;
            }
        }
        return "Move not available!";
    }

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
}
