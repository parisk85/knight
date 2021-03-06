package gr.parisk85.knight.service;

import gr.parisk85.knight.model.Square;

import java.util.LinkedList;
import java.util.List;

public interface Algorithm<T> {
    List<LinkedList<Square>> run();
}
