package FINAL;

public class ComputerBoard extends Board {
    public ComputerBoard(String fileName){
        super(fileName);
    }

    public String makePlayerMove(Move move){
        if(super.moveAvailable(move)){
            super.applyMoveToLayout(move);
        }
    }
}
