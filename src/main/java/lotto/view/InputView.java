package lotto.view;

import lotto.dto.request.BonusNumberRequest;
import lotto.dto.request.LottoPurchaseAmountRequest;
import lotto.dto.request.WinningNumbersRequest;

public interface InputView {
    LottoPurchaseAmountRequest readLottoPurchaseAmount();

    WinningNumbersRequest readWinningNumbers();

    BonusNumberRequest readBonusNumber();
}
