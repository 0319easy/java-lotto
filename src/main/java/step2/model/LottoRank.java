package step2.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public enum LottoRank {
    MATCH_SIX(2_000_000_000, 6),
    MATCH_BONUS(30_000_000, 5),
    MATCH_FIVE(1_500_000, 5),
    MATCH_FOUR(50_000, 4),
    MATCH_THREE(5_000, 3),
    MISS(0, 0);

    public static final List<LottoRank> WINNINGS = Arrays.asList(MATCH_THREE, MATCH_FOUR, MATCH_FIVE, MATCH_BONUS, MATCH_SIX);

    private final long price;
    private final long matchCount;


    LottoRank(long price, long matchCount) {
        this.price = price;
        this.matchCount = matchCount;
    }

    public long getPrice() {
        return price;
    }

    public long getMatchCnt() {
        return matchCount;
    }

    public static Stream<LottoRank> stream() {
        return Stream.of(MATCH_SIX, MATCH_BONUS, MATCH_FIVE, MATCH_FOUR, MATCH_THREE);
    }

    public static LottoRank valueOf(long matchCnt, boolean matchBonus) {
        return stream().filter(rank -> rank.matchCount == matchCnt)
                .filter(rank -> !rank.equals(MATCH_BONUS) || matchBonus )
                .findAny().orElse(MISS);
    }
}
