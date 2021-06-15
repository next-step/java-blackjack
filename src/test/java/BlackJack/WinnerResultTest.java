package BlackJack;

import BlackJack.actor.Dealer;
import BlackJack.actor.Player;
import BlackJack.actor.Players;
import BlackJack.card.CardMachine;
import BlackJack.card.CardPack;
import BlackJack.game.PlayGame;
import BlackJack.game.WinnerResultPlayer;
import org.junit.jupiter.api.BeforeEach;

class WinnerResultTest {
    private Players players;
    private Dealer dealer;
    private PlayGame playGame;
    private CardMachine cardMachine;
    private CardPack cardPack;
    private WinnerResultPlayer winnerResult;

    @BeforeEach
    void setUp() {
        players.add( new Player("ss"));
        players.add( new Player("yy"));
        dealer = new Dealer();
        playGame = new PlayGame(players, dealer);
        cardMachine = new CardMachine();
        cardPack = cardMachine.createCards();
    }

}
