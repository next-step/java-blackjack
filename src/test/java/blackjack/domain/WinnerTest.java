package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardNumber;
import blackjack.domain.card.CardPattern;
import blackjack.domain.card.Cards;
import blackjack.domain.player.Dealer;
import blackjack.domain.player.Player;
import blackjack.domain.state.State;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerTest {
    @DisplayName("딜러 게임 승패 여부 테스트")
    @Test
    void calculateDealerGameResultTest() {
        Dealer dealer = new Dealer("딜러",
            new State(new Cards(Arrays.asList(
                new Card(CardNumber.ACE, CardPattern.CLOVER),
                new Card(CardNumber.NINE, CardPattern.CLOVER))
            ), true));
        List<Player> players = Arrays.asList(
            new Player("pobi", new State(new Cards(Arrays.asList(
                new Card(CardNumber.TWO, CardPattern.HEART),
                new Card(CardNumber.THREE, CardPattern.DIAMOND))
            ), true)),
            new Player("jason", new State(new Cards(Arrays.asList(
                new Card(CardNumber.ACE, CardPattern.DIAMOND),
                new Card(CardNumber.TWO, CardPattern.CLOVER))
            ), true))
        );

        Game game = new Game(dealer, players);
        Winner winner = new Winner(game);
        List<Integer> result = winner.calculateDealerGameResult();
        assertAll(
            () -> assertThat(result.get(0)).isEqualTo(2),
            () -> assertThat(result.get(1)).isEqualTo(0)
        );
    }

    @DisplayName("플레이어 게임 승패 여부 테스트")
    @Test
    void calculatePlayerGameResultTest() {
        Dealer dealer = new Dealer("딜러",
            new State(new Cards(Arrays.asList(
                new Card(CardNumber.ACE, CardPattern.CLOVER),
                new Card(CardNumber.NINE, CardPattern.CLOVER))
            ), true));
        List<Player> players = Arrays.asList(
            new Player("pobi", new State(new Cards(Arrays.asList(
                new Card(CardNumber.TWO, CardPattern.HEART),
                new Card(CardNumber.THREE, CardPattern.DIAMOND))
            ), true)),
            new Player("jason", new State(new Cards(Arrays.asList(
                new Card(CardNumber.ACE, CardPattern.DIAMOND),
                new Card(CardNumber.TWO, CardPattern.CLOVER))
            ), true))
        );

        Game game = new Game(dealer, players);
        Winner winner = new Winner(game);
        List<Integer> result = winner.calculatePlayerGameResult(players.get(0));
        assertAll(
            () -> assertThat(result.get(0)).isEqualTo(0),
            () -> assertThat(result.get(1)).isEqualTo(1)
        );
    }
}