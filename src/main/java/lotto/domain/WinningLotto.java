package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.exception.InvalidInputException;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    private WinningLotto(Lotto winningNumbers, LottoNumber bonusNumber) {
        validateDuplicate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto winningNumbers, LottoNumber bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void validateDuplicate(Lotto winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new InvalidInputException(ErrorMessage.DUPLICATE_LOTTO_NUMBER);
        }
    }

    public int countMatchedWinningNumbers(Lotto lotto) {
        return (int) lotto.getLottoNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean matchBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
