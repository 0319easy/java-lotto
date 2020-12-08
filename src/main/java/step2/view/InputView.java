package step2.view;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int getFee() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public List<Integer> getWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winNumberString = scanner.next();
        stringFormatValid(winNumberString);
        return stringToInt(split(winNumberString));
    }

    private void stringFormatValid(String winNumberString) {
        if (isBlank(winNumberString)) {
            throw new IllegalArgumentException("잘못된 당첨번호를 입력했습니다.");
        }
    }

    private boolean isBlank(String winNumberString) {
        return Objects.isNull(winNumberString) || winNumberString.trim().isEmpty();
    }

    private String[] split(String winNumberString) {
        return winNumberString.split(",");
    }

    private List<Integer> stringToInt(String[] split) {
        return Arrays.stream(split).map(m -> parseInt(m))
                .collect(Collectors.toList());
    }

    private int parseInt(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (Exception e) {
            throw new RuntimeException("숫자가 입력되지 않았습니다.");
        }
    }

    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    public int getNotAutoBuyCount() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요");
        return scanner.nextInt();

    }

    public List<List<Integer>> getNotAutoNumbers(int notAutoBuyCount) {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<List<Integer>> lottos = new ArrayList<>();
        for (int count = 0; count < notAutoBuyCount; count++){
            String winNumberString = scanner.next();
            stringFormatValid(winNumberString);
            lottos.add(stringToInt(split(winNumberString)));
        }

        return lottos;
    }
}
