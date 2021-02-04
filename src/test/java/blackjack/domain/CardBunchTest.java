package blackjack.domain;

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

import static org.junit.jupiter.api.Assertions.*;

class CardBunchTest {

    @DisplayName("가지고 있는 카드의 합을 제대로 구하는지 확인한")
    @ParameterizedTest
    @MethodSource("providerCalcScoreParams")
    void calcScore(List<Integer> number, int expectedScore) {
        CardBunch cardBunch = new CardBunch(
            number.stream().map(
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