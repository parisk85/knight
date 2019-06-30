package gr.parisk85.knight.exception;

public class UnknownAlgorithmException extends Exception {
    public UnknownAlgorithmException() {
        this("Invalid algorithm name");
    }

    public UnknownAlgorithmException(String message) {
        super(message);
    }
}
