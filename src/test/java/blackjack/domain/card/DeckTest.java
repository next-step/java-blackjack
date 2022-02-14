package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class DeckTest {

    @Test
    void 카드번들을_제대로_받는지_테스트() {
        Deck deck = new Deck();
        List<Card> cards = deck.cards();
        assertThat(cards.size()).isEqualTo(52);
    }

    @Test
    void 카드를_한장_뽑아준다() {
        Deck deck = new Deck();
        deck.spreadCard();
        List<Card> cards = deck.cards();
        assertThat(cards.size()).isEqualTo(51);
    }
}