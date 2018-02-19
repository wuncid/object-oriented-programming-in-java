/**
 * Models a chess piece with valid movements.
 */
public class Piece {
    Position position;

    /**
     * Checks if the move is valid.
     *
     * @param newPosition the new position of the chess piece
     * @return the validity of the move
     */
    boolean isValidMove(Position newPosition) {
        if(newPosition.row >= 0 && newPosition.column >= 0
                && newPosition.row < 8 && newPosition.column < 8){
            return true;
        }
        else {
            return false;
        }
    }
}
