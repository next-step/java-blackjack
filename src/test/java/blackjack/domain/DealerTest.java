package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DealerTest {
    // TODO : How to check requestCard method on dealer?

    @DisplayName("Check if dealer got busted")
    @ParameterizedTest
    @MethodSource("providerIsBustParams")
    void isBust(List<Integer> numbers, boolean expected) {
        Dealer dealer = new Dealer(
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
            dealer.isBust()
        );
    }

    private static Stream<Arguments> providerIsBustParams() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 10), false),
            Arguments.of(Arrays.asList(10, 9, 8), true)
        );
    }
}