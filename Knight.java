import java.io.*;
import java.util.*;

public class Knight extends ChessPiece{

    // Gets same arguments from "ChessPiece" object to create "Knight" object
    public Knight(int col, int row, String type, boolean color){

        super(col,row,type,color);

    }

    public boolean canAttack(ChessPiece c, int desCol, int desRow){

        /* Sees if knight is capable of moving to the destination square
        If not, return false. */
        if((Math.abs(desCol-col)==1 && Math.abs(desRow-row)==2)||(Math.abs(desCol-col)==2 && Math.abs(desRow-row)==1)){

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