package blackjack.model;

import blackjack.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeckTest {
    @Test
    @DisplayName("처음에 카드를 만들었을 때, 카드의 숫자가 52장인 지, 확인하는 테스트")
    void deckAmountTest() {
        final ShuffleStrategy emptyShuffleStrategy = new EmptyShuffleStrategy();
        final Deck deck = new Deck(emptyShuffleStrategy);
        final int amount = deck.getAmount();
        assertThat(amount).isEqualTo(52);
    }

    @Test
    @DisplayName("카드를 한 장 나눠준 후에, 덱에 남은 카드를 확인하는 테스트")
    void deckGetCardTest(){
        final ShuffleStrategy emptyShuffleStrategy = new EmptyShuffleStrategy();
        final Deck deck = new Deck(emptyShuffleStrategy);
        final Card card = deck.getCard();
        assertThat(card).isEqualTo(new Card(CardType.CLOVER, CardValue.KING));
    }
}
