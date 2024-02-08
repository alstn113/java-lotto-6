package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.generator.LottoNumbersGenerator;
import lotto.domain.generator.LottoRandomNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.console.ConsoleInputView;
import lotto.view.console.ConsoleOutputView;

public class AppConfig {
    public static InputView consoleInputView() {
        return new ConsoleInputView();
    }

    public static OutputView consoleOutputView() {
        return new ConsoleOutputView();
    }

    public static LottoNumbersGenerator lottoRandomNumbersGenerator() {
        return new LottoRandomNumbersGenerator();
    }

    public static LottoController lottoController() {
        return new LottoController(
                consoleInputView(),
                consoleOutputView(),
                lottoRandomNumbersGenerator()
        );
    }
}
