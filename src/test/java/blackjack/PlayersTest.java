package blackjack;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import blackjack.domain.Cards;
import blackjack.domain.Deck;
import blackjack.domain.Player;
import blackjack.domain.Players;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayersTest {

    private List<Player> playerList;
    private Player pobi;
    private Player jason;

    @BeforeEach
    void setUp() {
        pobi = new Player("pobi", new Cards(new ArrayList<>()));
        jason = new Player("jason", new Cards(new ArrayList<>()));

        playerList = new ArrayList<>(Arrays.asList(pobi, jason));
    }

    @Test
    void 플레이어별_카드_초기화_결과_검증() {
        Deck deck = Deck.create();
        Players players = new Players(playerList);
        players.initializeDeck(deck);

        assertAll(
            () -> assertEquals(pobi.cardSize(), 2),
            () -> assertEquals(jason.cardSize(), 2)
        );
    }
}
