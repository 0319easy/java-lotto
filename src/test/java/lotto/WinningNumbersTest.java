package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨자테스트")
class WinningNumbersTest {
    LottoNumbers lottoNumbers1;
    LottoNumbers lottoNumbers2;
    LottoNumbers lottoNumbers3;
    LottoNumbers lottoNumbers4;
    LottoNumbers lottoNumbers5;
    LottoNumbers lottoNumbers6;
    LottoNumbers lottoNumbers7;
    LottoNumbers lottoNumbers8;
    LottoNumbers lottoNumbers9;
    LottoNumbers lottoNumbers10;
    LottoNumbers lottoNumbers11;
    LottoNumbers lottoNumbers12;
    LottoNumbers lottoNumbers13;
    LottoNumbers lottoNumbers14;

    @Test
    @DisplayName("우승번호찾기")
    void isWinner() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1,3,5,7,9));
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        lottoNumbersList.add(lottoNumbers);
        WinningNumbers winningNumbers = new WinningNumbers(new int[]{1,2,3,4,5,6});
        Map<Integer, Integer> winNumbers = winningNumbers.getWinNumbers(lottoNumbersList);
        System.out.println(winNumbers.toString());
        assertThat(winNumbers.get(3)).isEqualTo(1);
    }

    @Test
    @DisplayName("보너스번호 포함한 우승번호찾기")
    void isWinnerWithBonusNumber() {
        LottoNumbers lottoNumbers1 = new LottoNumbers(Arrays.asList(1,3,5,7,9));
        LottoNumbers lottoNumbers2 = new LottoNumbers(Arrays.asList(5,7,9,11,13));
        LottoNumbers lottoNumbers3 = new LottoNumbers(Arrays.asList(15,17,19,21,23));
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        lottoNumbersList.add(lottoNumbers1);
        lottoNumbersList.add(lottoNumbers2);
        lottoNumbersList.add(lottoNumbers3);
        WinningNumbers winningNumbers = new WinningNumbers(new int[]{1,3,9,11,13,15,17,19,21,25});
        winningNumbers.bonusNumber(23);
        Map<Integer, Integer> winNumbersMap = winningNumbers.getWinNumbers(lottoNumbersList);
        Map<Integer, Integer> bonusNumberMap = winningNumbers.getBonusNumber();
        System.out.println(winNumbersMap.toString());
        assertThat(winNumbersMap.get(3)).isEqualTo(2);
        assertThat(winNumbersMap.get(4)).isEqualTo(1);
        assertThat(winNumbersMap.get(5)).isEqualTo(0);
        assertThat(bonusNumberMap.get(3)).isEqualTo(0);
        assertThat(bonusNumberMap.get(4)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률 반환")
    void earningsRate() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1,3,5,7,9));
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        lottoNumbersList.add(lottoNumbers);
        WinningNumbers winningNumbers = new WinningNumbers(new int[]{1,3,5});
        winningNumbers.bonusNumber(7);
        Map<Integer, Integer> winNumbersMap = winningNumbers.getWinNumbers(lottoNumbersList);
        Map<Integer, Integer> bonusNumberMap = winningNumbers.getBonusNumber();
        System.out.println(winNumbersMap.toString());
        assertThat(winNumbersMap.get(3)).isEqualTo(0);
        assertThat(winNumbersMap.get(4)).isEqualTo(1);
        assertThat(winNumbersMap.get(5)).isEqualTo(0);
        assertThat(bonusNumberMap.get(4)).isEqualTo(1);
        assertThat(winningNumbers.earningsRate(1000)).isEqualTo(50);
    }

    @Test
    @DisplayName("명시되있지 않지만, 예제를 보면 소수2자릿수까지 내림으로 보여진다")
    void down() {
        double result = Math.floor((double) 5000/14000 * 100.0) / 100.0;
        assertThat(result).isEqualTo(0.35);
    }

    @Test
    @DisplayName("당첨번호의 갯수를 찾는다.")
    void ex1() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();

        lottoNumbers.add(lottoNumbers1);
        lottoNumbers.add(lottoNumbers2);
        lottoNumbers.add(lottoNumbers3);
        lottoNumbers.add(lottoNumbers4);
        lottoNumbers.add(lottoNumbers5);
        lottoNumbers.add(lottoNumbers6);
        lottoNumbers.add(lottoNumbers7);
        lottoNumbers.add(lottoNumbers8);
        lottoNumbers.add(lottoNumbers9);
        lottoNumbers.add(lottoNumbers10);
        lottoNumbers.add(lottoNumbers11);
        lottoNumbers.add(lottoNumbers12);
        lottoNumbers.add(lottoNumbers13);
        lottoNumbers.add(lottoNumbers14);

        WinningNumbers winningNumbers = new WinningNumbers(new int[]{1, 2, 3, 4, 5, 6});
        assertThat(winningNumbers.getWinNumbers(lottoNumbers).get(3))
                .isEqualTo(1);
        assertThat(winningNumbers.getWinNumbers(lottoNumbers).get(4))
                .isEqualTo(0);
        assertThat(winningNumbers.getWinNumbers(lottoNumbers).get(5))
                .isEqualTo(0);
        assertThat(winningNumbers.getWinNumbers(lottoNumbers).get(6))
                .isEqualTo(0);
    }

    @BeforeEach
    void init() {
        lottoNumbers1 = new LottoNumbers(Arrays.asList(8, 21, 23, 41, 42, 43));
        lottoNumbers2 = new LottoNumbers(Arrays.asList(3, 5, 11, 16, 32, 38));
        lottoNumbers3 = new LottoNumbers(Arrays.asList(7, 11, 16, 35, 36, 44));
        lottoNumbers4 = new LottoNumbers(Arrays.asList(1, 8, 11, 31, 41, 42));
        lottoNumbers5 = new LottoNumbers(Arrays.asList(13, 14, 16, 38, 42, 45));
        lottoNumbers6 = new LottoNumbers(Arrays.asList(7, 11, 30, 40, 42, 43));
        lottoNumbers7 = new LottoNumbers(Arrays.asList(2, 13, 22, 32, 38, 45));
        lottoNumbers8 = new LottoNumbers(Arrays.asList(23, 25, 33, 36, 39, 41));
        lottoNumbers9 = new LottoNumbers(Arrays.asList(1, 3, 5, 14, 22, 45));
        lottoNumbers10 = new LottoNumbers(Arrays.asList(5, 9, 38, 41, 43, 44));
        lottoNumbers11 = new LottoNumbers(Arrays.asList(2, 8, 9, 18, 19, 21));
        lottoNumbers12 = new LottoNumbers(Arrays.asList(13, 14, 18, 21, 23, 35));
        lottoNumbers13 = new LottoNumbers(Arrays.asList(17, 21, 29, 37, 42, 45));
        lottoNumbers14 = new LottoNumbers(Arrays.asList(3, 8, 27, 30, 35, 44));
    }
}
