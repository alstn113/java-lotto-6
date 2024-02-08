package lotto.exception;

import static lotto.domain.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MIN_LOTTO_NUMBER;

import lotto.domain.Lotto;
import lotto.domain.LottoStore;

public enum ErrorMessage {
    INPUT_NOT_A_NUMBER("입력값은 숫자여야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE(
            String.format("로또 숫자는 %d~%d이어야 합니다.", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)),
    INVALID_LOTTO_PURCHASE_AMOUNT(String.format("로또 구입 금액은 %d원 단위여야 합니다.", LottoStore.LOTTO_PRICE)),
    INVALID_LOTTO_SIZE(String.format("로또는 %d개 번호여야 합니다.", Lotto.LOTTO_SIZE)),
    DUPLICATE_LOTTO_NUMBER("로또 번호는 중복이 불가능합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
