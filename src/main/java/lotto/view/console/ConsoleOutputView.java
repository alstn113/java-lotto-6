package lotto.view.console;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoRank;
import lotto.dto.response.PurchasedLottosResponse;
import lotto.dto.response.WinningStatisticsResponse;
import lotto.view.OutputView;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printPurchasedLottos(PurchasedLottosResponse purchasedLottosResponse) {
        List<List<Integer>> purchasedLottos = purchasedLottosResponse.purchasedLottos();

        System.out.println();
        System.out.printf("%d개를 구매했습니다.%n", purchasedLottos.size());
        for (List<Integer> purchasedLotto : purchasedLottos) {
            System.out.println(purchasedLotto);
        }
    }

    @Override
    public void printWinningStatistics(WinningStatisticsResponse winningStatisticsResponse) {
        Map<LottoRank, Integer> lottoRankCount = winningStatisticsResponse.lottoRankCount();
        double totalProfit = winningStatisticsResponse.totalProfit();

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", lottoRankCount.get(LottoRank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개%n", lottoRankCount.get(LottoRank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", lottoRankCount.get(LottoRank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", lottoRankCount.get(LottoRank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", lottoRankCount.get(LottoRank.FIRST));
        System.out.printf("총 수익률은 %,.1f%%입니다.", totalProfit);
    }
}
