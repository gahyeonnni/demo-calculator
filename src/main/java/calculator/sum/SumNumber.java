package calculator.sum;

import java.util.List;

public class SumNumber {
    public long sumNum(List<Integer> numlist) {
        long sum = 0;
        for (int num : numlist) {
            if (num <= 0) {
                throw new IllegalArgumentException();
            }
            sum += num;
        }
        return sum;
    }
}
