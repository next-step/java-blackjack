package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DealerTest {

    private Deck deck;
    private Dealer dealer;

    @BeforeEach
    void 덱_만들기() {
        dealer = new Dealer();
        deck = Deck.createDeck();
    }

    @Test
    void 카드_뽑기_가능_테스트() {
        dealer.initOwnCards(deck);
        dealer.initOwnCards(deck);

        assertFalse(dealer.isAvailDraw());
    }

    @Test
    void 카드_두장_뽑기_테스트() {
        dealer.initOwnCards(deck);

        assertThat(dealer.ownCards.getOwnCards().size()).isEqualTo(2);
    }

    @Test
    void 카드_한장_뽑기_테스트() {
        dealer.drawOneCards(deck);

        assertThat(dealer.ownCards.getOwnCards().size()).isEqualTo(1);
    }
}
