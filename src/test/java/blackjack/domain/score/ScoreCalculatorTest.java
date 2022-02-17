package blackjack.domain.score;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Number;
import blackjack.domain.card.Suit;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ScoreCalculatorTest {

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
    void ACE_포함시_ACE_전략을_가진_계산기를_반환한다() {
        ScoreCalculator scoreCalculator = ScoreCalculator.findByCards(aceContains);
        assertThat(scoreCalculator).isEqualTo(ScoreCalculator.ACE);
    }

    @Test
    void ACE가_없을_시_기본_전략을_가진_계산기를_반환한다() {
        ScoreCalculator scoreCalculator = ScoreCalculator.findByCards(defaultCards);
        assertThat(scoreCalculator).isEqualTo(ScoreCalculator.DEFAULT);
    }

    @Test
    void 각_카드에_맞는_전략에_따라_값을_계산할_수_있다() {
        int aceScore = ScoreCalculator.findByCards(aceContains)
            .calculateScore(aceContains);
        int defaultScore = ScoreCalculator.findByCards(defaultCards)
            .calculateScore(defaultCards);
        assertThat(aceScore).isEqualTo(21);
        assertThat(defaultScore).isEqualTo(12);
    }
}