package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.MatchResult;
import lotto.domain.Money;
import lotto.domain.Rank;

import java.io.PrintStream;
import java.util.List;
import java.util.Objects;

public class OutputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String PURCHASE_QUANTITY_MESSAGE_FORMAT = "%d개를 구매했습니다. %n";
    private static final String DEFAULT_MATCH_RESULT_MESSAGE_FORMAT = "%d개 일치 (%s원)- %d개 %n";
    private static final String SECOND_RANK_MATCH_RESULT_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치(%s원)- %d개 %n";
    private static final String MATCHES_RESULT_MASSAGE = "당첨 통계\n------------------";
    private static final String LOTTERY_YIELD_MASSAGE_FORMAT = "총 수익률은 %.2f 입니다. %n";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";

    private final PrintStream printStream;

    private OutputView(PrintStream printStream) {
        this.printStream = Objects.requireNonNull(printStream);
    }

    public static OutputView of(PrintStream printStream) {
        return new OutputView(printStream);
    }

    public void printPurchaseAmountInputMessage() {
        printStream.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printPurchaseCount(long quantity) {
        printStream.println();
        printStream.printf(PURCHASE_QUANTITY_MESSAGE_FORMAT, quantity);
    }

    public void printLottoTicket(List<LottoNumbers> lottoNumbers) {
        lottoNumbers.forEach(this::printLottoNumbers);
    }

    private void printLottoNumbers(LottoNumbers lottoNumbers) {
        printStream.println(lottoNumbers.toString());
    }

    public void printWinningLottoNumbersInputMessage() {
        printStream.println();
        printStream.println(INPUT_WINNING_LOTTO_NUMBERS_MESSAGE);
    }

    public void printMatchResult(MatchResult matchResult) {
        printStream.println();
        printStream.println(MATCHES_RESULT_MASSAGE);
        for (Rank rank : Rank.winningValues()) {
            printMatchCount(rank, matchResult.countWinningLotteries(rank));
        }
    }

    public void printMatchCount(Rank rank, int count) {
        if (rank.isSecond()) {
            printStream.printf(SECOND_RANK_MATCH_RESULT_MESSAGE_FORMAT, rank.getCountOfMatchForWinning(), rank.getWinningMoney(), count);
            return;
        }
        printStream.printf(DEFAULT_MATCH_RESULT_MESSAGE_FORMAT, rank.getCountOfMatchForWinning(), rank.getWinningMoney(), count);
    }

    public void printLotteryYield(Money purchaseAmount, Money winningAmount) {
        printStream.printf(LOTTERY_YIELD_MASSAGE_FORMAT, winningAmount.divide(purchaseAmount));
    }

    public void printBonusBallInputMessage() {
        printStream.println(INPUT_BONUS_BALL_MESSAGE);
    }
}
