package FINAL;

public class Game {
    private ComputerBoard computer;
    private UserBoard player;

    public Game(){
        computer = new ComputerBoard("compFleet.txt");
        player = new UserBoard("userFleet.txt");
    }

    public String[] makeComputerMove(){
        return player.makeComputerMove();
    }

    public String makePlayerMove(String s){
        return computer.makePlayerMove(new Move(s));
    }

    public boolean computerDefeated(){
        return computer.gameOver();
    }

    public boolean userDefeated(){
        return player.gameOver();
    }

    @Override
    public String toString(){
        return String.format("%s\n%s", computer.toString(), player.toString());
    }
}
