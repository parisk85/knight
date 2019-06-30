package gr.parisk85.knight.model;

import java.util.List;

public class Knight extends Piece {
    public Knight() {
        super();
        allowedMovesList.add(Square.valueOf(2, -1));
        allowedMovesList.add(Square.valueOf(2, 1));
        allowedMovesList.add(Square.valueOf(-2, 1));
        allowedMovesList.add(Square.valueOf(-2, -1));
        allowedMovesList.add(Square.valueOf(1, -2));
        allowedMovesList.add(Square.valueOf(1, 2));
        allowedMovesList.add(Square.valueOf(-1, 2));
        allowedMovesList.add(Square.valueOf(-1, -2));
    }

    @Override
    public List<Square> getAllowedMovesList() {
        return allowedMovesList;
    }
}
