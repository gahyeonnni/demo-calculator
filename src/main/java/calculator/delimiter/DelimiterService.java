package calculator.delimiter;

import java.util.ArrayList;
import java.util.List;

public class DelimiterService {
    private final List<Character> delimiters = new ArrayList<>();
    private CheckDelimiter checkDelimiter;
    private CheckPartService checkPartService;

    public DelimiterService() {
        delimiters.add(',');
        delimiters.add(':');
        checkDelimiter = new CheckDelimiter();
        checkPartService = new CheckPartService();
    }

    public List<Character> getDelimiters() {
        return delimiters;
    }

    public String getCustomDelimiter(String input) {
        if (!input.startsWith("//"))
            return input;

        int newStringIndex = checkDelimiter.checkEnd(input);

        String delimiterPart = input.substring(2, newStringIndex);
        char customDelimiter = checkPartService.makeCustomDelimiter(delimiterPart, delimiters);

        delimiters.add(customDelimiter);
        return input.substring(newStringIndex + 2);
    }
}