package lotto.controller;

import lotto.domain.LottoAmount;
import lotto.domain.LottoRule;
import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

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
        Lottos lottos = purchaseLotto();
        outputView.lottoView(lottos);

        Map<LottoRule, Integer> result = calculateWinning(lottos);
        display(lottos, result);
    }

    private Lottos purchaseLotto() {
        LottoAmount amount = new LottoAmount(inputView.lottoSum());
        return lottoService.LottoStarts(amount);
    }

    private Map<LottoRule, Integer> calculateWinning(Lottos lottos) {
        List<Integer> winNumbers = inputView.lottoWin();
        int bonus = inputView.bonusLottoWin();
        return lottos.lottoWin(winNumbers, bonus);
    }

    private void display(Lottos lottos, Map<LottoRule, Integer> result) {
        outputView.lottosView(result);
        outputView.rateView(lottos.resultCalculate(result));
    }
}
