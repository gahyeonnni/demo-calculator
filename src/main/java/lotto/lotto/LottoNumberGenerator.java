package lotto.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator implements NumberGenerator {
    @Override
    public List <Integer> generate(int min, int max, int count) {
        List <Integer> lottoArray = Randoms.pickUniqueNumbersInRange(min, max, count);
        Collections.sort(lottoArray);
        return lottoArray;
    }
}