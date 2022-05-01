package FINAL;

import java.util.Random;
import java.util.Scanner;

public class BattleShipDriver {
    public static void main(String[] args) throws InvalidMoveException {
        Game game = new Game();
        Random rand = new Random();
        Scanner kb = new Scanner(System.in);

        System.out.println("Welcome to Battleship!");

        // set turn to either 0 or 1. 0 = player turn, 1 = computer turn
        int turn = rand.nextInt(1);
        if(turn == 0){
            System.out.println("The user won the coin toss and gets to go first.");
        } else System.out.println("The computer won the coin toss and gets to go first.");
        
        while(!game.userDefeated() && !game.computerDefeated()){
            if(turn == 0 || turn == 1){
                System.out.println("Your turn: ");
                Move move = new Move(kb.nextLine());
                System.out.println("Move is " + move);
            }
        }
    }
}
