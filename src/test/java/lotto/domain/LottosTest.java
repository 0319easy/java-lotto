package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.result.LottoGameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    List<Integer> numbers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
    }

    @Test
    void 로또_당첨_테스트() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(1, 2, 3, 7, 8, 9));
        lottoList.add(new Lotto(1, 2, 10, 11, 12, 13));

        LottoGameResult lottoGameResult = new LottoGameResult();
        lottoGameResult.addMatchResult(3);
        lottoGameResult.addMatchResult(2);

        assertThat(new Lottos(lottoList).matchNumbers(numbers)).isEqualTo(lottoGameResult);
    }
}
