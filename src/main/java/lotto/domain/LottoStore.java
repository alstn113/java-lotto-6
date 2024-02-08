package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.domain.generator.LottoNumbersGenerator;
import lotto.exception.ErrorMessage;
import lotto.exception.InvalidInputException;

public class LottoStore {
    public static final int LOTTO_PRICE = 1000;

    private final LottoNumbersGenerator lottoNumbersGenerator;

    public LottoStore(LottoNumbersGenerator lottoNumbersGenerator) {
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    public List<Lotto> buyLottos(int money) {
        validateMoney(money);
        int lottoCount = money / LOTTO_PRICE;
        return generateLottos(lottoCount);
    }

    private List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = new ArrayList<>(lottoNumbersGenerator.generate());
            lottoNumbers.sort(Comparator.naturalOrder());
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }

    private void validateMoney(int money) {
        if (money < LOTTO_PRICE || money % LOTTO_PRICE != 0) {
            throw new InvalidInputException(ErrorMessage.INVALID_LOTTO_PURCHASE_AMOUNT);
        }
    }
}
