package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;
import lotto.domain.PurchaseQuantity;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String WINNING_LOTTO_NUMBERS_DELIMITER = ",";

    private final Scanner scanner;

    private InputView(Scanner scanner) {
        this.scanner = Objects.requireNonNull(scanner);
    }

    public static InputView of(InputStream inputStream) {
        return new InputView(new Scanner(inputStream));
    }

    public PurchaseQuantity getTotalPurchaseQuantity() {
        String input = scanner.nextLine();
        Money money = Money.of(Integer.parseInt(input));
        return PurchaseQuantity.of(money);
    }

    public LottoNumbers getWinningLottoNumbers() {
        String input = scanner.nextLine();
        return LottoNumbers.of(parseWinningLottoNumbers(input));
    }

    private List<LottoNumber> parseWinningLottoNumbers(String input) {
        return Arrays.stream(input.split(WINNING_LOTTO_NUMBERS_DELIMITER))
                .map(numberString -> LottoNumber.of(Integer.parseInt(numberString.trim())))
                .collect(Collectors.toList());
    }

    public LottoNumber getBonusBall() {
        return LottoNumber.of(Integer.parseInt(scanner.nextLine()));
    }

    public PurchaseQuantity getManualPurchaseQuantity() {
        return PurchaseQuantity.of(Long.parseLong(scanner.nextLine()));
    }
}
