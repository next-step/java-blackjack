package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MatchScoreTest {
    @DisplayName("Check calculated matchscore between two cardBunch is proper")
    @ParameterizedTest
    @MethodSource("providerCalcMatchScoreParams")
    void calcMatchScore(List<Integer> playerNumbers, List<Integer> dealerNumbers, MatchScore expected) {
        assertEquals(
            expected,
            MatchScore.calcMatchScore(
                new CardBunch(playerNumbers, Suit.HEARTS),
                new CardBunch(dealerNumbers, Suit.HEARTS)
            )
        );
    }

    private static Stream<Arguments> providerCalcMatchScoreParams() {
        return Stream.of(
            Arguments.of(List.of(10, 10, 2), List.of(10, 10), MatchScore.LOSE),
            Arguments.of(List.of(10, 10), List.of(10, 10, 2), MatchScore.WIN),
            Arguments.of(List.of(1, 10), List.of(1, 10), MatchScore.DRAW),
            Arguments.of(List.of(1, 10), List.of(10, 10), MatchScore.WIN),
            Arguments.of(List.of(10, 10), List.of(1, 10), MatchScore.LOSE),
            Arguments.of(List.of(9, 10), List.of(9, 10), MatchScore.DRAW),
            Arguments.of(List.of(10, 10), List.of(10, 9), MatchScore.WIN),
            Arguments.of(List.of(10, 9), List.of(10, 10), MatchScore.LOSE)
        );
    }

    @DisplayName("Check calculated opposite match score is proper")
    @ParameterizedTest
    @MethodSource("providerOppositeMatchScore")
    void oppositeMatchScore(MatchScore score, MatchScore oppositeScore) {
        assertEquals(
            oppositeScore,
            score.oppositeMatchScore()
        );
    }

    private static Stream<Arguments> providerOppositeMatchScore() {
        return Stream.of(
            Arguments.of(MatchScore.WIN, MatchScore.LOSE),
            Arguments.of(MatchScore.DRAW, MatchScore.DRAW),
            Arguments.of(MatchScore.LOSE, MatchScore.WIN)
        );
    }
}