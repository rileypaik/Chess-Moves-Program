import java.io.*;
import java.util.*;

public class LinkedList{

    // Declare variable
    static Node head;

    // Clears linked list
    public static void clear(){

        head = null;

    }

    // Inserts chess pieces into linked list
    public static void insert(ChessPiece p){
        
        Node newHead = new Node(p);
        newHead.next = head;
        head = newHead;
    
    }

    // Sees if the source piece can move to the destination piece's square
    public static boolean canMove(int turn, int sorCol, int sorRow, int desCol, int desRow){

        // Declare Node variables
        Node source = head;
        Node dest = head;
        Node c = head;

        // Goes through linked list to look for the source piece
        while(source != null){
            
            // If source piece is found, break from loop
            if(source.p.col==sorCol && source.p.row==sorRow){
                break;
            } else{
                source = source.next;
            }

        }

        // If there is no source piece, return false
        if(source == null){
            return false;
        }

        /* Declares and initializes boolean variables to see if the source piece's
        type is uppercase or lowercase. */
        boolean hasUpperCase = !source.p.type.equals(source.p.type.toLowerCase());
        boolean hasLowerCase = !source.p.type.equals(source.p.type.toUpperCase());

        // If it's white's turn, but the source piece is black, return false
        if(((turn%2)!=0) && hasUpperCase){ 
	    return false;
        }
        
        // If it's black's turn, but the source piece is white, return false
	if(((turn%2)==0) && hasLowerCase){ 
	    return false;
        } 
        
        // Goes through linked list to look for destination piece
        while(dest != null){

            // If destination piece is found, break from loop
            if(dest.p.col==desCol && dest.p.row==desRow){
                break;
            } else{
                dest = dest.next;
            }
        }

        /* Each chess piece has a "canAttack" function to see if the source piece is capable of moving to
        the destination piece's square. It does this by seeing if there is a piece in the destination square
        of the opposite color or if the destination square is empty. For bishops, rooks, and queens, 
        the "canAttack" functions also check if there are pieces blocking the path between the source and 
        destination pieces. */
        while(c != null){
            if(c!=source && !source.p.canAttack(c.p,desCol,desRow)){
                return false;
            }
            c = c.next;
        }

        /* If the destination square is empty, the source piece moves to the destination
        square and returns true. */
        if(dest == null){
            source.p.col = desCol;
            source.p.row = desRow;
            return true;
        }

        /* If the source piece can attack the destination piece, the source piece captures
	the destination piece, so it takes the destination piece's coordinates and the destination piece is
        removed from the linked list. */
        source.p.col = desCol;
        source.p.row = desRow;
        delete(dest.p);
        return true;

    }

    // Goes through linked list and deletes chess piece that matches the node in linked list
    public static void delete(ChessPiece dest) {
        
        // Declare Node variables
	Node piece = null;
        Node c = head;
        
        // Run loop to find the node for the chess piece that needs to be deleted
	while (c!=null && c.p!=dest){
	    piece = c;
            c = c.next;
        }

        // If "p" is still null after the while loop, that means the head needs to be deleted
	if(piece == null){
            head = head.next;
        } else{
            piece.next = c.next;
        }

    }

    public static boolean inCheck(int turn){

        // Declare Node variables
        Node wK = head;
        Node bK = head;
        Node c = head;

        /* The white king version of "inCheck" only runs if the source piece was white prior
        in the "canMove" function. */
        if((turn%2) != 0){
            
            /* Goes through all pieces to see if it's a white king. If white king, it is already equal to
            "wK" so break. */
            while(wK != null){
                if(Objects.equals(wK.p.type,"k")){
                    break;
                } else{
                    wK = wK.next;
                }
            }

            // Sees if any black piece in the linked list puts the white king in check by calling "checked"
            while(c != null){
                if(c.p.color!=wK.p.color && checked(wK.p.col,wK.p.row,c.p)){
                    return true;
                } else{
                    c = c.next;
                }
            }

        }

        /* The black king version of "inCheck" only runs if the source piece was black prior
        in the "canMove" function. */
        if((turn%2) == 0){

            /* Goes through all pieces to see if it's a black king. If black king, it is already equal to
            "bK" so break. */
            while(bK != null){
                if(Objects.equals(bK.p.type,"K")){
                    break;
                } else{
                    bK = bK.next;
                }
            }

            // Sees if any white piece in the linked list puts the black king in check by calling "checked"
            while(c != null){
                if(c.p.color!=bK.p.color && checked(bK.p.col,bK.p.row,c.p)){
                    return true;
                } else{
                    c = c.next;
                }
            }

        }

        return false;

    }

    public static boolean checked(int kCol, int kRow, ChessPiece threat){

        /* Sees if threat piece is capable of attacking the king and goes through each piece
        in the linked list and calls "canAttack" to see if it blocks the threat piece's path. */
        Node c = head;
        while(c != null){
            if(c.p!=threat && !threat.canAttack(c.p,kCol,kRow)){
                return false;
            }
            c = c.next;
        }
        return true;

    }

}
