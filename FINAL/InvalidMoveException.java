package FINAL;

/**
 * An InvalidMoveException will be thrown whenever the user tries to play an invalid move, such as "A13" or "R2".
 */
public class InvalidMoveException extends Exception{
    public InvalidMoveException(String errorMessage){
        super(errorMessage);
    }
}
