package lotto.domain;

import lotto.errorMessage.ErrorMessage;
import lotto.util.Validator;

public class PurchaseAmount {
    private final Validator validator;

    public PurchaseAmount(Validator validator) {
        this.validator = validator;
    }

    public int getPurchaseCount(String input) {
        int amount = validate(input);
        return amount / 1000;
    }

    private int validate(String input) {
        validator.checkNonEmpty(input);
        validator.checkNumeric(input);
        int value = validator.parseInt(input);
        checkPositive(value);
        checkPurchaseUnit(value);
        return value;
    }

    private void checkPositive(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE.message());
        }
    }

    private void checkPurchaseUnit(int value) {
        if (value % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_UNIT.message());
        }
    }
}
