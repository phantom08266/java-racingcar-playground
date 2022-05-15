package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {

    @Test
    @DisplayName("자동차 이름은 5글자를 초과 시 예외가 발생한다.")
    void test1() {
        assertThatThrownBy(() -> new CarName("junehee"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 없으면 예외가 발생한다.")
    void test2() {
        assertThatThrownBy(() -> new CarName(""))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름은 5글자까지 지을 수 있다.")
    void test3() {
        CarName carName = new CarName("june");
        assertThat(carName).isEqualTo(new CarName("june"));
    }
}
