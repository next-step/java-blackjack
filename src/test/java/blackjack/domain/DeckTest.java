package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DeckTest {

    @DisplayName("52장의 카드를 포함한 덱 생성 테스트")
    @Test
    void createDeckTest() {
        // given & when
        Deck deck = Deck.createShuffledCards();

        // then
        assertThat(deck.getCards().size()).isEqualTo(52);
    }

    @DisplayName("draw()를 호출하면 가장 앞의 Card를 꺼내온다")
    @Test
    void drawTest() {
        // given
        Deck deck = Deck.createShuffledCards();
        List<Card> cards = deck.getCards();
        Card firstCard = cards.get(0);
        Card secondCard = cards.get(1);

        // when
        Card card0 = deck.draw();
        Card card1 = deck.draw();

        // then
        assertThat(card0).isEqualTo(firstCard);
        assertThat(card1).isEqualTo(secondCard);
    }
}
