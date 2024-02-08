package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.InvalidInputException;

public class Lotto {
    public static final int LOTTO_SIZE = 6;

    public final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers.stream().map(LottoNumber::of).toList());
    }

    private void validate(List<Integer> lottoNumbers) {
        validateDuplicate(lottoNumbers);
        validateSize(lottoNumbers);
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new InvalidInputException(ErrorMessage.INVALID_LOTTO_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != new HashSet<>(lottoNumbers).size()) {
            throw new InvalidInputException(ErrorMessage.DUPLICATE_LOTTO_NUMBER);
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return getLottoNumbers().contains(lottoNumber);
    }
}
