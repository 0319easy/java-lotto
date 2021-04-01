package view;

import domain.LottoNumbers;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import util.CreateAutoNumberMachine;

public class InputView {

    private int money;
    private List<String> winNumbers;

    public InputView(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        this.money = Integer.parseInt(scanner.nextLine());
        int ticketCount = money / 1000;
        System.out.println(ticketCount +"개를 구매했습니다.");
        findWinNumbers(scanner);
    }

    private void findWinNumbers(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        this.winNumbers = Arrays.asList(scanner.nextLine().split(","));
    }

    public int getMoney() {
        return money;
    }

    public LottoNumbers getWinNumbers() {
        return
            CreateAutoNumberMachine
                .createNumbers(
                    winNumbers
                    .stream()
                    .mapToInt(Integer::parseInt)
                    .boxed()
            .collect(Collectors.toList()));
    }
}
