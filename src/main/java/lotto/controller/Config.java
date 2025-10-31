package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.InputLotto;
import lotto.domain.PurchaseAmount;
import lotto.lotto.LottoNumberGenerator;
import lotto.lotto.LottoResultChecker;
import lotto.lotto.NumberGenerator;
import lotto.util.InputValidator;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.regex.Pattern;

public class Config {

    public Controller createController() {
        Validator validator = new InputValidator(Pattern.compile("\\d+"), String.valueOf(Integer.MAX_VALUE));
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        PurchaseAmount purchaseAmount = new PurchaseAmount(validator);
        InputLotto inputLotto = new InputLotto(validator);
        BonusNumber bonusNumber = new BonusNumber(validator);

        NumberGenerator numberGenerator = new LottoNumberGenerator();
        LottoResultChecker resultChecker = new LottoResultChecker();

        return new Controller(
                inputView,
                outputView,
                purchaseAmount,
                inputLotto,
                bonusNumber,
                numberGenerator,
                resultChecker
        );
    }
}
