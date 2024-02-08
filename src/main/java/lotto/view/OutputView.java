package lotto.view;

import lotto.dto.response.PurchasedLottosResponse;
import lotto.dto.response.WinningStatisticsResponse;

public interface OutputView {
    void printPurchasedLottos(PurchasedLottosResponse lottosResponse);

    void printWinningStatistics(WinningStatisticsResponse winningStatisticsResponse);
}
