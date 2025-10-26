package racingcar.view;

import racingcar.race.Car;
import java.util.List;
import java.util.stream.IntStream;

public class OutputResultView {
    public void printAskCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAskCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printStartMessage() {
        System.out.println("실행 결과");
    }

    public void printRoundResult(List<Car> cars) {
        cars.stream()
                .map(car -> car.getName() + " : " + "-".repeat(car.getPosition()))
                .forEach(System.out::println);
        System.out.println();
    }

    public void printFinalWinners(List<String> winners) {
        String result = IntStream.range(0, winners.size())
                .mapToObj(i -> (i < winners.size() - 1)
                        ? winners.get(i) + ", "
                        : winners.get(i))
                .reduce("", String::concat);

        System.out.println("최종 우승자 : " + result);
    }
}
