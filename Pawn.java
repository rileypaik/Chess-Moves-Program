import java.io.*;
import java.util.*;

public class Pawn extends ChessPiece{

    // Gets same arguments from "ChessPiece" object to create "Pawn" object
    public Pawn(int col, int row, String type, boolean color){

        super(col,row,type,color);

    }

    public boolean canAttack(ChessPiece c, int desCol, int desRow){

        // For black pawn
        if(Objects.equals(type, "P")){

            // Sees if black pawn is capable of moving to the destination square
            if((Math.abs(col-desCol)==1) && ((row-desRow)==1)){

                // Sees if destination square has piece of opposite color in it
                if(c.col==desCol && c.row==desRow && c.color!=color){
                    return true;
                }

            }

            // Sees if black pawn can move to destination square
            if((desCol==col) && (row-desRow)==1){

                // Sees if destination square is just empty
                if(c.col!=desCol || c.row!=desRow){
                    return true;
                }

            }

        }

        // For white pawn
        if(Objects.equals(type, "p")){

            // Sees if white pawn is capable of attacking destination square
            if((Math.abs(desCol-col)==1) && ((desRow-row)==1)){

                // Sees if destination square has piece of opposite color in it
                if(c.col==desCol && c.row==desRow && c.color!=color){
                    return true;
                }

            }

            // Sees if white pawn can move to destination square
            if((desCol==col) && (desRow-row)==1){

                // Sees if destination square is just empty
                if(c.col!=desCol || c.row!=desRow){
                    return true;
                }

            }

        }

        return false;

    }

}