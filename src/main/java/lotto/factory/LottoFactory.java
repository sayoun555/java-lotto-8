package lotto.factory;

import lotto.domain.Lotto;
import lotto.domain.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    private final RandomNumber randomNumber;

    public LottoFactory(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    public List<Lotto> lottoCreate(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(randomNumber.randomNumberLotto()));
        }
        return lottos;
    }
}
