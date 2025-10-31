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

    public Map<LottoRule, Integer> winStatistics() {
        Map<LottoRule, Integer> statistics = new HashMap<>();
        for (int i = 0; i < LottoRule.values().length; i++) {
            statistics.put(LottoRule.values()[i], 0);
        }
        return statistics;
    }

//    public Map<LottoRule, Integer> lottoCalculation(List<Integer> lottoNumber, int bonus) {
//        for (int i = 0; i < lotto.size(); i++) {
//            LottoRule.lottoRuleFind()
//        }
//    }
}
