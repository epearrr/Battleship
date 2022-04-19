package FINAL;

// tester
public class AAA {
    public static void main(String[] args) {
        // CellStatus cs = CellStatus.SUB_HIT;
        // System.out.println(cs);

        // AircraftCarrier a = new AircraftCarrier();
        // Battleship b = new Battleship();
        // Cruiser c = new Cruiser();
        // Destroyer d = new Destroyer();
        // Sub s = new Sub();

        // Fleet f = new Fleet(a,b,c,d,s);
        Fleet f = new Fleet();
        System.out.println(f.updateFleet(ShipType.ST_AIRCRAFT_CARRIER));
        System.out.println(f.updateFleet(ShipType.ST_AIRCRAFT_CARRIER));
        System.out.println(f.updateFleet(ShipType.ST_AIRCRAFT_CARRIER));
        System.out.println(f.updateFleet(ShipType.ST_AIRCRAFT_CARRIER));
        System.out.println(f.updateFleet(ShipType.ST_AIRCRAFT_CARRIER));

        // Move m = new Move(2,6);
        // System.out.println(m.col());
        // System.out.println(m.row());
        // System.out.println(m);

        Board b = new Board("tset");
        
        Board b2 = new Board("tset");
    }
}
