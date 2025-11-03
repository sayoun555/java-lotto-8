package lotto.domain;

import java.util.Arrays;

public enum LottoRule {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean bonus;
    private final int prize;

    LottoRule(int matchCount, boolean bonus, int prize) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.prize = prize;

    }

    public static LottoRule lottoRuleFind(int matchCount, boolean bonus) {
        return Arrays.stream(LottoRule.values())
                .filter(rule -> rule.isBonus() == bonus && rule.getMatchCount() == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonus() {
        return bonus;
    }
}
