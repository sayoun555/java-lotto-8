package lotto.factory;

import lotto.domain.Lotto;
import lotto.domain.RandomNumber;

import java.util.List;
import java.util.stream.IntStream;

public class LottoFactory {
    private final RandomNumber randomNumber;

    public LottoFactory(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    public List<Lotto> lottoCreate(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(randomNumber.randomNumberLotto()))
                .toList();
    }
}
