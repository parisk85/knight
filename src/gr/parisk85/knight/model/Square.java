package gr.parisk85.knight.model;

import java.util.Objects;

public final class Square {
    private final int x;
    private final int y;

    private Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Square valueOf(int x, int y) {
        return new Square(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        if (x != square.x) return false;
        return y == square.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Square{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
