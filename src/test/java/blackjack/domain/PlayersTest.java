package blackjack.domain;

import blackjack.dto.PersonMatchProfitInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {
    private static Player testPlayer1, testPlayer2;
    private static Players testPlayers;

    @BeforeAll
    static void beforeAll() {
        testPlayer1 = new Player(
            "name1",
            new CardBunch(List.of(10, 7), Suit.HEARTS)
        );

        testPlayer2 = new Player(
            "name2",
            new CardBunch(List.of(1, 10), Suit.HEARTS)
        );

        testPlayers = new Players(
            List.of(testPlayer1, testPlayer2)
        );
    }

    @DisplayName("Check players is well initialized with given deck")
    @Test
    void initializeFromDeck() {
        Players players = new Players(
            List.of(
                new Player("name1"),
                new Player("name2")
            )
        );

        Deck deck = new Deck(
            new ArrayList<>() {{
                add(new Card(Denomination.ACE, Suit.HEARTS));
                add(new Card(Denomination.ACE, Suit.HEARTS));
                add(new Card(Denomination.ACE, Suit.HEARTS));
                add(new Card(Denomination.ACE, Suit.HEARTS));
            }}
        );

        players.initializeFromDeck(deck);

        assertEquals(
            List.of(
                new Player(
                    "name1",
                    new CardBunch(List.of(1, 1), Suit.HEARTS)
                ).getScoreInfo(),
                new Player(
                    "name2",
                    new CardBunch(List.of(1, 1), Suit.HEARTS)
                ).getScoreInfo()
            ),
            players.getPlayersScoreInfo()
        );
    }

    @DisplayName("Check players check that active user is existing well")
    @ParameterizedTest
    @MethodSource("providerHasActivePlayerParams")
    void hasActivePlayer(int activePlayerIdx, boolean hasActivePlayer) {
        Players players = new Players(
            List.of(testPlayer1, testPlayer2),
            activePlayerIdx
        );

        assertEquals(
            hasActivePlayer,
            players.hasActivePlayer()
        );
    }

    private static Stream<Arguments> providerHasActivePlayerParams() {
        return Stream.of(
            Arguments.of(1, true),
            Arguments.of(2, false)
        );
    }

    @DisplayName("Check players can get drawable status of active player well")
    @ParameterizedTest
    @MethodSource("providerCheckActivePlayerCanDrawCardParams")
    void checkActivePlayerCanDrawCard(List<Integer> numbers, boolean checkActivePlayerCanDrawCard) {
        Players players = new Players(
            List.of(
                new Player("name1",
                    new CardBunch(numbers, Suit.HEARTS)
                ),
                testPlayer2
            )
        );

        assertEquals(
            checkActivePlayerCanDrawCard,
            players.checkActivePlayerCanDrawCard()
        );
    }

    private static Stream<Arguments> providerCheckActivePlayerCanDrawCardParams() {
        return Stream.of(
            Arguments.of(List.of(10, 10), true),
            Arguments.of(List.of(1, 10), false)
        );
    }

    @DisplayName("Check active player draw card from deck well")
    @Test
    void drawActivePlayerFromDeck() {
        Players players = new Players(
            List.of(
                new Player("name1"),
                testPlayer2
            )
        );

        Deck deck = new Deck(
            new ArrayList<>() {{
                add(new Card(Denomination.ACE, Suit.HEARTS));
            }}
        );

        players.drawActivePlayerFromDeck(deck);

        assertEquals(
            List.of(
                new Player(
                    "name1",
                    new CardBunch(List.of(1), Suit.HEARTS)
                ).getScoreInfo(),
                testPlayer2.getScoreInfo()
            ),
            players.getPlayersScoreInfo()
        );
    }

    @DisplayName("Check active player turn is ended well")
    @Test
    void endActivePlayerTurn() {
        Players players = new Players(
            List.of(testPlayer1)
        );

        assertTrue(players.hasActivePlayer());
        players.endActivePlayerTurn();
        assertFalse(players.hasActivePlayer());
    }

    @DisplayName("Check players return correct match profit information")
    @Test
    void _playMatch() {
        Player player1 = new Player("player1", 10, new CardBunch(List.of(1, 10), Suit.HEARTS));
        Player player2 = new Player("player2", 10, new CardBunch(List.of(10, 10), Suit.HEARTS));
        Player player3 = new Player("player3", 10, new CardBunch(List.of(9, 10), Suit.HEARTS));
        Player player4 = new Player("player4", 10, new CardBunch(List.of(8, 10), Suit.HEARTS));
        Players players = new Players(List.of(player1, player2, player3, player4));

        Dealer dealer = new Dealer(
            new CardBunch(List.of(10, 9), Suit.HEARTS)
        );

        assertEquals(
            List.of(
                new PersonMatchProfitInfo(dealer.getNameInfo(), -15),
                new PersonMatchProfitInfo(player1.getNameInfo(), 15),
                new PersonMatchProfitInfo(player2.getNameInfo(), 10),
                new PersonMatchProfitInfo(player3.getNameInfo(), 0),
                new PersonMatchProfitInfo(player4.getNameInfo(), -10)
            ),
            players.playMatch(dealer)
        );
    }

    @DisplayName("Check players return correct active players name information")
    @Test
    void getActivePlayerNameInfo() {
        assertEquals(
            testPlayer1.getNameInfo(),
            testPlayers.getActivePlayerNameInfo()
        );
    }

    @DisplayName("Check players return correct active players cards information")
    @Test
    void getActivePlayerCardsInfo() {
        assertEquals(
            testPlayer1.getPersonCardsInfo(),
            testPlayers.getActivePlayerCardsInfo()
        );
    }

    @DisplayName("Check players return correct players name information")
    @Test
    void getPlayersNameInfo() {
        assertEquals(
            List.of(
                testPlayer1.getNameInfo(),
                testPlayer2.getNameInfo()
            ),
            testPlayers.getPlayersNameInfo()
        );
    }

    @DisplayName("Check players return correct players cards information")
    @Test
    void getPlayersCardsInfo() {
        assertEquals(
            List.of(
                testPlayer1.getPersonCardsInfo(),
                testPlayer2.getPersonCardsInfo()
            ),
            testPlayers.getPlayersCardsInfo()
        );
    }

    @DisplayName("Check players return correct players score information")
    @Test
    void getPlayersScoreInfo() {
        assertEquals(
            List.of(
                testPlayer1.getScoreInfo(),
                testPlayer2.getScoreInfo()
            ),
            testPlayers.getPlayersScoreInfo()
        );
    }
}