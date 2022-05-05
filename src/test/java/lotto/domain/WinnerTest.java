package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.result.LottoGameResult;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    @Test
    void 당첨_테스트() {
        Winner winner = new Winner(2, 4, 5, 6, 7, 8);

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(1, 2, 3, 7, 8, 9));
        lottoList.add(new Lotto(1, 2, 10, 11, 12, 13));

        LottoGameResult lottoGameResult = new LottoGameResult();
        lottoGameResult.addMatchResult(3);
        lottoGameResult.addMatchResult(1);

        assertThat(winner.findWinners(new Lottos(lottoList))).isEqualTo(lottoGameResult);
    }
}
