package blackjack.domain.gameplayer;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardSymbol;
import blackjack.domain.card.CardType;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    public void 특정카드를_받았을때_그만큼의_점수를_더해준다() {
        //given
        GamePlayer player = new Player(new Name("pobi"));

        //when
        player.receiveCard(new Card(CardSymbol.CLOVER, CardType.FIVE));

        //then
        assertThat(player.getScore()).isEqualTo(5);
    }

    @Test
    public void Ace를_받았을때_합이_21을_넘을경우_1을_더해준다() {
        //given
        GamePlayer player = new Player(new Name("pobi"));

        //when
        player.receiveCard(new Card(CardSymbol.CLOVER, CardType.FIVE));
        player.receiveCard(new Card(CardSymbol.CLOVER, CardType.FIVE));
        player.receiveCard(new Card(CardSymbol.CLOVER, CardType.FIVE));
        player.receiveCard(new Card(CardSymbol.CLOVER, CardType.ACE));
        //then
        assertThat(player.getScore()).isEqualTo(16);
    }

    @Test
    public void Ace를_받았을때_합이_21을_넘지않을경우_11을_더해준다() {
        //given
        GamePlayer player = new Player(new Name("pobi"));

        //when
        player.receiveCard(new Card(CardSymbol.CLOVER, CardType.FIVE));
        player.receiveCard(new Card(CardSymbol.CLOVER, CardType.FIVE));
        player.receiveCard(new Card(CardSymbol.CLOVER, CardType.ACE));

        //then
        assertThat(player.getScore()).isEqualTo(21);
    }

    @Test
    public void 플레이어는_카드의합이_21이하면_카드를_받을수있는_조건이_된다() {
        //given
        GamePlayers gamePlayers = new GamePlayers(new Names(Arrays.asList(new Name("pobi"))));

        List<GamePlayer> players = gamePlayers.getPlayers();
        GamePlayer player = players.get(0);

        //when
        player.receiveCard(new Card(CardSymbol.DIAMOND, CardType.NINE));
        player.receiveCard(new Card(CardSymbol.DIAMOND, CardType.TEN));

        //then
        assertThat(player.isLowerThanBound()).isTrue();
    }

    @Test
    public void 딜러는_카드의합이_21초과면_카드를_받을수없다() {
        //given
        GamePlayers gamePlayers = new GamePlayers(new Names(Arrays.asList(new Name("pobi"))));

        List<GamePlayer> players = gamePlayers.getPlayers();
        GamePlayer player = players.get(0);

        //when
        player.receiveCard(new Card(CardSymbol.DIAMOND, CardType.NINE));
        player.receiveCard(new Card(CardSymbol.DIAMOND, CardType.TEN));
        player.receiveCard(new Card(CardSymbol.DIAMOND, CardType.EIGHT));

        //then
        assertThat(player.isLowerThanBound()).isFalse();
    }

    @Test
    public void 일반플레이어의_최종승패는_올바르게_계산된다() {
        //given
        GamePlayers gamePlayers = new GamePlayers(new Names(Arrays.asList(new Name("pobi"), new Name("jason"))));
        List<GamePlayer> players = gamePlayers.getPlayers();
        players.get(0).receiveCard(new Card(CardSymbol.CLOVER, CardType.NINE));
        players.get(1).receiveCard(new Card(CardSymbol.CLOVER, CardType.FOUR));

        //when
        String pobiResult = players.get(0).getGameResult(gamePlayers.getAllPlayers());
        String jasonResult = players.get(1).getGameResult(gamePlayers.getAllPlayers());

        //then
        org.junit.jupiter.api.Assertions.assertAll(
            () -> assertThat(pobiResult).isEqualTo("승"),
            () -> assertThat(jasonResult).isEqualTo("패")
        );
    }
}
