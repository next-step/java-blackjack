package blackjack.domain;

import blackjack.dto.CardInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @DisplayName("Check if card is ace")
    @ParameterizedTest
    @MethodSource("providerIsAceTestParams")
    void isAceTest(Denomination denomination, boolean isAce) {
        assertEquals(
                isAce,
                new Card(denomination, Suit.HEARTS).isAce()
        );
    }

    private static Stream<Arguments> providerIsAceTestParams() {
        return Stream.of(
                Arguments.of(Denomination.ACE, true),
                Arguments.of(Denomination.KING, false)
        );
    }

    @DisplayName("Check if the Card return correct information")
    @Test
    void getCardInfo() {
        assertEquals(
                new CardInfo(Denomination.ACE, Suit.HEARTS),
                new Card(Denomination.ACE, Suit.HEARTS).getCardInfo()
        );
    }
}