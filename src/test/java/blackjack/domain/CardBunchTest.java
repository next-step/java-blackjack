package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CardBunchTest {

    @DisplayName("Check if the calculated sum is correct")
    @ParameterizedTest
    @MethodSource("providerCalcScoreParams")
    void calcScore(List<Integer> numbers, int expectedScore) {
        CardBunch cardBunch = new CardBunch(
            numbers.stream().map(
                n -> new Card(
                    Denomination.of(n),
                    Suit.HEARTS
                )
            ).collect(
                Collectors.toList()
            )
        );

        assertEquals(
            expectedScore,
            cardBunch.calcScore()
        );
    }

    private static Stream<Arguments> providerCalcScoreParams() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 10), 21),
            Arguments.of(Arrays.asList(1, 10, 10), 21),
            Arguments.of(Arrays.asList(10, 9), 19)
        );
    }
}