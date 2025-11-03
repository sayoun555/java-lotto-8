package lotto.parse;

import lotto.message.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class InputParse {
    public static int parseAmount(String input) {
        return parseBonus(input);
    }

    public static List<Integer> parse(String input) {
        List<String> parts = Arrays.asList(input.split(","));
        try {
            return parts.stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.message());
        }
    }

    public static int parseBonus(String input) {
        validateNumber(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PARSE_FAIL.message());
        }
    }

    private static void validateNumber(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.message());
        }
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.message());
        }
    }
}