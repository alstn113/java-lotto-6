package lotto.dto.request;

import lotto.domain.LottoNumber;
import lotto.view.util.InputUtil;

public record BonusNumberRequest(String input) {
    public LottoNumber toLottoNumber() {
        int number = InputUtil.parseToInt(input);
        return LottoNumber.of(number);
    }
}
