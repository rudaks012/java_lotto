package domain;

import java.util.List;

public class LottoStatistics {

    private final List<LottoTicket> lottos;
    private final Winner winner;

    public LottoStatistics(List<LottoTicket> lottos, Winner winner) {
        this.lottos = lottos;
        this.winner = winner;
    }

    public void displayResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + countMatch(3) + "개");
        System.out.println("4개 일치 (50000원) - " + countMatch(4) + "개");
        System.out.println("5개 일치 (1500000원) - " + countMatch(5) + "개");
        System.out.println("6개 일치 (2000000000원) - " + countMatch(6) + "개");
    }

    public double calculateProfitRate(int money) {
        return (countMatch(3) * 5000 + countMatch(4) * 50000 + countMatch(5) * 1500000 + countMatch(6) * 2000000000) / (double) money;
    }


    private long countMatch(int count) {
        return lottos.stream()
                     .mapToInt(ticket -> LottoMatcher.matchCount(ticket, winner.getWinnerTicket()))
                     .filter(matches -> matches == count)
                     .count();
    }
}
