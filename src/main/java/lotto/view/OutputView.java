package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRule;
import lotto.domain.Lottos;

import java.util.Date;
import java.util.Map;


public class OutputView {
    private final String RETE_MESSAGE = "총 수익률은 ";
    private final String RETE_PERCENT = "%입니다.";
    private final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";

    public void lottoView(Lottos lottos) {
        System.out.println(lottos.lottoQuantity() + LOTTO_COUNT_MESSAGE);
        for (int i = 0; i < lottos.lottoQuantity(); i++) {
            Lotto oneLotto = lottos.getLotto().get(i);
            System.out.println(oneLotto.getNumbers());
        }
    }

    public void lottosView(Map<LottoRule, Integer> result) {
        LottoRule[] rule = LottoRule.values();
        for (int i = 0; i < rule.length; i++) {
            int count = result.get(rule[i]);
            int matchCount = rule[i].getMatchCount();
            int prize = rule[i].getPrize();
            System.out.println(matchCount + "개 일치 (" + prize + "원) - " + count + "개");
        }
    }

    public void rateView(double rate) {
        System.out.println(RETE_MESSAGE + rate + RETE_PERCENT);
    }
}
