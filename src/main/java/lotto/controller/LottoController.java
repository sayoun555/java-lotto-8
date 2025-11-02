package lotto.controller;

import lotto.domain.LottoAmount;
import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.lottoService = lottoService;
        this.outputView = outputView;
    }

    public void run() {
        LottoAmount lottoAmount = new LottoAmount(inputView.lottoSum());
        Lottos lottos = lottoService.LottoStarts(lottoAmount);
        outputView.lottoView(lottos);
        List<String> strings = inputView.lottoWin();
        List<Integer> number = inputView.parsser(strings);


        outputView.lottosView();
    }
}
