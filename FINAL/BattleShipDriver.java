// Ethan Perry
// CS110
// Battleship Final Project

package FINAL;

import java.util.Random;
import java.util.Scanner;

/**
 * Driver class to put all the pieces together and run the game
 */
public class BattleShipDriver {
    public static void main(String[] args) throws InvalidMoveException {
        Game game = new Game();
        Random rand = new Random();
        Scanner kb = new Scanner(System.in);

        System.out.println("Welcome to Battleship!");

        // set turn to either 0 or 1. 0 = player turn, 1 = computer turn
        int turn = rand.nextInt(2);
        if(turn == 0){
            System.out.println("The user won the coin toss and gets to go first.");
        } else System.out.println("The computer won the coin toss and gets to go first.");
        
        // the game will continue as long as neither player has been defeated
        while(!game.userDefeated() && !game.computerDefeated()){
            // turn == 0 indicates it's the player's turn
            if(turn == 0){
                boolean validMove = false;
                String moveStr = "";
                // prompt the user for a move until a valid one of provided
                while(!validMove){
                    System.out.print("Your turn: ");
                    moveStr = kb.nextLine();
                    try{
                        Move move = new Move(moveStr.toUpperCase());
                        validMove = true;
                    }
                    catch(InvalidMoveException e){
                        System.out.println("Invalid move! Make sure your move is less than J10 and try again.");
                    }
                }
                // if the move sunk a ship, moveMessage will be "You sunk my <ship>!". otherwise, it will equal null
                String moveMessage = game.makePlayerMove(moveStr);
                if(moveMessage != null){
                    System.out.println(moveMessage);
                }
                // set turn to 1 so that the next turn will be the computer's
                turn = 1;
            }
            else{
                System.out.print("Computer's turn. Press Enter to continue.\n");
                kb.nextLine();

                System.out.println(String.format("Computer Chose: %s \n", game.makeComputerMove()[0]));
                turn = 0;
            }
            // print the boards
            System.out.println(game);
        }
        // display who won the game
        if(game.userDefeated()){
            System.out.println("The Computer Wins!");
        } else if(game.computerDefeated()){
            System.out.println("The Player Wins!");
        }

        kb.close();
    }
}
