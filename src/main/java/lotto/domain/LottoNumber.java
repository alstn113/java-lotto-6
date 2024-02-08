package lotto.domain;

import java.util.Objects;
import java.util.stream.IntStream;
import lotto.exception.ErrorMessage;
import lotto.exception.InvalidInputException;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    private LottoNumber(final int number) {
        this.number = number;
    }

    private static final LottoNumber[] LOTTO_NUMBER_CACHE = new LottoNumber[MAX_LOTTO_NUMBER + 1];

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .forEach(number -> LOTTO_NUMBER_CACHE[number] = new LottoNumber(number));
    }

    public static LottoNumber of(final int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new InvalidInputException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE);
        }
        return LOTTO_NUMBER_CACHE[number];
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.getNumber();
    }
}
