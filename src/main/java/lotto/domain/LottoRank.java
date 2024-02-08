package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    NONE(0, 0);

    private final int prize;
    private final int matchCount;
    private final boolean matchBonus;

    LottoRank(int prize, int matchCount, boolean matchBonus) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    LottoRank(int prize, int matchCount) {
        this(prize, matchCount, false);
    }

    public static LottoRank of(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.match(matchCount, matchBonus))
                .findFirst()
                .orElse(NONE);
    }

    private boolean match(int matchCount, boolean matchBonus) {
        return this.matchCount == matchCount && this.matchBonus == matchBonus;
    }

    public int getPrize() {
        return prize;
    }
}
