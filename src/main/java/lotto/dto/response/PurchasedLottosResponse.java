package lotto.dto.response;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public record PurchasedLottosResponse(List<List<Integer>> purchasedLottos) {
    public static PurchasedLottosResponse from(List<Lotto> purchasedLottos) {
        List<List<Integer>> purchasedLottosResponse = new ArrayList<>();
        for (Lotto purchasedLotto : purchasedLottos) {
            List<Integer> lotto = purchasedLotto.getLottoNumbers()
                    .stream()
                    .map(LottoNumber::getNumber)
                    .toList();
            purchasedLottosResponse.add(lotto);
        }
        return new PurchasedLottosResponse(purchasedLottosResponse);
    }
}
