package lotto;

import lotto.domain.Lotto;
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
        Lottos lottoGroup = new Lottos(lottos);
        Map<LottoRule, Integer> result = lottoGroup.lottoCalculation(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(result.get(LottoRule.FIRST)).isEqualTo(1);
    }
}
