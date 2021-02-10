package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    @DisplayName("Check generate correct result with value")
    @ParameterizedTest
    @MethodSource("providerOfWithProperScoreParams")
    void ofWithProperValue(int value, Result result) {
        assertEquals(
            result,
            Result.of(value)
        );
    }

    private static Stream<Arguments> providerOfWithProperScoreParams() {
        return Stream.of(
            Arguments.of(-1, Result.WIN),
            Arguments.of(0, Result.DRAW),
            Arguments.of(1, Result.LOSE)
        );
    }

    @DisplayName("Check if the function throws error on wrong input")
    @Test
    void ofWithWrongScore() {
        assertThrows(
            RuntimeException.class,
            () -> Result.of(2)
        );
    }

    @DisplayName("Check if the function generate correct result")
    @ParameterizedTest
    @MethodSource("providerCalcResultParams")
    void calcResult(List<Integer> first, List<Integer> second, Result expected) {
        assertEquals(
            expected,
            Result.calcResult(
                new CardBunch(first, Suit.HEARTS),
                new CardBunch(second, Suit.HEARTS)
            )
        );
    }

    private static Stream<Arguments> providerCalcResultParams() {
        return Stream.of(
            Arguments.of(List.of(1, 10), List.of(10, 10), Result.WIN),
            Arguments.of(List.of(1, 10), List.of(1, 10), Result.DRAW),
            Arguments.of(List.of(9, 10), List.of(1, 10), Result.LOSE)
        );
    }


}