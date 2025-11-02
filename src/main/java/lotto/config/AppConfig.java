package lotto.config;

import lotto.controller.LottoController;
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

    public AppConfig() {
        RandomNumber randomNumber = new RandomNumber();
        LottoFactory lottoFactory = new LottoFactory(randomNumber);
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoServiceImpl(lottoFactory);
    }

    public LottoController lottoController() {
        return new LottoController(lottoService, inputView, outputView);
    }
}
