package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.RandomNumber;
import lotto.factory.LottoFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {
    @Test
    void 로또_판매기_테스트 () {
        RandomNumber randomNumber = new RandomNumber();
        LottoAmount amount = new LottoAmount(8000);
        LottoFactory factory = new LottoFactory(amount);
        List<Lotto> lottos = factory.lottoCreate();
        assertThat(lottos).hasSize(8);
    }
}
