package lotto.view.util;

import java.util.function.Supplier;
import lotto.exception.ErrorMessage;
import lotto.exception.InvalidInputException;

public class InputUtil {
    private static final String COMMA = ",";

    private InputUtil() {
    }

    public static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new InvalidInputException(ErrorMessage.INPUT_NOT_A_NUMBER);
        }
    }

    public static String[] splitByComma(String input) {
        return input.split(COMMA, -1);
    }

    public static <T> T retryOnException(Supplier<T> supplier, boolean lineBreak) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                if (lineBreak) {
                    System.out.println();
                }
            }
        }
    }

    public static <T> T retryOnException(Supplier<T> supplier) {
        return retryOnException(supplier, false);
    }
}
