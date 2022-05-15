package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("0~9입력 시 값이 1 증가한다.")
    void test1() {
        Position position = new Position(3);
        assertThat(position.move()).isEqualTo(new Position(4));
    }

    @Test
    @DisplayName("위치값으로 음수값을 입력 시 예외가 발생한다.")
    void test2() {
        assertThatThrownBy(() -> new Position(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
