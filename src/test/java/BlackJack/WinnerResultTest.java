package BlackJack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinnerResultTest {
    private List<Player> players;
    private Dealer dealer;
    private PlayGame playGame;
    private CardMachine cardMachine;
    private CardPack cardPack;
    private WinnerResult winnerResult;
    @BeforeEach
    void setUp() {
        players = Arrays.asList(new Player("ss"), new Player("yy"));
        dealer = new Dealer();
        playGame = new PlayGame(players, dealer);
        cardMachine = new CardMachine();
        cardPack = cardMachine.createCards();
        winnerResult = new WinnerResult(players,dealer);
    }
    @Test
    void loseGame() {
        winnerResult.findWinnerPlayer();
    }
}
