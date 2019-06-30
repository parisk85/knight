package gr.parisk85.knight.service;

import gr.parisk85.knight.model.Chessboard;
import gr.parisk85.knight.model.Square;

public class BreadthFirstSearchBuilder implements AlgorithmBuilder {
    private BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();

    public BreadthFirstSearchBuilder setChessboard(Chessboard chessboard) {
        breadthFirstSearch.setChessboard(chessboard);
        return this;
    }

    @Override
    public AlgorithmBuilder setDestination(Square destination) {
        breadthFirstSearch.setDestination(destination);
        return this;
    }

    @Override
    public AlgorithmBuilder setMaxSteps(int maxSteps) {
        breadthFirstSearch.setMaxSteps(maxSteps);
        return this;
    }

    @Override
    public Algorithm build() {
        Algorithm algorithm = breadthFirstSearch;
        breadthFirstSearch = new BreadthFirstSearch();
        return algorithm;
    }
}
