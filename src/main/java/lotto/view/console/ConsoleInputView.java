package lotto.view.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.request.BonusNumberRequest;
import lotto.dto.request.LottoPurchaseAmountRequest;
import lotto.dto.request.WinningNumbersRequest;
import lotto.view.InputView;

public class ConsoleInputView implements InputView {
    @Override
    public LottoPurchaseAmountRequest readLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return new LottoPurchaseAmountRequest(input);
    }

    @Override
    public WinningNumbersRequest readWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return new WinningNumbersRequest(input);
    }

    @Override
    public BonusNumberRequest readBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return new BonusNumberRequest(input);
    }
}
