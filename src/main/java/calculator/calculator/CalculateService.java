package calculator.calculator;

import java.util.List;

public class CalculateService {
    public int calculateNum(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
