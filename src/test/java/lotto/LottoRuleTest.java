package lotto;

import lotto.domain.LottoRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRuleTest {

    @Test
    @DisplayName("6개 일치하면 1등을 반환한다")
    void 일등_찾기() {
        LottoRule rule = LottoRule.lottoRuleFind(6, false);
        assertThat(rule).isEqualTo(LottoRule.FIRST);
    }

    @Test
    @DisplayName("5개 일치 + 보너스 일치하면 2등을 반환한다")
    void 이등_찾기() {
        LottoRule rule = LottoRule.lottoRuleFind(5, true);
        assertThat(rule).isEqualTo(LottoRule.SECOND);
    }

    @Test
    @DisplayName("5개 일치하면 3등을 반환한다")
    void 삼등_찾기() {
        LottoRule rule = LottoRule.lottoRuleFind(5, false);
        assertThat(rule).isEqualTo(LottoRule.THIRD);
    }

    @Test
    @DisplayName("4개 일치하면 4등을 반환한다")
    void 사등_찾기() {
        LottoRule rule = LottoRule.lottoRuleFind(4, false);
        assertThat(rule).isEqualTo(LottoRule.FOURTH);
    }

    @Test
    @DisplayName("3개 일치하면 5등을 반환한다")
    void 오등_찾기() {
        LottoRule rule = LottoRule.lottoRuleFind(3, false);
        assertThat(rule).isEqualTo(LottoRule.FIFTH);
    }

    @Test
    @DisplayName("당첨되지 않으면 NONE을 반환한다")
    void 낙첨() {
        LottoRule rule = LottoRule.lottoRuleFind(2, false);
        assertThat(rule).isEqualTo(LottoRule.NONE);
    }
}
