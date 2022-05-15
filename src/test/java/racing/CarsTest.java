package racing;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("여러명이 우승할 수 있다.")
    void test1() {
        Car juneCar = new Car("june");
        Car pobiCar = new Car("pobi");
        Car testCar = new Car("test");

        juneCar.move(() -> true);
        pobiCar.move(() -> false);
        testCar.move(() -> true);

        Cars cars = new Cars(Arrays.asList(juneCar, pobiCar, testCar));
        Assertions.assertThat(cars.findWinnerCars()).containsExactly(juneCar, testCar);
    }
}
