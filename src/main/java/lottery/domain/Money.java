package lottery.domain;

import lottery.utils.NumberUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money implements Comparable<Money> {

    private static final String NOT_ENOUGH_MONEY = "로또를 구매하기에 돈이 부족합니다 -> ";

    private int money;

    public Money(final String money) {
        validateMoney(money);
        this.money = Integer.parseInt(money);
    }

    public Money(final int money) {
        NumberUtils.requirePositiveNumber(money);
        this.money = money;
    }

    public LotteryQuantity getBuyableLotteryQuantity() {
        requireOverLotteryPrice();
        return new LotteryQuantity( money / Lottery.PRICE.money);
    }

    public int multiply(int number) {
        return money * number;
    }

    public BigDecimal divide(long number) {
        return new BigDecimal(this.money)
                .divide(new BigDecimal(number), 4, RoundingMode.HALF_UP);
    }

    public void extractLotteryPrice() {
        requireOverLotteryPrice();
        money -= Lottery.PRICE.money;
    }

    private void validateMoney(final String money) {
        NumberUtils.requireNonNull(money);
        NumberUtils.requireNumber(money);
        NumberUtils.requirePositiveNumber(Integer.parseInt(money));
    }

    private void requireOverLotteryPrice() {
        if (money < Lottery.PRICE.money) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY + money);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    @Override
    public int compareTo(final Money money) {
        return this.money - money.money;
    }

    @Override
    public String toString() {
        return String.valueOf(money);
    }
}
