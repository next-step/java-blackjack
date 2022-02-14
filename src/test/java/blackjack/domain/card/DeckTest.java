package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DeckTest {

    @Test
    void 카드번들을_제대로_받는지_테스트() {
        CardBundle cardBundle = new CardBundle();
        Deck deck = new Deck(cardBundle.createCards());
        assertThat(deck.remainCardSize()).isEqualTo(52);
    }

    @Test
    void 카드를_한장_뽑아준다() {
        CardBundle cardBundle = new CardBundle();
        Deck deck = new Deck(cardBundle.createCards());
        deck.spreadCard();
        assertThat(deck.remainCardSize()).isEqualTo(51);
    }
}