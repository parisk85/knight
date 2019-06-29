package gr.parisk85.knight.model;

public class Knight extends Piece {
    @Override
    public void move(Square position) {
        int newX = this.getPosition().getX() + position.getX();
        int newY = this.getPosition().getY() + position.getY();
        this.setPosition(Square.valueOf(newX, newX));
    }
}
