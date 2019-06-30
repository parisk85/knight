package gr.parisk85.knight.service;

import gr.parisk85.knight.model.Chessboard;
import gr.parisk85.knight.model.Knight;
import gr.parisk85.knight.model.Square;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BreadthFirstSearchTest {
    private Chessboard chessboard;
    private Square source;
    private Square destination;
    private int maxSteps;
    private BreadthFirstSearchBuilder builder;

    private BreadthFirstSearch tester;

    @Before
    public void setup() {
        chessboard = Chessboard.create(8);
        source = Square.valueOf(0, 0);
        maxSteps = 3;
        Knight knight = new Knight();
        knight.setPosition(source);
        chessboard.setPiece(knight);
        builder = new BreadthFirstSearchBuilder();
    }

    @Test
    public void testHappyPathWithOneMove() {
        destination = Square.valueOf(2, 1);
        buildTester(destination);

        List<LinkedList<Square>> routes = new ArrayList<>();
        LinkedList<Square> expected = new LinkedList<>();
        expected.add(source);
        expected.add(destination);
        routes.add(expected);

        List<LinkedList<Square>> resultRoutes = tester.run();
        LinkedList<Square> actual = resultRoutes.get(0);

        org.junit.Assert.assertEquals(actual, expected);
    }

    @Test
    public void testHappyPathWithTwoMoves() {
        destination = Square.valueOf(4, 0);
        buildTester(destination);

        List<LinkedList<Square>> routes = new ArrayList<>();
        LinkedList<Square> expected = new LinkedList<>();
        expected.add(source);
        expected.add(Square.valueOf(2, 1));
        expected.add(destination);
        routes.add(expected);

        List<LinkedList<Square>> resultRoutes = tester.run();
        LinkedList<Square> actual = resultRoutes.get(0);

        org.junit.Assert.assertEquals(actual, expected);
    }

    @Test
    public void testHappyPathWithThreeMoves() {
        destination = Square.valueOf(6, 1);
        buildTester(destination);

        List<LinkedList<Square>> routes = new ArrayList<>();
        LinkedList<Square> expected = new LinkedList<>();
        expected.add(source);
        expected.add(Square.valueOf(2, 1));
        expected.add(Square.valueOf(4, 0));
        expected.add(destination);
        routes.add(expected);

        List<LinkedList<Square>> resultRoutes = tester.run();
        LinkedList<Square> actual = resultRoutes.get(0);

        org.junit.Assert.assertEquals(actual, expected);
    }

    @Test
    public void testWhereSourceAndDestinationAreEqual() {
        destination = Square.valueOf(0, 0);
        buildTester(destination);

        List<LinkedList<Square>> routes = new ArrayList<>();
        LinkedList<Square> expected = new LinkedList<>();
        expected.add(Square.valueOf(0, 0));
        routes.add(expected);

        List<LinkedList<Square>> resultRoutes = tester.run();
        LinkedList<Square> actual = resultRoutes.get(0);

        assertThat(resultRoutes).hasSize(1);
        assertThat(actual).containsOnly(expected.peek());
    }

    @Test
    public void testUnreachableSquare() {
        destination = Square.valueOf(1, 1);
        buildTester(destination);

        List<LinkedList<Square>> resultRoutes = tester.run();

        assertThat(resultRoutes).hasSize(0);
    }

    private void buildTester(Square destination) {
        tester = (BreadthFirstSearch) builder
                .setChessboard(chessboard)
                .setDestination(destination)
                .setMaxSteps(maxSteps)
                .build();
    }
}
