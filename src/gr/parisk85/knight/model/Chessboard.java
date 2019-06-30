package gr.parisk85.knight.model;

import gr.parisk85.knight.exception.IllegalPiecePlacement;

public class Chessboard {
    private Piece piece;
    private int size;

    public static Chessboard create(int size) {
        return new Chessboard(size);
    }

    private Chessboard(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void place(Piece piece) throws IllegalPiecePlacement {
        if (!isValidPosition(piece.getPosition()))
            throw new IllegalPiecePlacement();
        this.piece = piece;
    }

    public boolean isValidPosition(Square square) {
        return square.getX() >= 0 && square.getY() >= 0 && square.getX() < size && square.getY() < size;
    }
}
