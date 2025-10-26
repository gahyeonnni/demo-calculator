package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator implements NumberGenerator{
    @Override
    public List<Integer> generateForRound(int carCount) {
        return IntStream.range(0, carCount)
                .mapToObj(i -> generate())
                .collect(Collectors.toList());
    }

    private int generate(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }
}
