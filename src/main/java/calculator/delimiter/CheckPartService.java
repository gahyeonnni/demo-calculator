package calculator.delimiter;

import java.util.List;

public class CheckPartService {
    private CheckDelimiterLength checkDelimiterLength;

    public CheckPartService() {
        this.checkDelimiterLength = new CheckDelimiterLength();
    }

    public char makeCustomDelimiter(String input, List<Character> delimiters) {
        char customDelimiter = 0;
        if (checkDelimiterLength.checkPartLength(input)) {
            customDelimiter = input.charAt(0);
            if (Character.isDigit(customDelimiter)) {
                throw new IllegalArgumentException("커스텀 구분자가 숫자면 안됩니다.");
            }
            if (delimiters.contains(customDelimiter)) {
                throw new IllegalArgumentException("커스텀 구분자가 기본 구분자와 동일하면 안됩니다");
            }
        }
        return customDelimiter;
    }
}
