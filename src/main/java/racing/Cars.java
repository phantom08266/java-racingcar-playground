package racing;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinnerCars() {
        Position maxPosition = getMaxPosition();
        return cars.stream()
            .filter(car -> car.isWinner(maxPosition))
            .collect(Collectors.toList());
    }

    private Position getMaxPosition() {
        Position maxPosition = new Position();
       for (Car car : cars) {
           maxPosition = car.getMaxPosition(maxPosition);
       }
       return maxPosition;
    }
}
