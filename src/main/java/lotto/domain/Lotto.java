package lotto.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    public final static int LOTTO_LENGTH = 6;
    public final static int LOTTO_START_NUMBER = 1;
    public final static int LOTTO_END_NUMBER = 45;
    public final static int LOTTO_PRICE = 1000;

    protected Set<Integer> numbers;

    Lotto(int num1, int num2, int num3, int num4, int num5, int num6) {
        this(Set.of(num1, num2, num3, num4, num5, num6));
    }

    public Lotto(Set<Integer> numbers) {
        if (numbers == null || numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("숫자 " + LOTTO_LENGTH + "개만 입력 가능합니다");
        }

        this.numbers = new HashSet<>(numbers);
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public LOTTO_REWARD hasWinningNumbers(Set<Integer> winningNumbers, int bonusNumber) {
        int result = 0;
        for (int winningNumber : winningNumbers) {
            result += hasNumber(winningNumber);
        }

        boolean isBonusMatched = numbers.contains(bonusNumber);

        return LOTTO_REWARD.of(result, isBonusMatched);
    }

    private int hasNumber(int number) {
        if (numbers.contains(number)) {
            return 1;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) obj;
        return this.numbers.equals(lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
