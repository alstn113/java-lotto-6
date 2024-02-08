package lotto.domain.generator;

import java.util.List;
import lotto.domain.LottoNumber;

@FunctionalInterface
public interface LottoNumbersGenerator {
    List<Integer> generate();
}
