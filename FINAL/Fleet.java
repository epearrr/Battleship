package FINAL;

/**
 * The Fleet class contains 5 fields, one of each ship type. This class can be used to hit ships and determine
 * whether or a not a game is over (all 5 ships have been sunk)
 */
public class Fleet {
    private Ship aircraftCarrier;
    private Ship battleship;
    private Ship cruiser;
    private Ship destroyer;
    private Ship sub;

    /**
     * constructor to initialize the instance variables
     */
    public Fleet() {
        aircraftCarrier = new AircraftCarrier();
        battleship = new Battleship();
        cruiser = new Cruiser();
        destroyer = new Destroyer();
        sub = new Sub();
    }

    /**
     * method that is called when a given shiptype is hit. the ship's hit method will be called, which increments the number of times the ship has been been hit
     * @param st shiptype
     * @return true if the given ship had been sunk
     */
    public boolean updateFleet(ShipType st){
        if(st == ShipType.ST_AIRCRAFT_CARRIER){
            return aircraftCarrier.hit();
        }
        else if(st == ShipType.ST_BATTLESHIP){
            return battleship.hit();
        }
        else if(st == ShipType.ST_CRUISER){
            return cruiser.hit();
        }
        else if(st == ShipType.ST_DESTROYER){
            return destroyer.hit();
        }
        else if(st == ShipType.ST_SUB){
            return sub.hit();
        }
        return false;
    }

    /**
     * @return true if all ships have been sunk
     */
    public boolean gameOver(){
        return aircraftCarrier.getSunk() && battleship.getSunk() && cruiser.getSunk() && destroyer.getSunk() && sub.getSunk();
    }
}
