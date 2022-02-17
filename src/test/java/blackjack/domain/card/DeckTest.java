package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DeckTest {

    @Test
    void 카드뭉치를_제대로_받는지_테스트() {
        CardFactory cardFactory = CardFactory.getInstance();
        Deck deck = new Deck(cardFactory.createCards());
        assertThat(deck.remainCardSize()).isEqualTo(52);
    }

    @Test
    void 카드를_한장_뽑아준다() {
        CardFactory cardFactory = CardFactory.getInstance();
        Deck deck = new Deck(cardFactory.createCards());
        deck.spreadCard();
        assertThat(deck.remainCardSize()).isEqualTo(51);
    }
}