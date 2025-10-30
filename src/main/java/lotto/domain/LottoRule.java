package lotto.domain;

public enum LottoRule {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_5000_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    private final int matchCount;
    private final boolean bonus;
    private final int prize;

    LottoRule(int matchCount, boolean bonus, int prize) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.prize = prize;

    }

    public static LottoRule lottoRuleFind(int matchCount, boolean bonus) {
        LottoRule[] allRule = LottoRule.values();
        for (int i = 0; i < LottoRule.values().length; i++) {
            LottoRule rule = allRule[i];
            if (rule.isBonus() == bonus && rule.getMatchCount() == matchCount) {
                return rule;
            }
        }
        return null;
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
