package FINAL;

import java.util.Scanner;
import java.util.ArrayList;
// tester
public class AAA {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        // CellStatus cs = CellStatus.SUB_HIT;
        // System.out.println(cs);

        // AircraftCarrier a = new AircraftCarrier();
        // Battleship b = new Battleship();
        // Cruiser c = new Cruiser();
        // Destroyer d = new Destroyer();
        // Sub s = new Sub();

        // Fleet f = new Fleet();
        // System.out.println(f.updateFleet(ShipType.ST_AIRCRAFT_CARRIER));
        // System.out.println(f.updateFleet(ShipType.ST_AIRCRAFT_CARRIER));
        // System.out.println(f.updateFleet(ShipType.ST_AIRCRAFT_CARRIER));
        // System.out.println(f.updateFleet(ShipType.ST_AIRCRAFT_CARRIER));
        // System.out.println(f.updateFleet(ShipType.ST_AIRCRAFT_CARRIER));

        // Move m = new Move(2,6);
        // System.out.println(m.col());
        // System.out.println(m.row());
        // System.out.println(m);

        Board b = new Board("UserBoard.txt");

        ArrayList<ArrayList<CellStatus>> layout = b.getLayout();
        while(true){
            // print board layout
            for(ArrayList<CellStatus> s : layout){
                System.out.println(s);
            }

            System.out.print("Cell: ");
            String move = kb.nextLine();
            System.out.println(b.applyMoveToLayout(new Move(move)));
        }
    }
}
