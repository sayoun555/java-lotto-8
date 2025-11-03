package lotto;

import lotto.domain.LottoAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoAmountTest {
    @Test
    @DisplayName("1000원 단위가 아니면 예외가 발생한다")
    void 금액_단위_예외() {
        assertThatThrownBy(() -> new LottoAmount(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1000원 미만이면 예외가 발생한다")
    void 최소_금액_예외() {
        assertThatThrownBy(() -> new LottoAmount(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0원이면 예외가 발생한다")
    void 금액_0원_예외() {
        assertThatThrownBy(() -> new LottoAmount(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("음수 금액이면 예외가 발생한다")
    void 음수_금액_예외() {
        assertThatThrownBy(() -> new LottoAmount(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매 가능한 로또 개수를 반환한다")
    void 로또_개수_계산() {
        LottoAmount amount = new LottoAmount(5000);
        assertThat(amount.numberOfProducts()).isEqualTo(5);
    }
}
