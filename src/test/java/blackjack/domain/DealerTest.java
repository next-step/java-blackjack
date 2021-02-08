package blackjack.domain;

import blackjack.dto.CardBunchInfo;
import blackjack.dto.CardInfo;
import blackjack.dto.NameInfo;
import blackjack.dto.PlayerInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DealerTest {
    private static Dealer testDealer;

    @BeforeAll
    static void beforeAll() {
        testDealer = new Dealer(
            new CardBunch(
                Stream.of(1, 7, 10).map(
                    n -> new Card(
                        Denomination.of(n),
                        Suit.HEARTS
                    )
                ).collect(
                    Collectors.toList()
                )
            )
        );
    }
    // TODO : How to check requestCard method on dealer?

    @DisplayName("Check if dealer got busted")
    @ParameterizedTest
    @MethodSource("providerIsBustParams")
    void isBust(List<Integer> numbers, boolean expected) {
        Dealer dealer = new Dealer(
            new CardBunch(
                numbers.stream().map(
                    n -> new Card(
                        Denomination.of(n),
                        Suit.HEARTS
                    )
                ).collect(
                    Collectors.toList()
                )
            )
        );
        assertEquals(
            expected,
            dealer.isBust()
        );
    }

    private static Stream<Arguments> providerIsBustParams() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 10), false),
            Arguments.of(Arrays.asList(10, 9, 8), true)
        );
    }

    @DisplayName("Check if the Dealer return correct dealer information")
    @Test
    void getPlayerInfo() {
        assertEquals(
            new PlayerInfo(
                new NameInfo("딜러"),
                new CardBunchInfo(
                    Stream.of(1, 7, 10).map(
                        n -> new CardInfo(
                            Denomination.of(n),
                            Suit.HEARTS
                        )
                    ).collect(
                        Collectors.toList()
                    )
                )
            ),
            testDealer.getPlayerInfo()
        );
    }

    @DisplayName("Check if the Dealer return corret dealer name information")
    @Test
    void getNameInfo() {
        assertEquals(
            new NameInfo("딜러"),
            testDealer.getNameInfo()
        );
    }
}