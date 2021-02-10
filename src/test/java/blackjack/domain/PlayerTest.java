package blackjack.domain;

import blackjack.dto.NameInfo;
import blackjack.dto.PersonInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {
    private Player testPlayer;

    @BeforeEach
    void setUp() {
        testPlayer = new Player(
            "player",
            new CardBunch(
                List.of(1, 7, 10),
                Suit.HEARTS
            )
        );
    }

    @DisplayName("Check player return drawable status well")
    @ParameterizedTest
    @MethodSource("providerCanDrawCardParams")
    void canDrawCard(List<Integer> numbers, boolean canDrawCard) {
        Player player = new Player(
            "player",
            new CardBunch(
                numbers, Suit.HEARTS
            )
        );

        assertEquals(
            canDrawCard,
            player.canDrawCard()
        );
    }

    private static Stream<Arguments> providerCanDrawCardParams() {
        return Stream.of(
            Arguments.of(Arrays.asList(10, 10), true),
            Arguments.of(Arrays.asList(1, 10), false),
            Arguments.of(Arrays.asList(10, 10, 2), false)
        );
    }

    @DisplayName("Check player draw card from deck well")
    @Test
    void drawCardFromDeck() {
        Deck deck = new Deck(
            new ArrayList<>() {{
                add(new Card(Denomination.ACE, Suit.HEARTS));
            }}
        );
        testPlayer.drawCardFromDeck(deck);

        assertEquals(
            new PersonInfo(
                new NameInfo("player"),
                new CardBunch(
                    List.of(1, 7, 10, 1),
                    Suit.HEARTS
                ).getCardBunchInfo()
            ),
            testPlayer.getPersonInfo()
        );
    }

    @DisplayName("Check player get proper match score")
    @ParameterizedTest
    @MethodSource("providerGetMatchScoreParams")
    void getMatchScore(List<Integer> playerNumbers, List<Integer> dealerNubmers, MatchScore result) {
        Player player = new Player(
            "player",
            new CardBunch(
                playerNumbers, Suit.HEARTS
            )
        );
        Dealer dealer = new Dealer(
            new CardBunch(
                dealerNubmers, Suit.HEARTS
            )
        );

        assertEquals(
            result,
            player.getMatchScore(dealer)
        );
    }

    private static Stream<Arguments> providerGetMatchScoreParams() {
        return Stream.of(
            Arguments.of(List.of(10, 10, 2), List.of(10, 10), MatchScore.LOSE),
            Arguments.of(List.of(10, 10), List.of(10, 10, 2), MatchScore.WIN),
            Arguments.of(List.of(1, 10), List.of(1, 10), MatchScore.DRAW),
            Arguments.of(List.of(1, 10), List.of(10, 10), MatchScore.WIN),
            Arguments.of(List.of(10, 10), List.of(1, 10), MatchScore.LOSE),
            Arguments.of(List.of(9, 10), List.of(9, 10), MatchScore.DRAW),
            Arguments.of(List.of(10, 10), List.of(10, 9), MatchScore.WIN),
            Arguments.of(List.of(10, 9), List.of(10, 10), MatchScore.LOSE)
        );
    }

    @DisplayName("Check player return correct Player information")
    @Test
    void getPersonInfo() {
        assertEquals(
            new PersonInfo(
                new NameInfo("player"),
                new CardBunch(
                    List.of(1, 7, 10),
                    Suit.HEARTS
                ).getCardBunchInfo()
            ),
            testPlayer.getPersonInfo()
        );
    }

    @DisplayName("Check player return correct Player name information")
    @Test
    void getNameInfo() {
        assertEquals(
            new NameInfo("player"),
            testPlayer.getNameInfo()
        );
    }
}