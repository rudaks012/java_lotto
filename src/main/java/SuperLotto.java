import domain.DefaultLottoGenerator;
import domain.LottoGenerator;
import domain.LottoMatcher;
import domain.LottoStatistics;
import domain.LottoTicket;
import domain.LottoTicketParser;
import domain.PurchaseAmount;
import domain.Winner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import view.LottoResultPrinter;
import view.UserInput;

public class SuperLotto {

    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        PurchaseAmount amount = new PurchaseAmount(userInput.readPurchaseAmount());

        int lottoCount = amount.calculateLottoTicketCount();

        System.out.println(lottoCount + "개를 구매");
        LottoGenerator generator = new DefaultLottoGenerator();
        List<LottoTicket> lottos = IntStream.range(0, lottoCount)
                                            .mapToObj(i -> generator.generateLottoTicket())
                                            .collect(Collectors.toList());

        System.out.println("lottos = " + lottos);
        String lastWeekLottoNumberInput = userInput.readLastWeekLottoNumbers();
        LottoTicket lastWeekLottoTicket = LottoTicketParser.parse(lastWeekLottoNumberInput);

        Winner winner = new Winner(lastWeekLottoTicket);

        LottoStatistics statistics = new LottoStatistics(lottos, winner);
        statistics.displayResult();

        double profitRate = statistics.calculateProfitRate(amount.getValue());
        System.out.printf("총 수익률은 %.2f입니다.", profitRate);
    }
}
