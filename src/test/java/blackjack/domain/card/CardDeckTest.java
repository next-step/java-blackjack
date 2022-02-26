package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardDeckTest {

    @Test
    @DisplayName("CardDeck 생성 테스트")
    void createCardDeckTest() {
        CardDeck.makeCardDeck();
        assertThat(CardDeck.getCards().size()).isEqualTo(48);
    }
}