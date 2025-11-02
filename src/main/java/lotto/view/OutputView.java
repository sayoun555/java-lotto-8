package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRule;
import lotto.domain.Lottos;

import java.util.List;
import java.util.Map;


public class OutputView {
    private final String RETE_MESSAGE = "총 수익률은 ";
    private final String RETE_PERCENT = "%입니다.";
    private final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private final String STATISTICS_HEADER = "당첨 통계\n---";

    public void lottoView(Lottos lottos) {
        System.out.println(lottos.lottoQuantity() + LOTTO_COUNT_MESSAGE);
        for (int i = 0; i < lottos.lottoQuantity(); i++) {
            Lotto oneLotto = lottos.getLotto().get(i);
            List<Integer> sortedNumbers = oneLotto.getNumbers().stream().sorted().toList();
            System.out.println(sortedNumbers);
        }
        System.out.println();
    }

    public void lottosView(Map<LottoRule, Integer> result) {
        System.out.println(STATISTICS_HEADER);
        LottoRule[] rules = LottoRule.values();
        for (int i = rules.length - 1; i >= 0; i--) {
            LottoRule rule = rules[i];
            int count = result.get(rule);
            int matchCount = rule.getMatchCount();
            int prize = rule.getPrize();

            if (rule.isBonus()) {
                System.out.println(matchCount + "개 일치, 보너스 볼 일치 (" +
                        String.format("%,d", prize) + "원) - " + count + "개");
            }
            if (!rule.isBonus()) {
                System.out.println(matchCount + "개 일치 (" +
                        String.format("%,d", prize) + "원) - " + count + "개");
            }
        }
    }

    public void rateView(double rate) {
        System.out.println(RETE_MESSAGE + rate + RETE_PERCENT);
    }
}
