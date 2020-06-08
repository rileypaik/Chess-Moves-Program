# Chess Moves Program

- The program determines if a sequence of chess moves is legal.

- Run "make" in a terminal to create "ChessMoves.jar".

- To use the program in a terminal, run the command: java -jar ChessMoves.jar (input file) (output file)

## Input
- The input file has the following format. Each line represents a new board. It begins with a chessboard, given by a sequence of “char column row”, where char is one of k (king), q (queen), r (rook), b (bishop), n (knight), p (pawn). If the character is capitalized, it denotes black pieces, otherwise, the piece is white. Then, there is a colon (‘:’). This is the end of the board. What follows the colon is a sequence of moves.

- For example, a line could look like:  
k 4 4 r 8 2 B 1 1 K 4 7: 8 2 2 2 1 1 3 3  

- There is a white king at column 4 and row 4, a white rook at column 8 and row 2, a black bishop at column 1 and row 1, and a black king at column 4 and row 7. The series of moves is: move the white rook at (8,2) to (2,2), then the black bishop at (1,1) to (3,3).

- The program expects that no pieces will be placed outside of the chessboard, each square will have no more than one piece, and every input board has exactly one king of each color, just like regular chess.

- There can be an unlimited amount of lines in the input file as long as each line follows the format.

## Output
- Each line of the output file corresponds to a line of the input file. On each line, the program either writes "Legal", which means all of the moves are legal, or writes the first/only move in the sequence that is illegal then writes "illegal" after.

- For the example in the Input Section, the output line would look like:  
1 1 3 3 illegal

- Check out the files "input.txt" and "output.txt" for a better understanding regarding the format!
