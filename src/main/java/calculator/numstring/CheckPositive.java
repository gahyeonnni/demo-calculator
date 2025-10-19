package calculator.numstring;

public class CheckPositive {
    public boolean checkPositive(char a) {
        int num = Integer.parseInt(String.valueOf(a));
        if (num > 0)
            return true;
        else
            throw new IllegalArgumentException("입력값은 양수만 가능합니다.");
    }
}
