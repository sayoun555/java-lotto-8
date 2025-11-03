package lotto.domain;

import lotto.message.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_ERROR.message());
        }
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_CHECK.message());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(num -> num >= 1 && num <= 45)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE_ERROR.message());
        }
    }

    public int lottoCompare(List<Integer> winNumber) {
        return (int) numbers.stream()
                .filter(winNumber::contains)
                .count();
    }

    public boolean bonusLotto(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
