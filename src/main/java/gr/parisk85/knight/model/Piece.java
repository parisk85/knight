package gr.parisk85.knight.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    protected final List<Square> allowedMovesList;

    private Square position;

    protected Piece() {
        allowedMovesList = new ArrayList<>();
    }

    public Square getPosition() {
        return position;
    }

    public void setPosition(Square position) {
        this.position = position;
    }

    public abstract List<Square> getAllowedMovesList();
}
