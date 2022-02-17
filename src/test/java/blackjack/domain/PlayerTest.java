package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardSymbol;
import blackjack.domain.card.CardType;
import blackjack.domain.gameplayer.GamePlayer;
import blackjack.domain.gameplayer.Name;
import blackjack.domain.gameplayer.Player;
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
}