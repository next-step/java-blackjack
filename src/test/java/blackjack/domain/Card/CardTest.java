package blackjack.domain.Card;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    void 카드를_생성한다() {
        Card card1 = new Card(Denomination.ACE, Suit.CLUBS);
        assertThat(new StringBuilder().append(card1.getDenomination().getValue()).append(card1.getSuit()).toString()).isEqualTo("1CLUBS");

        Card card2 = new Card(Denomination.KING, Suit.DIAMONDS);
        assertThat(new StringBuilder().append(card2.getDenomination().getValue()).append(card2.getSuit()).toString()).isEqualTo("10DIAMONDS");

        Card card3 = new Card(Denomination.JACK, Suit.HEARTS);
        assertThat(card3.getDenomination().getValue()).isEqualTo(10);
        assertThat(card3.getSuit().getValue()).isEqualTo("하트");

        Card card4 = new Card(Denomination.TWO, Suit.HEARTS);
        assertThat(card4.getDenomination().getValue()).isEqualTo(2);
        assertThat(card4.getSuit().getValue()).isEqualTo("하트");
    }
}
