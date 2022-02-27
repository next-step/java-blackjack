package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ScoreTest {

    @Test
    void 플레이어와_딜러의_카드를_비교해_승무패를_판단할_수_있다() {
        Cards playerCards = new Cards(Arrays.asList(new Card(CardNumber.EIGHT, Suit.CLUB),
            new Card(CardNumber.SEVEN, Suit.CLUB)));
        Cards dealerCards = new Cards(Arrays.asList(new Card(CardNumber.FIVE, Suit.CLUB),
            new Card(CardNumber.FOUR, Suit.CLUB)));

        Score judge = Score.judge(playerCards, dealerCards);

        assertThat(judge).isEqualTo(Score.WIN);
    }

    @Test
    void 승패_결과를_뒤집는다() {
        Score oppositeScore = Score.WIN.oppositeScore();

        assertThat(oppositeScore).isEqualTo(Score.LOSE);
    }
}
