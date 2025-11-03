package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRule;
import lotto.domain.Lottos;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {
    private final String RETE_MESSAGE = "총 수익률은 ";
    private final String RETE_PERCENT = "%입니다.";
    private final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private final String STATISTICS_HEADER = "당첨 통계\n---";

    public void lottoView(Lottos lottos) {
        System.out.println(lottos.lottoQuantity() + LOTTO_COUNT_MESSAGE);
        lottos.getLotto().stream()
                .map(this::LottoNumbers)
                .forEach(System.out::println);
        System.out.println();
    }

    private List<Integer> LottoNumbers(Lotto lotto) {
        return lotto.getNumbers().stream().sorted().toList();
    }

    public void lottosView(Map<LottoRule, Integer> result) {
        System.out.println(STATISTICS_HEADER);
        Arrays.stream(LottoRule.values())
                .filter(rule -> rule != LottoRule.NONE)
                .sorted((r1, r2) -> Integer.compare(r2.getMatchCount(), r1.getMatchCount()))
                .forEach(rule -> rankStatistics(rule, result.get(rule)));
    }

    private void rankStatistics(LottoRule rule, int count) {
        String message = rankMessage(rule);
        System.out.println(message + " - " + count + "개");
    }

    private String rankMessage(LottoRule rule) {
        String prize = String.format("%,d", rule.getPrize());
        String base = rule.getMatchCount() + "개 일치";

        if (rule.isBonus()) {
            return base + ", 보너스 볼 일치 (" + prize + "원)";
        }
        return base + " (" + prize + "원)";
    }

    public void rateView(double rate) {
        System.out.println(RETE_MESSAGE + rate + RETE_PERCENT);
    }
}