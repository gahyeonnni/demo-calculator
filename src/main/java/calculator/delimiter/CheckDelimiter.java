package calculator.delimiter;

public class CheckDelimiter {
    public int checkEnd(String input) {
        int newIndex = input.indexOf("\\n");
        if (newIndex == -1) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
        }
        return newIndex;
    }
}
