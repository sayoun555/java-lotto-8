package lotto.controller;

import lotto.service.LottoServiceImpl;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoServiceImpl lottoServiceImpl;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoServiceImpl lottoServiceImpl, InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.lottoServiceImpl = lottoServiceImpl;
        this.outputView = outputView;
    }
}
