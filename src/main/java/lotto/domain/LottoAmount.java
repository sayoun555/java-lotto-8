package lotto.domain;

import lotto.message.ErrorMessage;

public class LottoAmount {
    private final int money;

    public LottoAmount(int money) {
        checkAmountValid(money);
        this.money = money;
    }

    private void checkAmountValid(int money) {
        if (money < 1000 || money % 1000 != 0)
            throw new IllegalArgumentException(ErrorMessage.PARSE_FAIL.message());
    }

    public int numberOfProducts() {
        return money / 1000;
    }

    public int getMoney() {
        return money;
    }
}
