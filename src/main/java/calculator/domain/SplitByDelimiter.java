package calculator.domain;

import calculator.sum.SumNumber;

import java.util.LinkedList;
import java.util.List;

public class SplitByDelimiter {

    public long splitByDelimiter(String input, List<Character> list) {
        long answer = 0;
        List<Integer> numlist = new LinkedList<>();

        if (input.length() == 0) {
            return 0;
        }

        if (input.length() == 1 && Character.isDigit(input.charAt(0))) {
            int num = Integer.parseInt(input);
            if (num <= 0) throw new IllegalArgumentException();
            return num;
        }

        if (input.length() == 1 && !Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException();
        }

        if (input.length() % 2 == 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                CheckCharacter checkCharacter = new CheckCharacter();
                if (checkCharacter.CheckCharacter(input.charAt(i))) {
                    numlist.add(Integer.parseInt(String.valueOf(input.charAt(i))));
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                if (!list.contains(input.charAt(i))) {
                    throw new IllegalArgumentException();
                }

                if (i + 1 < input.length() && !Character.isDigit(input.charAt(i + 1))) {
                    throw new IllegalArgumentException();
                }
            }
        }
        if (numlist.size() != 0) {
            SumNumber sumNumber = new SumNumber();
            answer = sumNumber.sumNum(numlist);
        }

        return answer;
    }
}
