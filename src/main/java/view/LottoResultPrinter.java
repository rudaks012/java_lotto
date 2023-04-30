package view;

import domain.LottoStatistics;

public class LottoResultPrinter {
    public static void printLottoStatistics(LottoStatistics statistics, int money) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + statistics.getMatchThree() + "개");
        System.out.println("4개 일치 (50000원)- " + statistics.getMatchFour() + "개");
        System.out.println("5개 일치 (1500000원)-" + statistics.getMatchFive() + "개");
        System.out.println("6개 일치 (2000000000원)-" + statistics.getMatchSix() + "개");

        double profitRate = statistics.calculateProfitRate(money);
        String formatProfitRate = String.format("%.2f", profitRate);
        System.out.println("총 수익률은" + formatProfitRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }


}
