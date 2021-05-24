package lotto.domains;

public class Cash {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public Cash(int amount) {
        isGreaterThanZero(amount);
        this.amount = amount;
    }

    public int numberOfPurchasesAvailable() {
        return this.amount / LOTTO_PRICE;
    }

    private void isGreaterThanZero(int amount){
        if (amount < LOTTO_PRICE){
            throw new IllegalArgumentException("1000 보다 큰숫자를 입력해주세요");
        }
    }
}
