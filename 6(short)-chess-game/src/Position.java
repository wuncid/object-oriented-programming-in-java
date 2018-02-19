/**
 * Models a position of a chess piece on a chess board.
 */
public class Position {
    int row;
    int column;

    /**
     * Constructs a position.
     *
     * @param r the row position of the chess piece
     * @param c the column position of the chess piece
     */
    Position(int r, int c){
        this.row = r;
        this.column = c;
    }
}
