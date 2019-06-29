package gr.parisk85.knight.model;

public abstract class Piece implements Chesspiece {
    private Square position;

    public Square getPosition() {
        return position;
    }

    public void setPosition(Square position) {
        this.position = position;
    }
}
