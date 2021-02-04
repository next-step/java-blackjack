package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

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
        assertEquals(false, player.isBust());

        player.requestCard(deck);
        assertEquals(false, player.isBust());

        player.requestCard(deck);
        assertEquals(false, player.isBust());

        player.requestCard(deck);
        assertEquals(true, player.isBust());
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

}