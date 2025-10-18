package calculator.service;

import calculator.domain.CheckCustomDelimiter;
import calculator.domain.SplitByDelimiter;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService {

    public long calculate(String input) {
        List<Character> delimiters = new ArrayList<>();
        delimiters.add(',');
        delimiters.add(':');

        String processedInput = input;

        if (processedInput.isEmpty()) {
            return 0;
        }

        if (processedInput.startsWith("//")) {
            CheckCustomDelimiter checkCustomDelimiter = new CheckCustomDelimiter();
            processedInput = checkCustomDelimiter.checkCustomDelimiterExist(processedInput, delimiters);
        }

        SplitByDelimiter splitter = new SplitByDelimiter();
        return splitter.splitByDelimiter(processedInput, delimiters);
    }
}
