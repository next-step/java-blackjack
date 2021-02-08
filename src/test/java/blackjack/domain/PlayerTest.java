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

    @DisplayName("Check if user got busted")
    @ParameterizedTest
    @MethodSource("providerIsBustParams")
    void isBust(List<Integer> numbers, boolean expected) {
       Player player = new Player(
           "player",
           new CardBunch(numbers, Suit.HEARTS)
       );
       assertEquals(
            expected,
            player.isBust()
        );
    }

    private static Stream<Arguments> providerIsBustParams() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 10), false),
            Arguments.of(Arrays.asList(10, 9, 8), true)
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

    @DisplayName("Check if the Player return corret Player name information")
    @Test
    void getNameInfo() {
        assertEquals(
            new NameInfo("player"),
            testPlayer.getNameInfo()
        );
    }
}