package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String WIN_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_WIN_NUMBER = "보너스 번호를 입력해 주세요.";

    public int lottoSum() {
        System.out.println(PURCHASE_AMOUNT);
        return Integer.parseInt(Console.readLine());
    }

    public List<String> lottoWin() {
        System.out.println(WIN_NUMBER);
        String winNumberList = Console.readLine();
        return List.of(winNumberList.split(","));
    }

    public String bonusLottoWin() {
        System.out.println(BONUS_WIN_NUMBER);
        return Console.readLine();
    }
}
