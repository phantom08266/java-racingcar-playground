package racing;

import java.util.Objects;

public class Position {

    private int point;

    public Position() {
        this(0);
    }

    public Position(int point) {
        validPositionBound(point);
        this.point = point;
    }

    public Position move() {
        this.point++;
        return this;
    }

    private void validPositionBound(int point) {
        if (point < 0) {
            throw new IllegalArgumentException("위치값을 잘못 입력하셨습니다. 위치는 음수일 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return point == position.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
