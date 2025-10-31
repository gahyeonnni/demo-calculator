package lotto;

import lotto.controller.Config;
import lotto.controller.Controller;

public class Application {
    public static void main(String[] args) {
        Config config = new Config();
        Controller controller = config.createController();
        controller.run();
    }
}
