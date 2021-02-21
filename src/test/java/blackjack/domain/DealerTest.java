package blackjack.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DealerTest {
    @Test
    void addCardUnderScoreTest() {
        Deck deck = new Deck(false);
        // K스페이드, Q스페이드
        Dealer dealer1 = new Dealer(deck);
        for (int i = 0; i < 9; i++) {
            deck.popCard();
        }
        // 2스페이드, A스페이드
        Dealer dealer2 = new Dealer(deck);

        Boolean isLowerThreshold1 = dealer1.addCardUnderScore(deck);
        Boolean isLowerThreshold2 = dealer2.addCardUnderScore(deck);
        List<Card> cards1 = dealer1.getCards().getCardList();
        List<Card> cards2 = dealer2.getCards().getCardList();

        Assertions.assertThat(isLowerThreshold1).isFalse();
        Assertions.assertThat(isLowerThreshold2).isTrue();
        Assertions.assertThat(cards1).hasSize(2);
        Assertions.assertThat(cards2).hasSize(3);
    }
}
