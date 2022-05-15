package racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("값이 4이상일 시 위치값이 1증가한다.")
    void test1() {
        Car car = new Car("june");
        car.move(4);
        assertThat(car.isSamePosition(new Position(1))).isTrue();
        car.move(new CarMovingStrategy() {
            @Override
            public boolean isMoving() {
                return true;
            }
        });
        assertThat(car.isSamePosition(new Position(2))).isTrue();

        car.move(() -> true);
        assertThat(car.isSamePosition(new Position(3))).isTrue();
    }

    @Test
    @DisplayName("값이 4미만일 시 위치값이 증가하지 않는다.")
    void test2() {
        Car car = new Car("june");
        car.move(3);
        assertThat(car.isSamePosition(new Position(1))).isFalse();
    }
}
