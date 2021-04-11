package step02;

import java.util.HashMap;
import java.util.Map;

import static step02.LottoConfig.ONE;
import static step02.LottoConfig.ZERO;

public class Ranks {
    private Map<Rank, Integer> ranks = new HashMap<>();

    public void addRanks(Rank rank) {
        if (ranks.containsKey(rank)) {
            int count = ranks.get(rank);
            ranks.put(rank, ++count);
            return;
        }
        ranks.put(rank, ONE);
    }

    public int getNumberOfEachRank(Rank rank) {
        if (ranks.containsKey(rank)) {
            return ranks.get(rank);
        }
        return ZERO;
    }
}
