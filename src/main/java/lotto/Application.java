package lotto;

import lotto.config.AppConfig;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        try {
            AppConfig appConfig = new AppConfig();
            LottoController lottoController = appConfig.lottoController();
            lottoController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
