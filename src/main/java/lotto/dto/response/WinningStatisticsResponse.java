package lotto.dto.response;

import java.util.Map;
import lotto.domain.LottoRank;
import lotto.domain.WinningStatistics;

public record WinningStatisticsResponse(Map<LottoRank, Integer> lottoRankCount, double totalProfit) {
    public static WinningStatisticsResponse from(WinningStatistics winningStatistics) {
        Map<LottoRank, Integer> lottoRankCount = winningStatistics.getLottoRankCount();
        double totalProfit = winningStatistics.getTotalProfit();
        return new WinningStatisticsResponse(lottoRankCount, totalProfit);
    }
}
