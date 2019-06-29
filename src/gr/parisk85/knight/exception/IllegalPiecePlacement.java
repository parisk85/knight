package gr.parisk85.knight.exception;

public class IllegalPiecePlacement extends Exception {
    public IllegalPiecePlacement() {
        this("Piece cannot be placed in this chessboard.");
    }

    public IllegalPiecePlacement(String message) {
        super(message);
    }
}
