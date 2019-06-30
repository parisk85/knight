package gr.parisk85.knight.exception;

public class UnknownChesspieceException extends Exception{
    public UnknownChesspieceException() {
        this("The provided chesspiece is unknown");
    }

    public UnknownChesspieceException(String message) {
        super(message);
    }

}
