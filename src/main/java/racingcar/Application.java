package racingcar;

import racingcar.controller.Controller;
import racingcar.race.*;
import racingcar.view.*;

public class Application {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        OutputResultView outputResultView = new OutputResultView();
        CarNameParser carNameParser = new CarNameParser();
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        RaceResult raceResult = new RaceResult();

        CarRace carRace = new CarRace(
                carNameParser,
                randomNumberGenerator,
                inputReader,
                outputResultView,
                raceResult
        );

        Controller controller = new Controller(carRace);
        controller.run();
    }
}
