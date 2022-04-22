package FINAL;

public class Move {
    private int col;
    private int row;

    /**
     * constructor that creates a new move when given two ints as parameters
     * @param col
     * @param row
     */
    public Move(int col, int row){
        this.col = col;
        this.row = row;
    }

    /**
     * constructor that creates a new move when given a string such as E2 as a parameter
     * @param s
     */
    public Move(String s){
        try{
            col = (int) s.charAt(0) - 65;
            row = Integer.parseInt(s.substring(1)) - 1;  
        }
        catch(NumberFormatException e){
            System.out.println("NumberFormatException: s is " + s);
            System.exit(1);
        }
    }

    /**
     * @return col
     */
    public int col(){
        return col;
    }

    /**
     * @return row
     */
    public int row(){
        return row;
    }

    /**
     * @return a string represented where the move was consisting of a letter in the range A-J followed by a number in the range 1-10
     */
    @Override
    public String toString(){
        // use ASCII values to convert col from an int to a char
        char c = (char) (col + 65);
        return String.format("%c%d", c, row+1);
    }
}
