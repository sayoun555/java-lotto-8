package lotto.service;

import lotto.domain.LottoAmount;
import lotto.domain.Lottos;

public interface LottoService {
    Lottos LottoStarts(LottoAmount lottoAmount);
}
