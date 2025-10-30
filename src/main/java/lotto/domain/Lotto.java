package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public int lottoCompare(List<Integer> winNumber) {
        int count = 0;
        for (Integer myNumber : numbers) {
            if (winNumber.contains(myNumber)) {
                count++;
            }
        }
        return count;
    }
    public boolean bonusLotto(int number) {
        return numbers.contains(number);
    }
}
