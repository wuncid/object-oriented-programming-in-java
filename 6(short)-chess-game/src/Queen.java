// Override the isValidMove method in the Queen class.
// First call the parent's isValidMove to check for the boundaries
// Add more code to check for the queen's specific move validity

/**
 * Models a Queen with valid movements.
 */
public class Queen extends Piece {


    boolean isValidMove(Position newPosition) {
        // checks if the new position is on the game board
        if (!super.isValidMove(position)) {
            return false;
        }

        // checks if the new move is valid for the queen
        else if (Math.abs(newPosition.column - this.position.column) == Math.abs(newPosition.row - this.position.row)
                || newPosition.column == this.position.column || newPosition.row == this.position.row){
            return true;
        }

        else {
            return false;
        }
    }
}
