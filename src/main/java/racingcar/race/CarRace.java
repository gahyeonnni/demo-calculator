package racingcar.race;

import racingcar.controller.GameStartCommand;
import racingcar.errorMessage.ErrorMessage;
import racingcar.view.InputReader;
import racingcar.view.OutputResultView;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRace {
    private final int MOVING_FORWARD = 4;
    private final String COUNT_REGEX = "\\d+";
    private final CarNameParser carNameParser;
    private final NumberGenerator randomNumberGenerator;
    private final InputReader inputReader;
    private final OutputResultView outputResultView;
    private final RaceResult raceResult;

    public CarRace(CarNameParser carNameParser,
                   NumberGenerator randomNumberGenerator,
                   InputReader inputReader,
                   OutputResultView outputResultView,
                   RaceResult raceResult) {
        this.carNameParser = carNameParser;
        this.randomNumberGenerator = randomNumberGenerator;
        this.inputReader = inputReader;
        this.outputResultView = outputResultView;
        this.raceResult = raceResult;
    }

    public void start() {
        outputResultView.printAskCarNames();
        String names = inputReader.read();

        outputResultView.printAskCount();
        String count = inputReader.read();

        GameStartCommand input = new GameStartCommand(names, count);
        List<Car> finalCars = getRaceResult(input);
        List<String> winners = raceResult.findWinners(finalCars);

        outputResultView.printFinalWinners(winners);
    }

    public List<Car> getRaceResult(GameStartCommand input) {
        validateNullOrEmpty(input.names());
        validateCountList(input.count());

        String[] nameList = carNameParser.getCarName(input.names());
        int roundCount = Integer.parseInt(input.count());

        List<Car> cars = List.of(nameList).stream()
                .map(Car::new)
                .collect(Collectors.toList());

        outputResultView.printStartMessage();

        IntStream.range(0, roundCount)
                .forEach(i -> {
                    List<Integer> randoms = randomNumberGenerator.generateForRound(cars.size());
                    moveCars(cars, randoms);
                    outputResultView.printRoundResult(cars);
                });

        return cars;
    }

    private void moveCars(List<Car> cars, List<Integer> randoms) {
        IntStream.range(0, cars.size())
                .filter(i -> canMove(randoms.get(i)))
                .forEach(i -> cars.get(i).move());
    }
    
    private boolean canMove(int a) {
        return a >= MOVING_FORWARD;
    }

    private void validateCountList(String count) {
        validateNullOrEmpty(count);
        if (!count.matches(COUNT_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_COUNT.message());
        }
    }

    private void validateNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT.message());
        }
    }
}
