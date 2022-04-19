package FINAL;

public class Fleet {
    private Ship battleShip;
    private Ship aircraftCarrier;
    private Ship cruiser;
    private Ship sub;
    private Ship destroyer;

    /**
     * constructor to initialize the instance variables
     * @param aircraftCarrier
     * @param battleShip
     * @param cruiser
     * @param destroyer
     * @param sub
     */
    public Fleet(Ship aircraftCarrier, Ship battleShip, Ship cruiser, Ship destroyer, Ship sub) {
        this.aircraftCarrier = aircraftCarrier;
        this.battleShip = battleShip;
        this.cruiser = cruiser;
        this.destroyer = destroyer;
        this.sub = sub;
    }

    public boolean updateFleet(ShipType st){
        if(st == ShipType.ST_AIRCRAFT_CARRIER){
            return aircraftCarrier.hit();
        }
        else if(st == ShipType.ST_BATTLESHIP){
            return battleShip.hit();
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
}
