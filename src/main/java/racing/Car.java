package racing;

public class Car {

    public static final int BASE_MOVE_POINT = 4;

    private final Position position;
    private final CarName carName;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.position = new Position();
    }

    public void move(int movePoint) {
        if (movePoint < BASE_MOVE_POINT) {
            return;
        }
        position.move();
    }

    public void move(MoveStrategy moveStrategy) {
        if (!moveStrategy.isMoving()) return;

        position.move();
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    public Position getMaxPosition(Position maxPosition) {
        return this.position.compareTo(maxPosition);
    }

    public boolean isWinner(Position maxPosition) {
        return position.equals(maxPosition);
    }
}
