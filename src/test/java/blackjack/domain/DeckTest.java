package blackjack.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeckTest {
    @Test
    void popCardTest() {
        // given
        Deck deck = new Deck(false);
        Card cardTarget1 = new Card(Suit.SPADES, Denomination.KING);
        Card cardTarget2 = new Card(Suit.SPADES, Denomination.QUEEN);

        // when
        Card card1 = deck.popCard();
        Card card2 = deck.popCard();

        // then
        Assertions.assertThat(card1).isEqualToComparingFieldByField(cardTarget1);
        Assertions.assertThat(card2).isEqualToComparingFieldByField(cardTarget2);
    }
}
