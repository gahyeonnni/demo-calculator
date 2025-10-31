package lotto.domain;

import lotto.errorMessage.ErrorMessage;
import lotto.util.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputLotto {
    //쉼표 상수처리하자 
    private final Validator validator;
    private static final Pattern INPUT_PATTERN = Pattern.compile("^(\\d{1,2})(,\\d{1,2}){5}$");
    private static final int MIN = 1;
    private static final int MAX = 45;

    public InputLotto(Validator validator) {
        this.validator = validator;
    }

    public List<Integer> toNumbers(String input) {
        validator.checkNonEmpty(input);
        validateFormat(input);
        return Arrays.stream(input.split(","))
                .map(validator::parseInt)
                .peek(num -> validator.checkRange(num, MIN, MAX))
                .collect(Collectors.toList());
    }

    private void validateFormat(String input) {
        if (!INPUT_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT.message());
        }
    }
}
