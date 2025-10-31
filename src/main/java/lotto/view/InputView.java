package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getAmout() {
        System.out.println(InputMessage.ASK_PURCHASE_AMOUNT.getMessage());
        return Console.readLine();
    }

    public String getWinningNumber() {
        System.out.println(InputMessage.ASK_WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println(InputMessage.ASK_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
