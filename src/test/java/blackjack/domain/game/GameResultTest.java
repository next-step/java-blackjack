package blackjack.domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import blackjack.domain.card.Shape;
import blackjack.domain.person.Player;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    void 게임_결과를_구한다() {
        Player a = new Player("a", Arrays.asList(
            new Card(Shape.HEART, Denomination.NINE),
            new Card(Shape.HEART, Denomination.TWO)
        ));
        Player b = new Player("b", Arrays.asList(
            new Card(Shape.HEART, Denomination.ACE),
            new Card(Shape.HEART, Denomination.KING)
        ));
        GameResult gameResult = new GameResult(12, Arrays.asList(a, b));
        Map<String, String> playerResult = gameResult.getPlayerResult();

        assertAll(
            () -> assertThat(playerResult.get("a")).isEqualTo("패"),
            () -> assertThat(playerResult.get("b")).isEqualTo("승"),
            () -> assertThat(gameResult.getDealerWin()).isEqualTo(1)
        );
    }
}
