package blackjack.domain.gameplayer;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardSymbol;
import blackjack.domain.card.CardType;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class DealerPlayerTest {

    @Test
    public void 딜러는_카드의합이_16이하면_카드를_받을수있는_조건이_된다() {
        //given
        GamePlayers gamePlayers = new GamePlayers(new Names(Arrays.asList(new Name("pobi"), new Name("jason"))));
        GamePlayer dealer = gamePlayers.getDealer();

        //when
        dealer.receiveCard(new Card(CardSymbol.DIAMOND, CardType.ACE));

        //then
        assertThat(dealer.isLowerThanBound()).isTrue();
    }

    @Test
    public void 딜러는_카드의합이_16초과면_카드를_받을수없다() {
        //given
        GamePlayers gamePlayers = new GamePlayers(new Names(Arrays.asList(new Name("pobi"), new Name("jason"))));
        GamePlayer dealer = gamePlayers.getDealer();

        //when
        dealer.receiveCard(new Card(CardSymbol.DIAMOND, CardType.ACE));
        dealer.receiveCard(new Card(CardSymbol.DIAMOND, CardType.NINE));

        //then
        assertThat(dealer.isLowerThanBound()).isFalse();
    }

    @Test
    public void 딜러플레이어의_최종승패는_올바르게_계산된다_2승을출력() {
        //given
        GamePlayers gamePlayers = new GamePlayers(new Names(Arrays.asList(new Name("pobi"), new Name("jason"))));
        List<GamePlayer> players = gamePlayers.getPlayers();
        GamePlayer dealer = gamePlayers.getDealer();
        dealer.receiveCard(new Card(CardSymbol.DIAMOND, CardType.ACE));
        players.get(0).receiveCard(new Card(CardSymbol.CLOVER, CardType.NINE));
        players.get(1).receiveCard(new Card(CardSymbol.CLOVER, CardType.FOUR));

        //when
        String dealerResult = dealer.getGameResult(gamePlayers.getPlayers());

        //then
        assertThat(dealerResult).isEqualTo("2승 0패");
    }

    @Test
    public void 딜러플레이어의_최종승패는_올바르게_계산된다_1승1패를출력() {
        //given
        GamePlayers gamePlayers = new GamePlayers(new Names(Arrays.asList(new Name("pobi"), new Name("jason"))));
        List<GamePlayer> players = gamePlayers.getPlayers();
        GamePlayer dealer = gamePlayers.getDealer();
        dealer.receiveCard(new Card(CardSymbol.DIAMOND, CardType.SIX));
        players.get(0).receiveCard(new Card(CardSymbol.CLOVER, CardType.NINE));
        players.get(1).receiveCard(new Card(CardSymbol.CLOVER, CardType.FOUR));

        //when
        String dealerResult = dealer.getGameResult(gamePlayers.getPlayers());

        //then
        assertThat(dealerResult).isEqualTo("1승 1패");
    }
}
