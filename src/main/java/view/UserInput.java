package view;

import java.util.Scanner;

public class UserInput {

    private final Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public String readLastWeekLottoNumbers() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner1.nextLine();
    }
}
