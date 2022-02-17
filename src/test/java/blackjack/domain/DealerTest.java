package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardPack;
import blackjack.domain.gameplayer.GamePlayer;
import blackjack.domain.gameplayer.GamePlayers;
import blackjack.domain.gameplayer.Name;
import blackjack.domain.gameplayer.Names;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class DealerTest {

    CardPack cardPack = CardPack.createWithShuffling();

    @Test
    public void 게임초기_딜러는_플레이어들에게_카드를_2장씩_배분한다() {
        //given
        GamePlayers gamePlayers = GamePlayers.makePlayers(new Names(Arrays.asList(new Name("pobi"), new Name("jason"))));
        Dealer dealer = new Dealer(cardPack);

        //when
        dealer.initializeGame(gamePlayers);
        List<GamePlayer> players = gamePlayers.getPlayers();

        //then
        for (GamePlayer player : players) {
            List<Card> cards = player.getCards();
            assertThat(cards.size()).isEqualTo(2);
        }
    }
}