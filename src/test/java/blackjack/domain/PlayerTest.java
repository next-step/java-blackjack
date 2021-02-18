package blackjack.domain;

import blackjack.dto.NameInfo;
import blackjack.dto.PersonInfo;
import org.junit.jupiter.api.BeforeAll;
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
    private static Player testPlayer;

    @BeforeAll
    static void beforeAll() {
        testPlayer = new Player(
                "player",
                new CardBunch(
                        List.of(1, 7, 10),
                        Suit.HEARTS
                )
        );
    }

    @DisplayName("Check user draw card well after requestCard")
    @Test
    void requestCard() {
        Player player = new Player(
                "player"
        );

        Deck deck = new Deck(
                new ArrayList<>() {{
                    add(new Card(Denomination.ACE, Suit.HEARTS));
                    add(new Card(Denomination.TEN, Suit.HEARTS));
                }}
        );

        assertEquals(
                new PersonInfo(
                        new NameInfo("player"),
                        new CardBunch(
                                List.of(),
                                Suit.HEARTS
                        ).getCardBunchInfo()
                ),
                player.getPersonInfo()
        );

        player.requestCard(deck);

        assertEquals(
                new PersonInfo(
                        new NameInfo("player"),
                        new CardBunch(
                                List.of(1),
                                Suit.HEARTS
                        ).getCardBunchInfo()
                ),
                player.getPersonInfo()
        );
    }

    @DisplayName("Check if player can draw card")
    @ParameterizedTest
    @MethodSource("providerCanDrawCardParams")
    void canDrawCard(List<Integer> numbers, boolean expected) {
        Player player = new Player("Player", new CardBunch(numbers, Suit.HEARTS));
        assertEquals(
                expected,
                player.canDraw()
        );
    }

    private static Stream<Arguments> providerCanDrawCardParams() {
        return Stream.of(
                Arguments.of(Arrays.asList(6, 10), true),
                Arguments.of(Arrays.asList(10, 10, 7), false),
                Arguments.of(Arrays.asList(10, 1), false)
        );
    }

    @DisplayName("Check if the Player return correct Player information")
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

    @DisplayName("Check if the Player return correct Player name information")
    @Test
    void getNameInfo() {
        assertEquals(
                new NameInfo("player"),
                testPlayer.getNameInfo()
        );
    }

    @DisplayName("Check if the player gets correct initial card bunch")
    @Test
    void initCardTest() {
        Deck deck = new Deck(
                new ArrayList<>() {{
                    add(new Card(Denomination.ACE, Suit.HEARTS));
                    add(new Card(Denomination.FIVE, Suit.SPADES));
                }}
        );

        Player player = new Player("Player1");
        player.initialCard(deck);

        assertEquals(
                new CardBunch(
                        new ArrayList<>() {{
                            add(new Card(Denomination.ACE, Suit.HEARTS));
                            add(new Card(Denomination.FIVE, Suit.SPADES));
                        }}
                ),
                player.cardBunch
        );
    }
}