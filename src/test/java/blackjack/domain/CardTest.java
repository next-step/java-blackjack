package blackjack.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CardTest {
    @DisplayName("카드 이름 스트링화 테스트")
    @ParameterizedTest
    @MethodSource("provideToStringTest")
    void toStringTest(String expected, Card card) {
        assertEquals(card.toString(), expected);
    }

    private static Stream<Arguments> provideToStringTest() {
        return Stream.of(
            Arguments.of(
                "A클로버",
                new Card(Suit.CLUBS, Denomination.ACE)
            ),
            Arguments.of(
                "2클로버",
                new Card(Suit.CLUBS, Denomination.TWO)
            )
        );
    }
}
