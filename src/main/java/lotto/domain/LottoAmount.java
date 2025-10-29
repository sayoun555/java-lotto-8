package lotto.domain;

public class LottoAmount {
    private final int money;

    public LottoAmount(int money) {
        checkAmountValid(money);
        this.money = money;
    }

    public void checkAmountValid(int money) {
        if (money < 1000 || money % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 금액을 정확하게 기입해주세요.");
    }

    public int numberOfProducts() {
        return money / 1000;
    }

    public int getMoney() {
        return money;
    }
}
