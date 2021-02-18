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

import static org.junit.jupiter.api.Assertions.*;

class CardBunchTest {

    @DisplayName("Check if cards got busted")
    @ParameterizedTest
    @MethodSource("providerIsBustParams")
    void isBust(List<Integer> numbers, boolean expected) {
        CardBunch cardBunch = new CardBunch(numbers, Suit.HEARTS);
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
                new CardBunch(
                        List.of(1, 7, 10),
                        Suit.HEARTS
                ).getCardBunchInfo()
        );
    }
}