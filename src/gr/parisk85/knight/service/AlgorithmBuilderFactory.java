package gr.parisk85.knight.service;

import gr.parisk85.knight.exception.UnknownAlgorithmException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AlgorithmBuilderFactory {
    private static final Map<String, AlgorithmBuilder> algorithmMap = new HashMap<>();

    static {
        algorithmMap.put("BFS", new BreadthFirstSearchBuilder());
    }

    public static AlgorithmBuilder getBuilder(String algorithmName) throws UnknownAlgorithmException {
        return Optional.ofNullable(algorithmName)
                .map(a -> algorithmMap.get(algorithmName))
                .orElseThrow(UnknownAlgorithmException::new);
    }
}
