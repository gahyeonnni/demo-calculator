package racingcar.controller;

import racingcar.race.CarRace;

public class Controller {
    private final CarRace carRace;

    public Controller(CarRace carRace) {
        this.carRace = carRace;
    }

    public void run() {
        carRace.start();
    }
}
