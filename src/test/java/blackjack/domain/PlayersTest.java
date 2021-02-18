package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    @DisplayName("Check if the players class have active user")
    @ParameterizedTest
    @MethodSource("providerHasUserTestParams")
    void hasUserTest(Integer index, boolean expected) {
        Players testPlayers = PlayersFactory.generatePlayers("p1,p2");
        IntStream.range(0, index).forEach(n -> testPlayers.incrementPlayerIndex());

        assertEquals(expected, testPlayers.hasUser());
    }

    private static Stream<Arguments> providerHasUserTestParams() {
        return Stream.of(
                Arguments.of(3, false),
                Arguments.of(1, true)
        );
    }
}