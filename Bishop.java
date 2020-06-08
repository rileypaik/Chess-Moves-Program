import java.io.*;
import java.util.*;

public class Bishop extends ChessPiece{

    // Gets same arguments from "ChessPiece" object to create "Bishop" object
    public Bishop(int col, int row, String type, boolean color){

        super(col,row,type,color);

    }

    public boolean canAttack(ChessPiece c, int desCol, int desRow){

        /* Sees if bishop is capable of moving to the destination square
        If not, return false. */
        if((desCol-col)==(row-desRow) || (desCol-col)==(desRow-row)){

            // Checks if current piece is on same diagonal as source piece
	    if((c.col-col)==(row-c.row) || (c.col-col)==(c.row-row)){

                /* We already know the current piece is on the same diagonal as the source piece because we made it to the 
		last "if" statement, so we don't need to compare the columns. To see if the current piece is in between the 
                source and destination pieces, we compare the distance between the source and destination pieces with 
                both the distance between the source and current pieces and also the distance between the destination and 
                current pieces. This ensures that the current piece is in between the source and destination pieces and is blocking the path. */
		if(Math.abs(col-desCol)>Math.abs(c.col-desCol) && Math.abs(col-desCol)>Math.abs(c.col-col)){ 
		    return false;
                }

            }
                
            // Sees if destination square has piece of opposite color in it
            if(c.col==desCol && c.row==desRow && c.color!=color){
                return true;
            }

            // Sees if destination square is just empty
            if(c.col!=desCol || c.row!=desRow){
                return true;
            }

        } 

        return false;

    }

}
