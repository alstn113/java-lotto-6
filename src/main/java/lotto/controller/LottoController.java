package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoStore;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistics;
import lotto.domain.generator.LottoNumbersGenerator;
import lotto.dto.request.BonusNumberRequest;
import lotto.dto.request.LottoPurchaseAmountRequest;
import lotto.dto.request.WinningNumbersRequest;
import lotto.dto.response.PurchasedLottosResponse;
import lotto.dto.response.WinningStatisticsResponse;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.util.InputUtil;

public class LottoController implements Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoNumbersGenerator lottoNumbersGenerator;

    public LottoController(InputView inputView, OutputView outputView,
                           LottoNumbersGenerator lottoNumbersGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    @Override
    public void run() {
        LottoStore lottoStore = new LottoStore(lottoNumbersGenerator);

        List<Lotto> purchasedLottos = buyLottos(lottoStore);
        outputView.printPurchasedLottos(PurchasedLottosResponse.from(purchasedLottos));

        Lotto winningNumbers = createWinningNumbers();
        WinningLotto winningLotto = createWinningLotto(winningNumbers);
        WinningStatistics winningStatistics = WinningStatistics.of(purchasedLottos, winningLotto);
        outputView.printWinningStatistics(WinningStatisticsResponse.from(winningStatistics));
    }

    private List<Lotto> buyLottos(LottoStore lottoStore) {
        return InputUtil.retryOnException(() -> {
            LottoPurchaseAmountRequest dto = inputView.readLottoPurchaseAmount();
            int purchaseAmount = dto.toInt();
            return lottoStore.buyLottos(purchaseAmount);
        }, true);
    }

    private Lotto createWinningNumbers() {
        return InputUtil.retryOnException(() -> {
            WinningNumbersRequest dto = inputView.readWinningNumbers();
            return dto.toLotto();
        });
    }

    private WinningLotto createWinningLotto(Lotto winningNumbers) {
        return InputUtil.retryOnException(() -> {
            BonusNumberRequest dto = inputView.readBonusNumber();
            LottoNumber bonusNumber = dto.toLottoNumber();
            return WinningLotto.of(winningNumbers, bonusNumber);
        });
    }
}
