package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<Integer> numbers = new ArrayList<>();

    Winner(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("숫자 6개만 입력 가능합니다");
        }

        this.numbers = numbers;
    }

    Winner(int num1, int num2, int num3, int num4, int num5, int num6) {
        this.numbers.add(num1);
        this.numbers.add(num2);
        this.numbers.add(num3);
        this.numbers.add(num4);
        this.numbers.add(num5);
        this.numbers.add(num6);
    }

    public int findWinner(Lotto lotto) {

        return lotto.hasWinningNumbers(numbers);
    }
}
