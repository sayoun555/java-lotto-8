package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RateOfReturn {
    private final RandomNumber randomNumber;

    public RateOfReturn() {
        this.randomNumber = new RandomNumber();
    }
    public List<List<Integer>> lottoRateOfReturn (int number) {
        List<List<Integer>> lottoNumber = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            List<Integer> list = randomNumber.randomNumberLotto();
            Collections.sort(list);
            lottoNumber.add(list);
        }
        return lottoNumber;
    }
}
