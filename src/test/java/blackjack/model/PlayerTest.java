package blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static blackjack.utils.StringUtils.LOSE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player;

    @BeforeEach
    void setUp() {
        player = User.of("test");
    }

    @Test
    void drawCard() {
        player.drawCard(Fixtures.HEART_TEN_CARD);
        assertThat(player.getCardHand().getCards().get(0)).isEqualTo(Fixtures.HEART_TEN_CARD);
    }

    @Test
    void getCardHandScore() {
        player.drawCard(Fixtures.HEART_TEN_CARD);
        assertThat(player.getCardHandScore()).isEqualTo(Fixtures.HEART_TEN_CARD.getSymbol().getScore());

    }

    @Test
    void getCardBundleSize() {
        player.drawCard(Fixtures.HEART_TEN_CARD);
        assertThat(player.getCardBundleSize()).isEqualTo(1);
    }

    @Test
    void getResult() {
        player.drawCard(Fixtures.HEART_TEN_CARD);
        assertThat(player.getResult()).isEqualTo(player.getName() + ": "+LOSE);
    }
}