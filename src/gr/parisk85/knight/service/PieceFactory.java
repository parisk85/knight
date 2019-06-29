package gr.parisk85.knight.service;

import gr.parisk85.knight.model.Knight;
import gr.parisk85.knight.model.Piece;
import gr.parisk85.knight.enums.PieceType;

public class PieceFactory {
    public static Piece create(String pieceType) {
        if (pieceType.toUpperCase().equals(PieceType.KNIGHT.name())) {
            return new Knight();
        }
        return null;
    }
}
