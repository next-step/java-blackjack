package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DeckTest {

    @DisplayName("52장의 카드를 포함한 덱 생성 테스트")
    @Test
    void createDeckTest() {
        // given & when
        Deck deck = Deck.createInitializingCards();

        // then
        assertThat(deck.getCards().size()).isEqualTo(52);
    }
}
