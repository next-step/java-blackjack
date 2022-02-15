package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeckTest {
    public static final int TOTAL_CARDS_COUNT = 52;
    public static final int ONE = 1;

    @DisplayName("덱을 생성하면 52개의 카드를 생성한다")
    @Test
    void testConstructor() {
        Deck deck = new Deck();
        assertThat(deck.getCardsCount()).isEqualTo(TOTAL_CARDS_COUNT);
    }

    @DisplayName("카드를 한 장씩 꺼낸다")
    @Test
    void testPopCard() {
        Deck deck = new Deck();
        deck.popCard();
        assertThat(deck.getCardsCount()).isEqualTo(TOTAL_CARDS_COUNT - ONE);
    }
}