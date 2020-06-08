import java.io.*;
import java.util.*;

public class ChessMoves{

    // Declare variables
    static int col, row, count, turn, sorCol, sorRow, desCol, desRow;
    static String l, qp;
    public static void main(String[] args) throws IOException{

        // Opens files
        Scanner in = new Scanner(new File (args[0]));
        PrintWriter out = new PrintWriter(new FileWriter(args[1]));
        
        // Keeps running loop while input file has another line to read
        while(in.hasNextLine()){

            // Sets "l" equal to next line in input file
            l = in.nextLine();

            // Splits line "l" where there is a colon and space following it
            String[] token = l.split(": ");

            // Splits the line with the pieces into separate lines (one piece per line)
            String[] plyrs = token[0].split("\\s+");

            /* Adds pieces from String array "plyrs" to linked list and stores their
            column, row, type, and color. */
            for(int i=0; i<plyrs.length; i+=3){

            	col = Character.getNumericValue(plyrs[i+1].charAt(0));
                row = Character.getNumericValue(plyrs[i+2].charAt(0));
                qp = plyrs[i];

                if(Objects.equals(qp, "K")){
			LinkedList.insert(new King(col,row,"K",true));
		}
		if(Objects.equals(qp, "k")){
			LinkedList.insert(new King(col,row,"k",false));
		}
		if(Objects.equals(qp, "Q")){
			LinkedList.insert(new Queen(col,row,"Q",true));
		}
		if(Objects.equals(qp, "q")){
			LinkedList.insert(new Queen(col,row,"q",false));
		}
		if(Objects.equals(qp, "R")){
			LinkedList.insert(new Rook(col,row,"R",true));
		}
		if(Objects.equals(qp, "r")){
			LinkedList.insert(new Rook(col,row,"r",false));
		}
		if(Objects.equals(qp, "B")){
			LinkedList.insert(new Bishop(col,row,"B",true));
		}
		if(Objects.equals(qp, "b")){
			LinkedList.insert(new Bishop(col,row,"b",false));
		}
		if(Objects.equals(qp, "N")){
			LinkedList.insert(new Knight(col,row,"N",true));
		}
		if(Objects.equals(qp, "n")){
			LinkedList.insert(new Knight(col,row,"n",false));
		}
		if(Objects.equals(qp, "P")){
			LinkedList.insert(new Pawn(col,row,"P",true));
		}
		if(Objects.equals(qp, "p")){
			LinkedList.insert(new Pawn(col,row,"p",false));
		}
			
            }

            /* Initialize and declare the increments "count" and "turn" to help decide
            if the source piece can move and whether the moves are legal. */
            count = 0;
            turn = 1;

            // Splits the line with the moves into separate lines (one column/row on each line)
            String[] moves = token[1].split("\\s+");

            for(int i=0; i<moves.length; i+=4){

                // Initializes the columns/rows for each move
                sorCol = Character.getNumericValue(moves[i].charAt(0));
                sorRow = Character.getNumericValue(moves[i+1].charAt(0));
                desCol = Character.getNumericValue(moves[i+2].charAt(0));
                desRow = Character.getNumericValue(moves[i+3].charAt(0));

                /* Sees if the source piece can move to the destination piece
                If so, see if the move put the king in check. If not, print the coordinates
                of the move and "illegal". */
                if(LinkedList.canMove(turn, sorCol, sorRow, desCol, desRow)){

                    /* Sees if the move put the king of the source piece's color in check
                    If so, print the coordinates of the move and "illegal". If not, add 
                    4 to count and 1 to turn to switch turns. */
                    if(!LinkedList.inCheck(turn)){
                        count = count + 4;
                        turn++; 
                    } else{
                        out.println(sorCol+" "+sorRow+" "+desCol+" "+desRow+" illegal");
                        break;
                    } 

                } else{
                    out.println(sorCol+" "+sorRow+" "+desCol+" "+desRow+" illegal");
                    break;
                }

            }

            // If all the moves are complete and they are all legal, print "legal"
            if(count == moves.length){
                out.println("legal");
            }

            // Clear linked list for next input line
            LinkedList.clear();

        }

        // Close files
        in.close();
        out.close();

    }

}
