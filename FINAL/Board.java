package FINAL;

import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<CellStatus>> layout;
    private Fleet fleet;
    public static final int SIZE = 100;

    public Board(String s){
        layout = new ArrayList<>();

        // fill every cell in layout with CellStatus.NOTHING
        for(int i=0; i<Math.sqrt(SIZE); i++){
            ArrayList<CellStatus> rowList = new ArrayList<CellStatus>();
            for(int j=0; j<Math.sqrt(SIZE); j++){
                rowList.add(CellStatus.NOTHING);
            }
            layout.add(rowList);
        }

        fleet = new Fleet();
    }
}
