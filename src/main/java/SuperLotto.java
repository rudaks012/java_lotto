import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SuperLotto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액 입력");

        int money = scanner.nextInt();
        int lottoCount = money / 1000;

        System.out.println(lottoCount + "개를 구매");

        List<List<Integer>> lottos = new ArrayList<>();

        shuffleLottos(lottoCount, lottos);
        System.out.println("lottos = " + lottos);

        Scanner inputLastWeek = new Scanner(System.in);

        String lastWeekLottoNumber = inputLastWeek.nextLine();
        String[] splitLottoNumbers = lastWeekLottoNumber.split(",");

        List<String> lottoList = List.of(splitLottoNumbers);
        List<Integer> lastLottoNumberList = getStringToIntegerList(lottoList);

        int matchThreeLottoNumer = 0;
        int matchFourLottoNumber = 0;
        int matchFiveLottoNumber = 0;
        int matchSixLottoNumber = 0;
        int count = 0;

        for (List<Integer> lotto : lottos) {

            getCount(lastLottoNumberList, count, lotto);

            if (count == 3) {
                matchThreeLottoNumer++;
            } else if (count == 4) {
                matchFourLottoNumber++;
            } else if (count == 5) {
                matchFiveLottoNumber++;
            } else if (count == 6) {
                matchSixLottoNumber++;
            }
            count = 0;
        }

        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + matchThreeLottoNumer + "개");
        System.out.println("4개 일치 (50000원)- " + matchFourLottoNumber + "개");
        System.out.println("5개 일치 (1500000원)-" + matchFiveLottoNumber + "개");
        System.out.println("6개 일치 (2000000000원)-" + matchSixLottoNumber + "개");

        double profit = getProfit(money, matchThreeLottoNumer, matchFourLottoNumber, matchFiveLottoNumber, matchSixLottoNumber);
        String StringProfit = String.format("%.2f", profit);

        System.out.println("총 수익률은" + StringProfit + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");

    }

    private static void getCount(List<Integer> lastLottoNumberList, int count, List<Integer> lotto) {
        for (Integer lottoNumber : lotto) {
            LottoMatchingCount(lastLottoNumberList, count, lottoNumber);
        }
    }

    private static void LottoMatchingCount(List<Integer> lastLottoNumberList, int count, Integer lottoNumber) {
        for (Integer lastLottoNumber : lastLottoNumberList) {
            if (lottoNumber.equals(lastLottoNumber)) {
                count++;
            }
        }
    }

    private static List<Integer> getStringToIntegerList(List<String> lottoList) {
        List<Integer> lastLottoNumberList = new ArrayList<>();
        for (String number : lottoList) {
            lastLottoNumberList.add(Integer.parseInt(number.trim()));
        }
        return lastLottoNumberList;
    }

    private static void shuffleLottos(int lottoCount, List<List<Integer>> lottos) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> preparedLottoNumbers = new ArrayList<>();

            createLotto(preparedLottoNumbers);
            Collections.shuffle(preparedLottoNumbers);

            List<Integer> lotto = preparedLottoNumbers.subList(0, 6);
            lottos.add(lotto);
        }
    }

    private static void createLotto(List<Integer> preparedLottoNumbers) {
        for (int j = 1; j <= 45; j++) {
            preparedLottoNumbers.add(j);
        }
    }



    private static double getProfit(int money, int matchThree, int matchFour, int matchFive, int matchSix) {
        return (double) ((matchThree * 5000) + (matchFour * 50000) + (matchFive * 1500000) + (matchSix * 2000000000)) / money;
    }

}
