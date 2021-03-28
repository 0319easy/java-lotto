package lotto.step2.view;

import java.util.Scanner;

public class InputView {
    private final static String MESSAGE_PURCHASING_AMOUNT = "구입금액을 입력해 주세요.";
    private final static String MESSAGE_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private final static String DELIMITER_COMMA = ",";
    private final static Scanner scanner = new Scanner(System.in);
    

    private InputView() {
    }

    public static String enterPurchasingAmount() {
        System.out.println(MESSAGE_PURCHASING_AMOUNT);
        return scanner.next();
    }

    public static String[] enterWinningNumber() {
        System.out.println(MESSAGE_WINNING_NUMBER);
        scanner.nextLine();
        return scanner.nextLine().split(DELIMITER_COMMA);
    }
}
