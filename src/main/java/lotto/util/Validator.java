package lotto.util;

public interface Validator {
    void checkNonEmpty(String input);
    void checkNumeric(String input);
    int parseInt(String input);
    void checkRange(int value, int min, int max);
}
