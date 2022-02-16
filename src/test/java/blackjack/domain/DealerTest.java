package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class DealerTest {

    CardPack cardPack = CardPack.create();
    List<String> playerNames = Arrays.asList("pobi", "jason");

    @Test
    public void 게임초기_딜러는_플레이어들에게_카드를_2장씩_배분한다() {
        //given
        GamePlayers gamePlayers = GamePlayers.makePlayers(playerNames);
        Dealer dealer = new Dealer(cardPack);

        //when
        dealer.initializeGame(gamePlayers);
        List<Player> players = gamePlayers.getPlayers();

        //then
        for (Player player : players) {
            List<Card> cards = player.getCards();
            assertThat(cards.size()).isEqualTo(2);
        }
    }
}