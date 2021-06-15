package BlackJack;

import BlackJack.actor.Dealer;
import BlackJack.actor.Player;
import BlackJack.actor.Players;
import BlackJack.card.Card;
import BlackJack.card.CardMachine;
import BlackJack.card.CardPack;
import BlackJack.game.PlayGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    private Players players;
    private Dealer dealer;
    private PlayGame playGame;
    private CardMachine cardMachine;
    private CardPack cardPack;

    @BeforeEach
    void setUp() {
        players.add( new Player("ss"));
        players.add( new Player("yy"));
        dealer = new Dealer();
        playGame = new PlayGame(players, dealer);
        cardMachine = new CardMachine();
        cardPack = cardMachine.createCards();
    }

    @DisplayName("플레이어는 발급받은 두 장의 합을 구할 수 있다.")
    @Test
    void sumCardsTest() {
        int playerAddedCardsValue = 0;
        playGame.gameStart(2);
        for (Player player : players.getPlayers()) {
            playerAddedCardsValue = player.sumCards();
        }
        assertThat(playerAddedCardsValue).isBetween(2, 21);
    }

    @DisplayName("ace가 뽑혔을 때 11이 나올 수 있다.")
    @Test
    void findAce11Test() {
        for (Player player : players.getPlayers()) {
            Card get_CardPlayerAce = cardPack.getCards().get(0);
            player.getCard(get_CardPlayerAce);
            Card get_CardPlayerTen = cardPack.getCards().get(9);
            player.getCard(get_CardPlayerTen);
            assertThat(player.sumCards()).isEqualTo(21);
        }
    }

    @DisplayName("ace가 뽑혔을 때 1이 나올 수 있다.")
    @Test
    void findAce1Test() {
        for (Player player : players.getPlayers()) {
            Card get_CardPlayerAce1 = cardPack.getCards().get(0);
            player.getCard(get_CardPlayerAce1);
            Card get_CardPlayerAce2 = cardPack.getCards().get(13);
            player.getCard(get_CardPlayerAce2);
            assertThat(player.sumCards()).isEqualTo(12);
        }
    }
}
