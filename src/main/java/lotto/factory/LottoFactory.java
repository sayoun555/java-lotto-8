package lotto.factory;

import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    private final LottoAmount lottoAmount;
    private final RandomNumber randomNumber;

    public LottoFactory(RandomNumber randomNumber, LottoAmount lottoAmount) {
        this.lottoAmount = lottoAmount;
        this.randomNumber = randomNumber;
    }

    private int numberOfLottos() {
        for (int i = 0; i < lottoAmount.numberOfProducts(); i++) {
            if (i == lottoAmount.numberOfProducts()) {
                return i;
            }
        }
        return 0;
    }

    public List<Lotto> lottoCreate() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos(); i++) {
            Lotto lotto = new Lotto(randomNumber.randomNumberLotto());
            lottos.add(lotto);
        }
        return lottos;
    }
}
