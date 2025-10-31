package lotto.view;

public enum OutputMessage {
    PURCHASED_COUNT("%d개를 구매했습니다."),
    WINNING_STATISTICS("당첨 통계"),
    DIVIDER("---");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

