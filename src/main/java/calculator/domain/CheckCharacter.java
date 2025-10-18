package calculator.domain;

public class CheckCharacter {

    public boolean CheckCharacter(char a) {
        if (Character.isDigit(a)) {
            int num = Integer.parseInt(String.valueOf(a));
            if (num > 0) {
                return true;
            } else {
                throw new IllegalArgumentException();
            }
        }
        throw new IllegalArgumentException();
    }
}
