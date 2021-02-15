package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MatchScoreTest {
    @DisplayName("Check calculated match score between two cardBunch is proper")
    @ParameterizedTest
    @MethodSource("providerCalcMatchScoreParams")
    void calcMatchScore(List<Integer> playerNumbers, List<Integer> dealerNumbers, double dividend) {
        assertEquals(
            dividend,
            MatchScore.calcDividend(
                new CardBunch(playerNumbers, Suit.HEARTS),
                new CardBunch(dealerNumbers, Suit.HEARTS)
            )
        );
    }

    private static Stream<Arguments> providerCalcMatchScoreParams() {
        return Stream.of(
            Arguments.of(List.of(10, 10, 2), List.of(10, 10), -1.0),
            Arguments.of(List.of(10, 10), List.of(10, 10, 2), 1.0),
            Arguments.of(List.of(1, 10), List.of(1, 10), 0.0),
            Arguments.of(List.of(1, 10), List.of(10, 10), 1.5),
            Arguments.of(List.of(10, 10), List.of(1, 10), -1.0),
            Arguments.of(List.of(9, 10), List.of(9, 10), 0.0),
            Arguments.of(List.of(10, 10), List.of(10, 9), 1.0),
            Arguments.of(List.of(10, 9), List.of(10, 10), -1.0)
        );
    }
}