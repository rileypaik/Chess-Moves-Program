import java.io.*;
import java.util.*;

public class Queen extends ChessPiece{

    // Gets same arguments from "ChessPiece" object to create "Queen" object
    public Queen(int col, int row, String type, boolean color){

        super(col,row,type,color);

    }

    /* In this function, we are checking if the Queen can move to the Destination
    square and if ChessPiece curr is blocking the path between the Queen and the 
    Destination square */
    public boolean canAttack(ChessPiece curr, int desCol, int desRow){

        // The variables "col" and "row" by themselves (without the "curr") are the Queen's column and row
	    
        // Checks if ChessPiece curr is in the destination square and has the opposite color (then it's a capture)
        if(curr.col==desCol && curr.row==desRow && curr.color!=color){
            return true;
        }
	    
	// Checks if ChessPiece curr is in the destination square and has the same color 
        // (then ChessPiece curr is blocking the path)
        if(curr.col==desCol && curr.row==desRow && curr.color==color){
            return false;
        }

        // Checks if the Queen and ChessPiece curr are in the same row as the Destination square
        if(row == desRow){ 
		if (curr.row == desRow){

                /* At this point, we know that the Queen, the Destination square, and ChessPiece curr
		are all in the same row. Now we check if ChessPiece curr is blocking the Queen 
		from moving to the Destination square horizontally. */
		    
		/* To ensure that ChessPiece curr is blocking the path between the Queen and Destination 
                square, the number of columns between the Queen and the Destination square (queenCol2desCol) 
                has to be greater than the number of columns between ChessPiece curr and the Destination 
                square (currCol2desCol) as well as the number of columns between Chesspiece curr and 
                the Queen (currCol2queenCol) */
		int queenCol2desCol = Math.abs(col - desCol);
                int currCol2desCol = Math.abs(curr.col - desCol);
                int currCol2queenCol = Math.abs(curr.col - col);

		if(queenCol2desCol > currCol2desCol &&  queenCol2desCol > currCol2queenCol) {
			return false;
                }
                
            } 

            // Chesspiece curr is not blocking the path
            return true;

        }

        // Checks if the Queen and ChessPiece curr are in the same column as the Destination square
	if (col == desCol){
		if (curr.col == desCol){

                /* At this point, we know that the Queen, the Destination square, and ChessPiece curr
		are all in the same column. Now we check if ChessPiece curr is blocking the Queen 
		from moving to the Destination square vertically. */
		    
		/* To ensure that ChessPiece curr is blocking the path between the Queen and Destination 
                square, the number of rows between the Queen and the Destination square (queenRow2desRow) 
                has to be greater than the number of rows between ChessPiece curr and the Destination 
                square (currRow2desRow) as well as the number of rows between Chesspiece curr and the 
                Queen (currRow2queenRow) */
                int queenRow2desRow = Math.abs(row - desRow);
                int currRow2desRow = Math.abs(curr.row - desRow);
                int currRow2queenRow = Math.abs(curr.row - row);

		if(queenRow2desRow > currRow2desRow &&  queenRow2desRow > currRow2queenRow) {
			return false;
                }
                
            } 

            // Chesspiece curr is not blocking the path
            return true;

        }

        // Checks if the Destination square is on the same diagonal as the Queen
        if(Math.abs(desCol-col) == Math.abs(row-desRow)){

            	// Checks if ChessPiece curr is on the same diagonal as the Queen
		if(Math.abs(curr.col-col) == Math.abs(row-curr.row)){

                /* At this point, we know that the Queen, the Destination square, and ChessPiece curr
		are all in the same row. Now we check if ChessPiece curr is blocking the Queen 
		from moving to the Destination square horizontally. */
		    
		/* To ensure that ChessPiece curr is blocking the path between the Queen and Destination 
                square, the number of columns between the Queen and the Destination square (queenCol2desCol) 
                has to be greater than the number of columns between ChessPiece curr and the Destination 
                square (currCol2desCol) as well as the number of columns between Chesspiece curr and 
                the Queen (currCol2queenCol) */
		    
		/* Note, we could have done this check by comparing the rows of the Queen, Destination square,
		and ChessPiece curr instead because we know that the difference between the rows and columns are all the 
		same since ChessPiece curr, Destination square, Queen are on the same diagonal. */
		int queenCol2desCol = Math.abs(col - desCol);
                int currCol2desCol = Math.abs(curr.col - desCol);
                int currCol2queenCol = Math.abs(curr.col - col);

		if(queenCol2desCol > currCol2desCol &&  queenCol2desCol > currCol2queenCol) {
			return false;
                }
                
            } 

            // Chesspiece curr is not blocking the path
            return true;

        }

	// The Queen is incapable of moving to the Destination square
        return false;

    }

}

