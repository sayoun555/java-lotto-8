package lotto.message;

public enum ErrorMessage {
    EMPTY_INPUT("[ERROR] 입력값이 비어 있습니다."),
    NOT_NUMBER("[ERROR] 숫자만 입력해야 합니다."),
    PARSE_FAIL("[ERROR] 금액 형식이 잘못되었습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
