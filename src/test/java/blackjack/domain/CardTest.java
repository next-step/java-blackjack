package blackjack.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardTest {
    @DisplayName("카드 속성에 따라 이름을 표기한다")
    @Test
    void givenCard_whenCallToString_ThenReturnName() {
        Card card = new Card(Suit.HEARTS, Denomination.FIVE);
        assertThat(card.toString()).isEqualTo("5하트");
    }
}
