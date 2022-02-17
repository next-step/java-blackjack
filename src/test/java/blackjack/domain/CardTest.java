package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    void 카드_만들기_테스트() {
        Card card = new Card(CardNumber.ACE, CardType.CLOBER);

        assertThat(card.getCardName()).isEqualTo("A");
        assertThat(card.getCardType()).isEqualTo("클로버");
    }
}
