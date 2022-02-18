package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardTest {

    @DisplayName("카드 객체 생성 테스트")
    @Test
    void createCardTest() {
        Card card = new Card(CardNumber.ACE, CardPattern.CLOVER);
        assertThat(card.toString()).isEqualTo("A클로버");
    }
}