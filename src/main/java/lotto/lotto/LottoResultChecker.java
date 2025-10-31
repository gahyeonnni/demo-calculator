package lotto.lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultChecker {

    public Map<LottoRank, Integer> checkResults(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoRank, Integer> resultMap = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            resultMap.put(rank, 0);
        }
        for (Lotto lotto : purchasedLottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            LottoRank rank = LottoRank.checkRank(matchCount, bonusMatch);
            resultMap.put(rank, resultMap.get(rank) + 1);
        }
        return resultMap;
    }

    public double calculateProfitRate(Map<LottoRank, Integer> results, int purchaseAmount) {
        long totalPrize = results.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();

        double rate = (double) totalPrize / purchaseAmount * 100;
        return Math.round(rate * 10) / 10.0;
    }
}
