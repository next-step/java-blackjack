package blackjack.domain;

import blackjack.dto.CardBunchInfo;
import blackjack.dto.CardInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DealerCardBunchTest {
    @DisplayName("Check if dealer can draw card")
    @ParameterizedTest
    @MethodSource("providerCanDrawCardParams")
    void canDrawCard(List<Integer> numbers, boolean expected) {
        CardBunch cardBunch = new DealerCardBunch(numbers, Suit.HEARTS);
        assertEquals(
            expected,
            cardBunch.canDrawCard()
        );
    }

    private static Stream<Arguments> providerCanDrawCardParams() {
        return Stream.of(
            Arguments.of(Arrays.asList(6, 10), true),
            Arguments.of(Arrays.asList(10, 7), false)
        );
    }

    @DisplayName("Check if cards got busted")
    @ParameterizedTest
    @MethodSource("providerIsBustParams")
    void isBust(List<Integer> numbers, boolean expected) {
        CardBunch cardBunch = new DealerCardBunch(numbers, Suit.HEARTS);
        assertEquals(
            expected,
            cardBunch.isBust()
        );
    }

    private static Stream<Arguments> providerIsBustParams() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 10), false),
            Arguments.of(Arrays.asList(10, 10, 2), true)
        );
    }

    @DisplayName("Check if CardBunch returns correct information.")
    @Test
    void getCardBunchInfo() {
        assertEquals(
            new CardBunchInfo(
                Stream.of(1, 7, 10).map(
                    n -> new CardInfo(
                        Denomination.of(n),
                        Suit.HEARTS
                    )
                ).collect(
                    Collectors.toList()
                )
            ),
            new DealerCardBunch(
                List.of(1, 7, 10),
                Suit.HEARTS
            ).getCardBunchInfo()
        );
    }

    @DisplayName("Check if CardBunch returns correct information with first card only")
    @Test
    void getFirstCardBunchInfo() {
        assertEquals(
            new CardBunchInfo(
                List.of(
                    new CardInfo(Denomination.ACE, Suit.HEARTS)
                )
            ),
            new DealerCardBunch(
                List.of(1, 7),
                Suit.HEARTS
            ).getFirstCardBunchInfo()
        );
    }
}