package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private final Map<LottoRank, Integer> lottoRankCount = new EnumMap<>(LottoRank.class);
    private final double totalProfit;

    private WinningStatistics(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        initLottoRankCount();
        calculateLottoRankCount(purchasedLottos, winningLotto);
        long totalPrize = calculateTotalPrize(lottoRankCount);
        int purchaseAmount = purchasedLottos.size() * LottoStore.LOTTO_PRICE;
        this.totalProfit = calculateTotalProfit(totalPrize, purchaseAmount);
    }

    public static WinningStatistics of(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        return new WinningStatistics(purchasedLottos, winningLotto);
    }

    private void initLottoRankCount() {
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoRankCount.put(lottoRank, 0);
        }
    }

    private void calculateLottoRankCount(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        for (Lotto purchasedLotto : purchasedLottos) {
            LottoRank lottoRank = calculateLottoRank(winningLotto, purchasedLotto);
            lottoRankCount.put(lottoRank, lottoRankCount.get(lottoRank) + 1);
        }
    }

    private LottoRank calculateLottoRank(WinningLotto winningLotto, Lotto purchasedLotto) {
        int matchCount = winningLotto.countMatchedWinningNumbers(purchasedLotto);
        boolean matchBonus = winningLotto.matchBonusNumber(purchasedLotto);
        return LottoRank.of(matchCount, matchBonus);
    }

    private long calculateTotalPrize(Map<LottoRank, Integer> lottoRankCount) {
        return lottoRankCount.entrySet().stream()
                .mapToLong(entry -> {
                    int prize = entry.getKey().getPrize();
                    int count = entry.getValue();
                    return (long) prize * count;
                })
                .sum();
    }

    private double calculateTotalProfit(long totalPrize, int purchasedAmount) {
        return ((double) totalPrize / purchasedAmount) * 100;
    }

    public Map<LottoRank, Integer> getLottoRankCount() {
        return lottoRankCount;
    }

    public double getTotalProfit() {
        return totalProfit;
    }
}
