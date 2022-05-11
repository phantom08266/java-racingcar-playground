import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AddCalculatorTest {

    private AddCalculator addCalculator;

    @BeforeEach
    void setup() {
        addCalculator = new AddCalculator();
    }

    @Test
    @DisplayName("입력문자로 빈 문자열, null이 주어지면 0을 반환한다")
    void test1() {
        assertThat(addCalculator.calculate(null)).isZero();
        assertThat(addCalculator.calculate("")).isZero();
    }

    @Test
    @DisplayName("숫자 하나인 문자열은 그대로 숫자를 반환한다.")
    void test2() {
        assertThat(addCalculator.calculate("3")).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 하나인 문자열일 경우 숫자이외의 문자열 혹은 음수값일 경우 RuntimeException이 발생한다.")
    void test3() {
        //Todo
        assertThatThrownBy(() -> addCalculator.calculate("-3"))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> addCalculator.calculate("//"))
                .hasMessageContaining("특수 문자는 연산할 수 없습니다")
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열로 구분자 처리를 하여 덧셈연산을 한다.")
    void test4() {
        assertThat(addCalculator.calculate("1,2,3")).isEqualTo(6);
        assertThat(addCalculator.calculate("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 지정할 수 있다.(// 와 \n 사이에 있는 문자로 커스텀 한다.)")
    void test5() {
        assertThat(addCalculator.calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 입력할 경우 RuntimeException이 발생한다")
    void test6() {
        assertThatThrownBy(() -> addCalculator.calculate("1,2,-3"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
