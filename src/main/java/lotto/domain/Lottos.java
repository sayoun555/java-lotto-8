package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lotto;
    private final LottoAmount lottoAmount;

    public Lottos(List<Lotto> lotto, LottoAmount lottoAmount) {
        this.lotto = lotto;
        this.lottoAmount = lottoAmount;
    }

    public int lottoQuantity() {
        return lotto.size();
    }

    private Map<LottoRule, Integer> winStatistics() {
        Map<LottoRule, Integer> statistics = new HashMap<>();
        for (int i = 0; i < LottoRule.values().length; i++) {
            statistics.put(LottoRule.values()[i], 0);
        }
        return statistics;
    }

    public double calculateRateOfReturn(Map<LottoRule, Integer> lottoRule) {
       return Arrays.stream(LottoRule.values())
               .mapToDouble(rule->lottoRule.get(rule) * rule.getPrize())
               .sum();
    }

    public Map<LottoRule, Integer> lottoWin(List<Integer> lottoNumber, int bonus) {
        Map<LottoRule, Integer> statistics = winStatistics();
        lotto.stream()
                .map(oneLotto -> lottoRank(oneLotto, lottoNumber, bonus))
                .forEach(rule -> rankCount(statistics, rule));
        return statistics;
    }

    private LottoRule lottoRank(Lotto lotto, List<Integer> winNumbers, int bonus) {
        int matchCount = lotto.lottoCompare(winNumbers);
        boolean hasBonus = lotto.bonusLotto(bonus);
        return LottoRule.lottoRuleFind(matchCount, hasBonus);
    }

    private void rankCount(Map<LottoRule, Integer> statistics, LottoRule rule) {
        statistics.put(rule, statistics.get(rule) + 1);
    }

    public double resultCalculate(Map<LottoRule, Integer> lottoRule) {
        return (double) calculateRateOfReturn(lottoRule) / lottoAmount.getMoney() * 100;
    }

    public List<Lotto> getLotto() {
        return lotto;
    }
}
