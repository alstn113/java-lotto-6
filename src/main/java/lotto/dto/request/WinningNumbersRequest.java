package lotto.dto.request;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.view.util.InputUtil;

public record WinningNumbersRequest(String input) {
    public Lotto toLotto() {
        List<Integer> lottoNumbers = Arrays.stream(InputUtil.splitByComma(input))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        return new Lotto(lottoNumbers);
    }
}
