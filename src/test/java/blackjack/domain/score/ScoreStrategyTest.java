package blackjack.domain.score;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Number;
import blackjack.domain.card.Suit;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ScoreStrategyTest {

    static List<Card> aceContains;
    static List<Card> defaultCards;

    @BeforeAll
    static void setUp() {
        aceContains = Arrays.asList(new Card(Suit.DIAMOND, Number.ACE),
            new Card(Suit.CLOVER, Number.JACK));
        defaultCards = Arrays.asList(new Card(Suit.CLOVER, Number.EIGHT),
            new Card(Suit.SPADE, Number.FOUR));
    }

    @Test
    void ACE전략으로_ACE를_갖고_있다면_11로_점수를_계산한다() {
        ScoreStrategy scoreStrategy = new AceScoreStrategy();
        assertThat(scoreStrategy.isSupportable(aceContains)).isTrue();
        assertThat(scoreStrategy.isSupportable(defaultCards)).isFalse();
        assertThat(scoreStrategy.calculateScore(aceContains)).isEqualTo(21);
        assertThat(scoreStrategy.calculateScore(defaultCards)).isEqualTo(12);
    }

    @Test
    void 기본전략으로_모든_카드의_합을_구할_수_있다() {
        ScoreStrategy scoreStrategy = new DefaultScoreStrategy();
        assertThat(scoreStrategy.isSupportable(aceContains)).isTrue();
        assertThat(scoreStrategy.isSupportable(defaultCards)).isTrue();
        assertThat(scoreStrategy.calculateScore(aceContains)).isEqualTo(11);
        assertThat(scoreStrategy.calculateScore(defaultCards)).isEqualTo(12);
    }
}