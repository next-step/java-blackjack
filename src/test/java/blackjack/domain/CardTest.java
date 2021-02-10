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

    @DisplayName("Check return card is ace status well")
    @ParameterizedTest
    @MethodSource("providerIsAceTestParams")
    public void isAceTest(Denomination denomination, boolean isAce) {
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

    @DisplayName("Check card return correct card information")
    @Test
    public void getCardInfo() {
        assertEquals(
            new CardInfo(Denomination.ACE, Suit.HEARTS),
            new Card(Denomination.ACE, Suit.HEARTS).getCardInfo()
        );
    }
}