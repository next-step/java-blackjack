package blackjack.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeckTest {
    @Test
    @DisplayName("처음에 카드를 만들고, 52장의 카드를 뽑은 후에, 에러가 나는 지 확인하는 테스트")
    void deckAmountTest() {
        final ShuffleStrategy emptyShuffleStrategy = new EmptyShuffleStrategy();
        final Deck deck = new Deck(emptyShuffleStrategy);
        for(int i = 0; i< 52; i ++){
            deck.getCard();
        }

        assertThrows(EmptyStackException.class, deck::getCard);
    }

    @Test
    @DisplayName("카드를 한 장 나눠준 후에, 덱에 남은 카드를 확인하는 테스트")
    void deckGetCardTest() {
        final ShuffleStrategy emptyShuffleStrategy = new EmptyShuffleStrategy();
        final Deck deck = new Deck(emptyShuffleStrategy);
        final Card card = deck.getCard();
        assertThat(card).isEqualTo(new Card(CardType.CLOVER, CardValue.KING));
    }
}
