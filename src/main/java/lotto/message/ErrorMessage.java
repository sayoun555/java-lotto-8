package lotto.message;

public enum ErrorMessage {
    EMPTY_INPUT("[ERROR] 입력값이 비어 있습니다."),
    NOT_NUMBER("[ERROR] 숫자만 입력해야 합니다."),
    PARSE_FAIL("[ERROR] 금액 형식이 잘못되었습니다."),
    LOTTO_NUMBER_ERROR("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_CHECK("[ERROR] 로또 번호에 중복이 있습니다."),
    LOTTO_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
