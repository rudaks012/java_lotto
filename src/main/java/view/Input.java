package view;

import java.util.Scanner;

public class Input {

    public String enterAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public String enterLastWeekLotto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

}
