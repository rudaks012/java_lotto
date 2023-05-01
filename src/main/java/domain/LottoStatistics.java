package domain;

import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private final Map<MatchType, Long> resultMap;

    public LottoStatistics(List<LottoTicket> lottos, Winner winner) {
        LottoResultCalculator calculator = new LottoResultCalculator(lottos, winner);
        this.resultMap = calculator.calculate();
    }

    public void displayResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (MatchType matchType : MatchType.values()) {
            System.out.println(matchType.getMatchingNumbers() + "개 일치 (" + matchType.getPrize() + "원) - " + resultMap.get(matchType) + "개");
        }
    }

    public double calculateProfitRate(int money) {
        return resultMap.entrySet()
                        .stream()
                        .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                        .sum() / money;
    }
}
