package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DenominationTest {

    @DisplayName("Check if the denomination is Ace")
    @ParameterizedTest
    @MethodSource("providerIsAceTestParams")
    void isAceTest(Denomination denomination, boolean expected) {
        assertEquals(
            expected,
            denomination.isAce()
        );
    }

    private static Stream<Arguments> providerIsAceTestParams() {
        return Stream.of(
            Arguments.of(Denomination.ACE, true),
            Arguments.of(Denomination.KING, false)
        );
    }

    @DisplayName("Check generate correct denominations with score")
    @ParameterizedTest
    @MethodSource("providerOfWithProperScoreParams")
    void ofWithProperScore(int score, Denomination denomination) {
        assertEquals(
            denomination,
            Denomination.of(score)
        );
    }

    private static Stream<Arguments> providerOfWithProperScoreParams() {
        return Stream.of(
            Arguments.of(1, Denomination.ACE),
            Arguments.of(10, Denomination.TEN)
        );
    }

    @DisplayName("Check if the function throws error on wrong input")
    @Test
    void ofWithWrongScore() {
        assertThrows(
            RuntimeException.class,
            () -> Denomination.of(11)
        );
    }
}