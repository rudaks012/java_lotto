package domain;

public class LottoStatistics {

    private int matchThree;
    private int matchFour;
    private int matchFive;
    private int matchSix;

    public void incrementMatchCount(int matchCount) {
        switch (matchCount) {
            case 3:
                matchThree++;
                break;
            case 4:
                matchFour++;
                break;
            case 5:
                matchFive++;
                break;
            case 6:
                matchSix++;
                break;
        }
    }

    public double calculateProfitRate(int money) {
        return (double) ((matchThree * 5000) + (matchFour * 50000) + (matchFive * 1500000) + (matchSix * 2000000000)) / money;
    }

    public int getMatchThree() {
        return matchThree;
    }

    public int getMatchFour() {
        return matchFour;
    }

    public int getMatchFive() {
        return matchFive;
    }

    public int getMatchSix() {
        return matchSix;
    }
}
