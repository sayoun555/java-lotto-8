package lotto;

import lotto.parse.InputParse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputParseTest {

    @Test
    @DisplayName("정상적인 금액 파싱")
    void 금액_파싱_성공() {
        int amount = InputParse.parseAmount("8000");
        assertThat(amount).isEqualTo(8000);
    }

    @Test
    @DisplayName("빈 문자열이면 예외 발생")
    void 빈_문자열_예외() {
        assertThatThrownBy(() -> InputParse.parseAmount(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백만 있으면 예외 발생")
    void 공백_문자열_예외() {
        assertThatThrownBy(() -> InputParse.parseAmount("   "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자가 포함되면 예외 발생")
    void 문자_포함_예외() {
        assertThatThrownBy(() -> InputParse.parseAmount("1000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("null이면 예외 발생")
    void null_예외() {
        assertThatThrownBy(() -> InputParse.parseAmount(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("쉼표로 구분된 숫자 리스트 파싱")
    void 리스트_파싱_성공() {
        List<Integer> numbers = InputParse.parse("1,2,3,4,5,6");
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("리스트에 문자가 포함되면 예외 발생")
    void 리스트_문자_포함_예외() {
        assertThatThrownBy(() -> InputParse.parse("1,2,a,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호 정상 파싱")
    void 보너스_파싱_성공() {
        int bonus = InputParse.parseBonus("4");
        assertThat(bonus).isEqualTo(4);
    }

    @Test
    @DisplayName("보너스 번호에 문자가 포함되면 예외 발생")
    void 보너스_문자_포함_예외() {
        assertThatThrownBy(() -> InputParse.parseBonus("10a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
