package blackjack.domain.state;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Cards;
import blackjack.domain.player.CardDeck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StartedTest {

    private Started startedState;
    private Cards cards;

    @BeforeEach
    void init() {
        cards = new Cards();
        cards.add((PlayingCard) CardDeck.getPlayingCard());
        cards.add((PlayingCard) CardDeck.getPlayingCard());
        startedState = new Hit(cards);
    }

    @DisplayName("현재 가지고 있는 카드 제대로 반환하는지 확인하는 테스트")
    @Test
    void getCardsTest() {
        assertThat(startedState.cards()).isEqualToComparingFieldByField(cards);
    }
}