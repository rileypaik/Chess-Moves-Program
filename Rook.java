import java.io.*;
import java.util.*;

public class Rook extends ChessPiece{

    // Gets same arguments from "ChessPiece" object to create "Rook" object
    public Rook(int col, int row, String type, boolean color){

        super(col,row,type,color);

    }

    public boolean canAttack(ChessPiece c, int desCol, int desRow){

        // Checks if source and current pieces are on the same column as the destination piece
	if (col == desCol){
	    if (c.col == desCol){

                /* To see if the current piece is in between the source and destination pieces, 
                we compare the distance between the source and destination pieces with both the distance 
                between the source and current pieces and also the distance between the destination and 
                current pieces. This ensures that the current piece is in between the source and destination 
                pieces and is blocking the path. */
		if(Math.abs(row-desRow)>Math.abs(c.row-desRow) &&  Math.abs(row-desRow)>Math.abs(c.row-row)){ // && c.color==color){
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

        /// Checks if source and current pieces are on the same row as the destination piece
        if(row == desRow){ 
	    if (c.row == desRow){

                /* To see if the current piece is in between the source and destination pieces, 
                we compare the distance between the source and destination pieces with both the distance 
                between the source and current pieces and also the distance between the destination and 
                current pieces. This ensures that the current piece is in between the source and destination 
                pieces and is blocking the path. */
		if(Math.abs(col-desCol)>Math.abs(c.col-desCol) &&  Math.abs(col-desCol)>Math.abs(c.col-col)){
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
