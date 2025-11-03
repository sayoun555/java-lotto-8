package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.parse.InputParse;

import java.util.List;

public class InputView {
    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String WIN_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_WIN_NUMBER = "보너스 번호를 입력해 주세요.";

    public int lottoSum() {
        System.out.println(PURCHASE_AMOUNT);
        String input = Console.readLine();
        return InputParse.parseAmount(input);
    }

    public List<Integer> lottoWin() {
        System.out.println(WIN_NUMBER);
        String input = Console.readLine();
        return InputParse.parse(input);
    }

    public int bonusLottoWin() {
        System.out.println(BONUS_WIN_NUMBER);
        String input = Console.readLine();
        return InputParse.parseBonus(input);
    }
}