package gr.parisk85.knight.service;

import gr.parisk85.knight.exception.UnknownChesspieceException;
import gr.parisk85.knight.model.Knight;
import gr.parisk85.knight.model.Piece;
import gr.parisk85.knight.enums.PieceType;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PieceFactory {
    private static final Map<String, Piece> pieceMap = new HashMap<>();

    static {
        pieceMap.put(PieceType.KNIGHT.name(), new Knight());
    }

    public static Piece create(String pieceType) throws UnknownChesspieceException {
        return Optional.ofNullable(pieceType)
                .map(p -> pieceMap.get(pieceType.toUpperCase()))
                .orElseThrow(UnknownChesspieceException::new);
    }
}
