package calculator.numstring;


import calculator.delimiter.DelimiterService;

import java.util.LinkedList;
import java.util.List;

public class NumStringService {
    private CheckDigit checkDigit;
    private CheckPositive checkPositive;
    private DelimiterService delimiterService;

    public NumStringService() {
        this.checkDigit = new CheckDigit();
        this.checkPositive = new CheckPositive();
        this.delimiterService = new DelimiterService();
    }

    public Integer checkSingleOrEmpty(String input) {
        if (input.length() == 0) {
            return 0;
        }
        else if (input.length() == 1) {
            char c = input.charAt(0);
            if (checkDigit.checkDigit(c) && checkPositive.checkPositive(c)) {
                return Integer.parseInt(input);
            }
            else {
                throw new IllegalArgumentException("입력값이 한 자리일 경우 숫자만 입력 가능합니다.");
            }
        }
        return null;
    }

    public List<Integer> numString(String input) {
        List<Integer> numList = new LinkedList<>();

        String parsedInput = delimiterService.getCustomDelimiter(input);
        List<Character> delimiters = delimiterService.getDelimiters();

        for (int i = 0; i < parsedInput.length(); i++) {
            char c = parsedInput.charAt(i);
            if (i % 2 == 0) {
                if (checkDigit.checkDigit(c) && checkPositive.checkPositive(c)) {
                    numList.add(Integer.parseInt(String.valueOf(c)));
                }
                else {
                    throw new IllegalArgumentException("잘못된 입력값입니다.");
                }
            }
            else {
                if (!delimiters.contains(c)) {
                    throw new IllegalArgumentException("잘못된 구분자입니다.");
                }
            }
        }
        return numList;
    }
}
