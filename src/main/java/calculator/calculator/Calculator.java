package calculator.calculator;

import calculator.numstring.NumStringService;
import calculator.view.ViewService;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Calculator {
    private CalculateService calculateService;
    private NumStringService numStringService;
    private ViewService viewService;

    public Calculator() {
        this.calculateService = new CalculateService();
        this.numStringService = new NumStringService();
        this.viewService = new ViewService();
    }

    public void run() {
        viewService.runView();
        String input = readLine();

        Integer singleResult = numStringService.checkSingleOrEmpty(input);
        if (singleResult != null) {
            viewService.runView(singleResult);
            return;
        }

        List<Integer> numbers = numStringService.numString(input);
        int result = calculateService.calculateNum(numbers);
        viewService.runView(result);

    }
}
