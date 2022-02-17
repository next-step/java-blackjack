package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

    private Deck deck;
    private Player player;

    @BeforeEach
    void 덱_만들기() {
        player = new Player("Player");
        deck = Deck.createDeck();
    }

    @Test
    void 카드_뽑기_가능_테스트() {
        assertTrue(player.isAvailDraw());
    }

    @Test
    void 카드_두장_뽑기_테스트() {
        player.initOwnCards(deck);

        assertThat(player.ownCards.getOwnCards().size()).isEqualTo(2);
    }

    @Test
    void 카드_한장_뽑기_테스트() {
        player.drawOneCards(deck);

        assertThat(player.ownCards.getOwnCards().size()).isEqualTo(1);
    }
}
