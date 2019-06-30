package gr.parisk85.knight.service;

import gr.parisk85.knight.model.Chessboard;
import gr.parisk85.knight.model.Square;

public interface AlgorithmBuilder {
    AlgorithmBuilder setChessboard(Chessboard chessboard);
    AlgorithmBuilder setDestination(Square destination);
    AlgorithmBuilder setMaxSteps(int maxSteps);
    Algorithm build();
}
