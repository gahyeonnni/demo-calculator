package calculator.domain;

import java.util.List;

public class CheckCustomDelimiter {

    public String checkCustomDelimiterExist(String input, List<Character> delimiterList) {

        if (!input.startsWith("//")) {
            throw new IllegalArgumentException();
        }

        int newlineIndex = input.indexOf("\\n");
        if (newlineIndex == -1) {
            throw new IllegalArgumentException();
        }

        String delimiterPart = input.substring(2, newlineIndex);

        if (delimiterPart.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (delimiterPart.length() > 1) {
            throw new IllegalArgumentException();
        }

        char customDelimiter = delimiterPart.charAt(0);

        if (Character.isDigit(customDelimiter)) {
            throw new IllegalArgumentException();
        }
        if (delimiterList.contains(customDelimiter)) {
            throw new IllegalArgumentException();
        }

        delimiterList.add(customDelimiter);
        return input.substring(newlineIndex + 2);
    }
}
