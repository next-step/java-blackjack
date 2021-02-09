package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardTest {

    @DisplayName("denomination, suit로 생성")
    @Test
    void createCard() {
        // given
        Denomination denomination = Denomination.ACE;
        Suit suit = Suit.CLOVER;

        // when
        Card card = new Card(denomination, suit);

        // then
        assertThat(card.getDenomination()).isEqualTo(denomination);
        assertThat(card.getSuit()).isEqualTo(suit);
    }
}
