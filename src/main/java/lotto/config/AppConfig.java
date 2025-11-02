package lotto.config;

import lotto.domain.LottoAmount;
import lotto.domain.RandomNumber;
import lotto.factory.LottoFactory;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private final LottoFactory lottoFactory;

    public AppConfig() {
        LottoAmount lottoAmount = new LottoAmount();
        RandomNumber randomNumber = new RandomNumber();
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoServiceImpl();
        LottoFactory lottoFactory = new LottoFactory(randomNumber);
    }
}
