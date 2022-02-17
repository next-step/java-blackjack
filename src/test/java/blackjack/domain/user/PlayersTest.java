package blackjack.domain.user;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Number;
import blackjack.domain.card.Suit;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PlayersTest {

    @Test
    void 딜러와_플레이어를_이용해_참가자를_구성할_수_있다() {
        //given
        Dealer dealer = new Dealer();
        List<Player> players = new ArrayList<>();
        players.add(new Player("Jason"));
        players.add(new Player("Pobi"));
        //when
        Players createPlayers = new Players(dealer, players);
        //then
        assertThat(createPlayers).isInstanceOf(Players.class);
    }

    @Test
    void 참가자들_중_딜러만_반환할_수_있다() {
        //given
        Dealer dealer = new Dealer();
        List<Player> players = new ArrayList<>();
        players.add(new Player("Jason"));
        players.add(new Player("Pobi"));
        //when
        Players createPlayers = new Players(dealer, players);
        //then
        assertThat(createPlayers.findDealer()).isEqualTo(dealer);
    }

    @Test
    void 참가자들_중_플레이어들만_반환할_수_있다() {
        Dealer dealer = new Dealer();
        List<Player> players = new ArrayList<>();
        players.add(new Player("Jason"));
        players.add(new Player("Pobi"));
        //when
        Players createPlayers = new Players(dealer, players);
        //then
        assertThat(createPlayers.findOnlyPlayers()).isEqualTo(players);
    }

    @Test
    void 참가자들_중_블랙잭이_있는지_확인할_수_있다() {
        //given
        Dealer dealer = new Dealer();
        dealer.drawCard(new Card(Suit.CLOVER, Number.ACE));
        dealer.drawCard(new Card(Suit.CLOVER, Number.KING));
        List<Player> players = new ArrayList<>();
        Player jason = new Player("jason");
        jason.drawCard(new Card(Suit.DIAMOND, Number.FIVE));
        jason.drawCard(new Card(Suit.DIAMOND, Number.SIX));
        Player pobi = new Player("pobi");
        pobi.drawCard(new Card(Suit.SPADE, Number.EIGHT));
        pobi.drawCard(new Card(Suit.SPADE, Number.NINE));
        //when
        Players createPlayers = new Players(dealer, players);
        //then
        assertThat(createPlayers.hasBlackJack()).isTrue();
    }
}
