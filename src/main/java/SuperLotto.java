import domain.DefaultLottoGenerator;
import domain.LottoGenerator;
import domain.LottoMatcher;
import domain.LottoStatistics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SuperLotto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액 입력");

        int money = scanner.nextInt();
        int lottoCount = money / 1000;

        System.out.println(lottoCount + "개를 구매");

        List<List<Integer>> lottos = generateLottos(lottoCount, new DefaultLottoGenerator());

        System.out.println("lottos = " + lottos);
        System.out.println("지난 주 로또 번호를 입력하세요(쉼표로 구분):");
        scanner.nextLine();
        String lastWeekLottoNumber = scanner.nextLine();

        List<Integer> lastLottoNumbers = parseLottoNumbers(lastWeekLottoNumber);
        LottoStatistics statistics = calculateLottoStatistics(lottos, lastLottoNumbers);

        printLottoStatistics(statistics, money);

    }

    private static void printLottoStatistics(LottoStatistics statistics, int money) {
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

    private static LottoStatistics calculateLottoStatistics(List<List<Integer>> lottos, List<Integer> lastLottoNumbers) {
        LottoStatistics statistics = new LottoStatistics();
        LottoMatcher matcher = new LottoMatcher();

        for (List<Integer> lotto : lottos) {
            int matchCount = matcher.getMatchingCount(lastLottoNumbers, lotto);
            statistics.incrementMatchCount(matchCount);
        }
        return statistics;
    }

    private static List<Integer> parseLottoNumbers(String lastWeekLottoNumber) {
        String[] splitLottoNumbers = lastWeekLottoNumber.split(",");
        return Arrays.stream(splitLottoNumbers)
                     .map(String::trim)
                     .mapToInt(Integer::parseInt)
                     .boxed()
                     .collect(Collectors.toList());
    }

    private static List<List<Integer>> generateLottos(int lottoCount, LottoGenerator generator) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lotto = generator.generateLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private static int LottoMatchingCount(List<Integer> lastLottoNumberList, int count, Integer lottoNumber) {
        for (Integer lastLottoNumber : lastLottoNumberList) {
            if (lottoNumber.equals(lastLottoNumber)) {
                count++;
            }
        }
        return count;
    }
}
