package lotto.domain;

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
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복이 있습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(num -> num >= 1 && num <= 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
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
