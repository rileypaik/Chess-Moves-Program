import java.io.*;
import java.util.*;

public class King extends ChessPiece{

    // Gets same arguments from "ChessPiece" object to create "King" object
    public King(int col, int row, String type, boolean color){

        super(col,row,type,color);

    }

    public boolean canAttack(ChessPiece c, int desCol, int desRow){

        /* Sees if king is capable of moving to the destination square
        If not, return false. */
        if((col==desCol)&&(Math.abs(row-desRow)==1) || (Math.abs(col-desCol)==1)&&(row==desRow) || (Math.abs(col-desCol)==1)&&(Math.abs(row-desCol)==1)){
            
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
