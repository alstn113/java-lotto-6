package lotto.dto.request;

import lotto.view.util.InputUtil;

public record LottoPurchaseAmountRequest(String input) {
    public int toInt() {
        return InputUtil.parseToInt(input);
    }
}
