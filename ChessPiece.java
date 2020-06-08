import java.io.*;
import java.util.*;

/* This is the super class so that all the pieces on the chess board
have their own subclass and attacking function specific to the type.
Boolean true means the color is black and boolean false 
means the color is white. */
public class ChessPiece{

    // Declares variables
    public int col,row;
    public String type;
    public boolean color;
    
    // Creates the ChessPiece object
    public ChessPiece(int col, int row, String type, boolean color){
        
        this.col = col;
        this.row = row;
        this.type = type;
        this.color = color;

    }

    // Dummy function so subclasses can expand off this
    public boolean canAttack(ChessPiece c, int desCol, int desRow){
        return false;
    }

}
