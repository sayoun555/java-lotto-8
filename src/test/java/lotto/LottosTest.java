package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.LottoRule;
import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Map;

public class LottosTest {

    @Test
    void 로또_당첨_계산_테스트() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        LottoAmount lottoAmount = new LottoAmount(1000);
        Lottos lottoGroup = new Lottos(lottos, lottoAmount);
        Map<LottoRule, Integer> result = lottoGroup.lottoWin(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(result.get(LottoRule.FIRST)).isEqualTo(1);
    }

    @Test
    void 수익률_계산_테스트() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        LottoAmount lottoAmount = new LottoAmount(1000);
        Lottos lottoGroup = new Lottos(lottos, lottoAmount);
        Map<LottoRule, Integer> statistics = lottoGroup.lottoWin(List.of(1, 2, 3, 4, 5, 6), 7);
        double result = lottoGroup.resultCalculate(statistics);
        assertThat(result).isEqualTo(200000000.0);
    }
}
