package Service;

import Domain.Dealer;
import Domain.Player;
import Domain.TrumpCard;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BlackJackGameTest {

    @Test
    void calcurateBettingPrice() {
        BlackJackGame blackJackGame = new BlackJackGame();
        List<TrumpCard> trumpCardList = new ArrayList<>();
        trumpCardList.add(new TrumpCard(0));
        trumpCardList.add(new TrumpCard(1));

        blackJackGame.dealer = new Dealer("딜러", trumpCardList);
//        blackJackGame.dealer.isBlackJack = true ;
        blackJackGame.playerList = makePlayer();

        blackJackGame.calcurateBettingPrice();
        assertThat(blackJackGame.dealer.winningPrice).isEqualTo(0);
    }

    List<Player> makePlayer(){
        List<TrumpCard> trumpCardList = new ArrayList<>();
        trumpCardList.add(new TrumpCard(0));
        trumpCardList.add(new TrumpCard(1));

        Player player1 = new Player("a", trumpCardList);
        player1.bettingPrice = 2 ;
//        player1.isBlackJack = true ;

        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);

        return playerList;
    }
}