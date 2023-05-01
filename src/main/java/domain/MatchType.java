package domain;

public enum MatchType {
    MATCH_THREE(3, 5000),
    MATCH_FOUR(4, 50000),
    MATCH_FIVE(5, 1500000),
    MATCH_SIX(6, 2000000000);

    private final int matchingNumbers;
    private final long prize;

    MatchType(int matchingNumbers, long prize) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public long getPrize() {
        return prize;
    }
}
