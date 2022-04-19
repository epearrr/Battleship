package FINAL;

// tester
public class AAA {
    public static void main(String[] args) {
        CellStatus cs = CellStatus.SUB_HIT;
        System.out.println(cs);

        AircraftCarrier a = new AircraftCarrier();
        Battleship b = new Battleship();
        Cruiser c = new Cruiser();
        Destroyer d = new Destroyer();
        Sub s = new Sub();

        Fleet f = new Fleet(a,b,c,d,s);

        f.updateFleet(ShipType.ST_AIRCRAFT_CARRIER);
    }
}
