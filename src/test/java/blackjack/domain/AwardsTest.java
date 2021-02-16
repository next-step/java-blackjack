/*
package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.awards.Awards;
import blackjack.domain.awards.AwardsResult;
import blackjack.domain.card.Cards;
import blackjack.domain.player.CardDeck;
import blackjack.domain.player.Dealer;
import blackjack.domain.player.Player;
import blackjack.domain.state.Hit;
import blackjack.domain.state.PlayingCard;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AwardsTest {
    @Test
    public void resultAward() {

        Dealer dealer = new Dealer();
        ArrayList<Player> players = new ArrayList<>();
        Cards cards = new Cards(); // TODO: Test 를 위해서 정렬되지 않은 카드 뭉치를 넣어 줄 필요가 있음.

        AwardsResult awardsResult = new AwardsResult(dealer, players);
        Player player1 = new Player("pobi", new Hit(cards));
        Player player2 = new Player("jason", new Hit(cards));
        players.add(player1);
        players.add(player2);

        // player에게 카드를 주는 부분
        PlayingCard poppedCard;
        poppedCard = (PlayingCard)CardDeck.getPlayingCard(); // TODO: Test 를 위해서 정렬되지 않은 카드 뭉치를 넣어 줄 필요가 있음.
        player1.earnCard(poppedCard);
        poppedCard = (PlayingCard)CardDeck.getPlayingCard();
        player1.earnCard(poppedCard);

        poppedCard = (PlayingCard)CardDeck.getPlayingCard();
        player2.earnCard(poppedCard);
        poppedCard = (PlayingCard)CardDeck.getPlayingCard();
        player2.earnCard(poppedCard);
        poppedCard = (PlayingCard)CardDeck.getPlayingCard();
        player2.earnCard(poppedCard);
        // 해당 결과에 따라 test 에는 false, false 이런 식으로 실제 결과를 넣고
        // 실제 코드에는 카드 결과에 따라 결과를 내도록.
        players.get(0).setIsWin(false);
        players.get(1).setIsWin(false);
        dealer.winResult(players);

        // 이거를 string 비교가 아니라, 결과 비교로 하자!
        assertThat(Awards.produceResult(dealer, players))
            .isEqualToComparingFieldByField(awardsResult);
    }
}*/
