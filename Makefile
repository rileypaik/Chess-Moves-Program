JAVASRC   = ChessMoves.java LinkedList.java ChessPiece.java Node.java King.java Queen.java Rook.java Bishop.java Knight.java Pawn.java
SOURCES   = README Makefile $(JAVASRC)
MAINCLASS = ChessMoves
CLASSES   = ChessMoves.class LinkedList.class ChessPiece.class Node.class King.class Queen.class Rook.class Bishop.class Knight.class Pawn.class
JARFILE   = ChessMoves.jar

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest
	chmod +x $(JARFILE)

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE)