package calculator.numstring;

public class CheckDigit {
    public boolean checkDigit(char a) {
        if (Character.isDigit(a)) {
            return true;
        }
        else {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }
}
