package lotto.util;

import lotto.errorMessage.ErrorMessage;

import java.util.regex.Pattern;

public class InputValidator implements Validator {

    private final Pattern numericPattern;
    private final String maxValue;

    public InputValidator(Pattern numericPattern, String maxValue) {
        this.numericPattern = numericPattern;
        this.maxValue = maxValue;
    }

    @Override
    public void checkNonEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT.message());
        }
    }

    @Override
    public void checkNumeric(String input) {
        if (!numericPattern.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC.message());
        }
    }

    @Override
    public int parseInt(String input) {
        checkIntOverflow(input);
        return Integer.parseInt(input);
    }

    private void checkIntOverflow(String input) {
        if (input.length() > maxValue.length()) {
            throw new IllegalArgumentException(ErrorMessage.COUNT_OUT_OF_RANGE.message());
        }
        if (input.length() == maxValue.length() && input.compareTo(maxValue) > 0) {
            throw new IllegalArgumentException(ErrorMessage.COUNT_OUT_OF_RANGE.message());
        }
    }

    @Override
    public void checkRange(int value, int min, int max) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.message());
        }
    }
}
