package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.Lottos;
import lotto.factory.LottoFactory;

import java.util.List;

public class LottoServiceImpl implements LottoService{
    private final LottoFactory lottoFactory;

    public LottoServiceImpl(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public Lottos LottoStarts (LottoAmount lottoAmount) {
        List<Lotto> lottoList = lottoFactory.lottoCreate();
        return new Lottos(lottoList, lottoAmount);
    }
}
