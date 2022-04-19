package FINAL;

public class Fleet {
    private Ship battleShip;
    private Ship aircraftCarrier;
    private Ship cruiser;
    private Ship sub;
    private Ship destroyer;

    public Fleet(Ship battleShip, Ship aircraftCarrier, Ship cruiser, Ship sub, Ship destroyer) {
        this.battleShip = battleShip;
        this.aircraftCarrier = aircraftCarrier;
        this.cruiser = cruiser;
        this.sub = sub;
        this.destroyer = destroyer;
    }

    public boolean updateFleet(ShipType shipType){
        
    }
}
