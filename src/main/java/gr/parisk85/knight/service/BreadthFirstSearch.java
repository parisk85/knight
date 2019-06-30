package gr.parisk85.knight.service;

import gr.parisk85.knight.model.Chessboard;
import gr.parisk85.knight.model.Square;

import java.util.*;

public class BreadthFirstSearch implements Algorithm {
    private Chessboard chessboard;
    private Square destination;
    private int maxSteps;

    public Chessboard getChessboard() {
        return chessboard;
    }

    public void setChessboard(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public Square getDestination() {
        return destination;
    }

    public void setDestination(Square destination) {
        this.destination = destination;
    }

    public int getMaxSteps() {
        return maxSteps;
    }

    public void setMaxSteps(int maxSteps) {
        this.maxSteps = maxSteps;
    }

    @Override
    public List<LinkedList<Square>> run() {
        List<LinkedList<Square>>
                result = new ArrayList<>();
        Queue<LinkedList<Square>> paths = new ArrayDeque<>();

        LinkedList<Square> path = new LinkedList<>();
        path.add(chessboard.getPiece().getPosition());
        paths.add(path);

        while (!paths.isEmpty()) {
            path = paths.poll();
            Square testSquare = path.peekLast();

            if (testSquare.equals(destination)) {
                result.add(path);
            }

            for (Square moveDist : chessboard.getPiece().getAllowedMovesList()) {
                Square nextSquare = Square.valueOf(testSquare.getX() + moveDist.getX(), testSquare.getY() + moveDist.getY());
                if (chessboard.isValidPosition(nextSquare) && !path.contains(nextSquare) && path.size() < maxSteps + 1) {
                    LinkedList<Square> newPath = new LinkedList<>();
                    newPath.addAll(path);
                    newPath.add(nextSquare);
                    paths.add(newPath);
                }
            }
        }

        return result;
    }
}
