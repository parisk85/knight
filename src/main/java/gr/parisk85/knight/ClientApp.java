package gr.parisk85.knight;

import gr.parisk85.knight.exception.IllegalPiecePlacement;
import gr.parisk85.knight.exception.UnknownAlgorithmException;
import gr.parisk85.knight.exception.UnknownChesspieceException;
import gr.parisk85.knight.model.Chessboard;
import gr.parisk85.knight.model.Piece;
import gr.parisk85.knight.model.Square;
import gr.parisk85.knight.service.Algorithm;
import gr.parisk85.knight.service.AlgorithmBuilder;
import gr.parisk85.knight.service.AlgorithmBuilderFactory;
import gr.parisk85.knight.service.PieceFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.AbstractCollection;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import static gr.parisk85.knight.Constants.*;

public class ClientApp {
    public static void main(String[] args) throws IOException, IllegalPiecePlacement, UnknownAlgorithmException, UnknownChesspieceException {
        Properties clientProps = loadProperties(PROPERTIES_FILENAME);
        Chessboard chessboard = Chessboard.create(Integer.parseInt(clientProps.getProperty(CHESSBOARD_SIZE)));
        Square startingSquare = Square.valueOf(Integer.parseInt(clientProps.getProperty(SOURCE_X)), Integer.parseInt(clientProps.getProperty(SOURCE_Y)));
        Piece knight = PieceFactory.create(clientProps.getProperty(CHESS_PIECE));
        knight.setPosition(startingSquare);
        chessboard.place(knight);
        Square destSquare = Square.valueOf(Integer.parseInt(clientProps.getProperty(DESTINATION_X)), Integer.parseInt(clientProps.getProperty(DESTINATION_Y)));
        int maxSteps = Integer.valueOf(clientProps.getProperty(MAX_STEPS));
        AlgorithmBuilder builder = AlgorithmBuilderFactory.getBuilder(clientProps.getProperty(ALGORITHM_NAME));
        Algorithm algorithm = builder
                .setChessboard(chessboard)
                .setDestination(destSquare)
                .setMaxSteps(maxSteps)
                .build();
        List<LinkedList<Square>> result = algorithm.run();
        System.out.println(printResults(result));
    }

    private static Properties loadProperties(String propertiesFilename) throws IOException {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        Properties properties = new Properties();
        properties.load(new FileInputStream(rootPath + propertiesFilename));
        return properties;
    }

    private static String printResults(List<LinkedList<Square>> result) {
        return result.stream()
                .findFirst()
                .map(AbstractCollection::toString)
                .orElse("No solution has been found.");
    }
}
