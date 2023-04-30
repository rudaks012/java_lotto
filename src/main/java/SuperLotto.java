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
import view.LottoResultPrinter;
import view.UserInput;

public class SuperLotto {

    public static void main(String[] args) {
        UserInput userInput = new UserInput();

        int money = userInput.readPurchaseAmount();
        int lottoCount = money / 1000;

        System.out.println(lottoCount + "개를 구매");
        List<List<Integer>> lottos = generateLottos(lottoCount, new DefaultLottoGenerator());

        System.out.println("lottos = " + lottos);
        List<Integer> lastWeekLottoNumber = userInput.readLastWeekLottoNumbers();

        LottoStatistics statistics = calculateLottoStatistics(lottos, lastWeekLottoNumber);

        LottoResultPrinter.printLottoStatistics(statistics, money);

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

    private static List<List<Integer>> generateLottos(int lottoCount, LottoGenerator generator) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lotto = generator.generateLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

}
