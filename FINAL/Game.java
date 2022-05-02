package FINAL;

public class Game {
    private ComputerBoard computer;
    private UserBoard player;

    /**
     * constructor that initializes the computer and player fields
     * @throws InvalidMoveException
     */
    public Game() throws InvalidMoveException{
        computer = new ComputerBoard("compFleet.txt");
        player = new UserBoard("userFleet.txt");
    }

    /**
     * method that randomly makes a move for the computer
     * @return a string array containing the move made by the computer as well as a message indicating which ship
     * (if any) had been sunk 
     * @throws InvalidMoveException
     */
    public String[] makeComputerMove() throws InvalidMoveException{
        return player.makeComputerMove();
    }

    /**
     * method that makes a move for the player
     * @param s string of the move ("E2", "A9", etc.)
     * @return a string containing the move made by the player
     * @throws InvalidMoveException
     */
    public String makePlayerMove(String s) throws InvalidMoveException {
        return computer.makePlayerMove(new Move(s));
    }

    /**
     * @return true if the computer has lost, false if otherwise
     */
    public boolean computerDefeated(){
        return computer.gameOver();
    }

    /**
     * @return true if the player has lost, false if otherwise
     */
    public boolean userDefeated(){
        return player.gameOver();
    }

    /**
     * @return a string that displays the computer's board as well as the player's board
     */
    @Override
    public String toString(){
        return String.format("%s\n%s", computer.toString(), player.toString());
    }
}
