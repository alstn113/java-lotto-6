package lotto.domain.generator;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoRandomNumbersGenerator implements LottoNumbersGenerator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                LottoNumber.MIN_LOTTO_NUMBER,
                LottoNumber.MAX_LOTTO_NUMBER,
                Lotto.LOTTO_SIZE);
    }
}
