package blackjack.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FinalResultTest {

    private final FinalResult finalResult = new FinalResult();

    @ParameterizedTest
    @DisplayName("최종 결과 계산하기")
    @MethodSource("provideCalculateFinalResult")
    void calculateFinalResult(Dealer dealer, Gamers gamers, Map<String, String> expected) {
        finalResult.calculateFinalResult(dealer, gamers);
        assertEquals(expected, finalResult.getFinalWinner());
    }

    private static Stream<Arguments> provideCalculateFinalResult() {
        Deck deck = new Deck(true);
        return Stream.of(
            Arguments.of(
                new Dealer(deck),
                new Gamers("daeun,mimi", deck),
                new HashMap<String, String>() {
                    {
                        put("daeun", "승");
                        put("mimi", "패");
                    }
                }
            )
        );
    }

    @ParameterizedTest
    @DisplayName("게이머들의 점수 계산하기")
    @MethodSource("provideCalculateGamerScore")
    void calculateGamerScore(Gamers gamers, List<Score> expected) {
        finalResult.calculateGamerScore(gamers);
        assertEquals(expected, finalResult.getScores());
    }

    private static Stream<Arguments> provideCalculateGamerScore() {
        Deck deck = new Deck(true);
        return Stream.of(
            Arguments.of(
                new Gamers("daeun,mimi,hello", deck),
                Arrays.asList(
                    new Score(20),
                    new Score(20),
                    new Score(17)
                )
            )
        );
    }
}
