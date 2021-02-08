package blackjack.domain;

import blackjack.dto.CardBunchInfo;
import blackjack.dto.CardInfo;
import blackjack.dto.NameInfo;
import blackjack.dto.PlayerInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {
    private static Player testPlayer;

    @BeforeAll
    static void beforeAll() {
        testPlayer = new Player(
            "player",
            new CardBunch(
                Stream.of(1, 7, 10).map(
                    n -> new Card(
                        Denomination.of(n),
                        Suit.HEARTS
                    )
                ).collect(
                    Collectors.toList()
                )
            )
        );
    }

    @DisplayName("Check that user is busted after request card")
    @Test
    void requestCard() {
        Player player = new Player(
            "Player"
        );

        Deck deck = new Deck(
            new ArrayList<>() {{
                add(new Card(Denomination.ACE, Suit.SPADES));
                add(new Card(Denomination.TEN, Suit.SPADES));
                add(new Card(Denomination.SEVEN, Suit.SPADES));
                add(new Card(Denomination.FIVE, Suit.SPADES));
            }}
        );

        player.requestCard(deck);
        assertFalse(player.isBust());

        player.requestCard(deck);
        assertFalse(player.isBust());

        player.requestCard(deck);
        assertFalse(player.isBust());

        player.requestCard(deck);
        assertTrue(player.isBust());
    }

    @DisplayName("Check if user got busted")
    @ParameterizedTest
    @MethodSource("providerIsBustParams")
    void isBust(List<Integer> numbers, boolean expected) {
       Player player = new Player(
           "player",
           new CardBunch(
               numbers.stream().map(
                   n -> new Card(
                       Denomination.of(n),
                       Suit.HEARTS
                   )
               ).collect(
                   Collectors.toList()
               )
           )
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
    void getPlayerInfo() {
        assertEquals(
            new PlayerInfo(
                new NameInfo("player"),
                new CardBunchInfo(
                    Stream.of(1, 7, 10).map(
                        n -> new CardInfo(
                            Denomination.of(n),
                            Suit.HEARTS
                        )
                    ).collect(
                        Collectors.toList()
                    )
                )
            ),
            testPlayer.getPlayerInfo()
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