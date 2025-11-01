package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lotto;

    public Lottos(List<Lotto> lotto) {
        this.lotto = lotto;
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

    public Map<LottoRule, Integer> lottoWinFind(List<Integer> lottoNumber, int bonus) {
        LottoRule rule;
        Map<LottoRule, Integer> lottoRuleIntegerHashMap = winStatistics();
        for (int i = 0; i < lotto.size(); i++) {
            Lotto oneLotto = lotto.get(i);
            rule = LottoRule.lottoRuleFind(
                    oneLotto.lottoCompare(lottoNumber),
                    oneLotto.bonusLotto(bonus));
            int val = lottoRuleIntegerHashMap.get(rule);
            val++;
            lottoRuleIntegerHashMap.put(rule, val);

        }
        return lottoRuleIntegerHashMap;
    }

    public double calculateRateOfReturn(Map<LottoRule, Integer> lottoRule) {
        int lottoMoney = 0;
        for (int i = 0; i < LottoRule.values().length; i++) {
            LottoRule lotto = LottoRule.values()[i];
            int count = lottoRule.get(lotto);
            lottoMoney += count * lotto.getPrize();
        }
        return lottoMoney;
    }

    public double resultCalculate(Map<LottoRule, Integer> lottoRule, int money) {
        return (double) calculateRateOfReturn(lottoRule) / money * 100;
    }

}
