package lotto.domain;

import lotto.errorMessage.ErrorMessage;
import lotto.util.Validator;
import java.util.List;

public class BonusNumber {
    private final Validator validator;
    private static final int MIN = 1;
    private static final int MAX = 45;

    public BonusNumber(Validator validator) {
        this.validator = validator;
    }

    public int validate(String input, List<Integer> winningLotto) {
        validator.checkNonEmpty(input);
        validator.checkNumeric(input);
        int value = validator.parseInt(input);
        validator.checkRange(value, MIN, MAX);
        checkUniqueNumber(winningLotto, value);
        return value;
    }

    private void checkUniqueNumber(List<Integer> winningLotto, int value) {
        if (winningLotto.contains(value)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.message());
        }
    }
}
