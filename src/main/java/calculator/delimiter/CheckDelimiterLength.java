package calculator.delimiter;

public class CheckDelimiterLength {
    public boolean checkPartLength(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException("커스텀 구분자가 누락되었습니다.");
        }

        if (input.length() > 1) {
            throw new IllegalArgumentException("커스텀 구분자는 문자만 가능합니다.");
        }

        return true;
    }
}
