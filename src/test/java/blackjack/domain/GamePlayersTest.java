package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GamePlayersTest {

    private Deck deck;
    private GamePlayers gamePlayers;

    @BeforeEach
    void 덱_만들기() {
        gamePlayers = new Dealer();
        deck = Deck.createDeck();
    }

    @Test
    void 카드_뽑기_가능_테스트() {
        gamePlayers.initOwnCards(deck);
        gamePlayers.initOwnCards(deck);

        assertFalse(gamePlayers.isAvailDraw());
    }

    @Test
    void 카드_두장_뽑기_테스트() {
        gamePlayers.initOwnCards(deck);

        assertThat(gamePlayers.ownCards.getOwnCards().size()).isEqualTo(2);
    }

    @Test
    void 카드_한장_뽑기_테스트() {
        gamePlayers.drawOneCards(deck);

        assertThat(gamePlayers.ownCards.getOwnCards().size()).isEqualTo(1);
    }
}
