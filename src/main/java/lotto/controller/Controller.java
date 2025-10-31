package lotto.controller;

import lotto.domain.*;
import lotto.lotto.*;
import lotto.view.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final PurchaseAmount purchaseAmount;
    private final InputLotto inputLotto;
    private final BonusNumber bonusNumber;
    private final NumberGenerator numberGenerator;
    private final LottoResultChecker resultChecker;

    public Controller(
            InputView inputView,
            OutputView outputView,
            PurchaseAmount purchaseAmount,
            InputLotto inputLotto,
            BonusNumber bonusNumber,
            NumberGenerator numberGenerator,
            LottoResultChecker resultChecker
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.purchaseAmount = purchaseAmount;
        this.inputLotto = inputLotto;
        this.bonusNumber = bonusNumber;
        this.numberGenerator = numberGenerator;
        this.resultChecker = resultChecker;
    }

    public void run() {
        try {
            String amountInput = inputView.getAmout();
            int count = purchaseAmount.getPurchaseCount(amountInput);

            List<Lotto> purchasedLottos = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                purchasedLottos.add(new Lotto(numberGenerator.generate(1, 45, 6)));
            }
            outputView.printPurchasedLottos(purchasedLottos);

            List<Integer> winningNumbers = inputLotto.toNumbers(inputView.getWinningNumber());

            int bonusNum = bonusNumber.validate(inputView.getBonusNumber(), winningNumbers);

            Map<LottoRank, Integer> results = resultChecker.checkResults(purchasedLottos, winningNumbers, bonusNum);

            double rate = resultChecker.calculateProfitRate(results, count * 1000);

            outputView.printWinningStatistics(results, rate);

        } catch (IllegalArgumentException e) {
            run();
        }
    }
}
