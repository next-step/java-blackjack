package blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeckTest {

    @Test
    void 덱은_52장의_Card를_가진다(){
        final Deck deck = new Deck();
        Integer actual = deck.getSize();
        assertThat(actual).isEqualTo(52);
    }

    @Test
    void 카드를_1장_지급한다(){
        final Deck deck = new Deck();
        final Card actual = deck.getOneCard(0);
        assertThat(actual.getNumber()).isEqualTo(CardNumber.ACE);
        assertThat(actual.getSuit()).isEqualTo(CardSuit.DIAMOND);
    }
}
