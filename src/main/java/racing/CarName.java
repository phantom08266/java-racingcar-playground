package racing;

import java.util.Objects;

public class CarName {

    private final String name;

    public CarName(String name) {
        validCarName(name);
        this.name = name;
    }

    private void validCarName(String name) {
        validEmptyCarName(name);
        validCarNameLength(name);
    }

    private void validCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    private void validEmptyCarName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요!");
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
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
