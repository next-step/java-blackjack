package blackjack.domain;

import blackjack.dto.NameInfo;
import blackjack.dto.PersonInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DealerTest {
    private static Dealer testDealer;

    @BeforeAll
    static void beforeAll() {
        testDealer = new Dealer(
            new CardBunch(List.of(1, 7, 10), Suit.HEARTS)
        );
    }

    @DisplayName("Check that dealer draw card well by dealers logic")
    @ParameterizedTest
    @MethodSource("providerRequestCardParams")
    void requestCard(List<Integer> cards, List<Integer> expected) {
        Dealer dealer = new Dealer(
            new CardBunch(
                cards,
                Suit.HEARTS
            )
        );

        Deck deck = new Deck(
            new ArrayList<>() {{
                add(new Card(Denomination.FOUR, Suit.HEARTS));
            }}
        );

        dealer.requestCard(deck);
        assertEquals(
            new PersonInfo(
                new NameInfo("딜러"),
                new CardBunch(
                    expected,
                    Suit.HEARTS
                ).getCardBunchInfo()
            ),
            dealer.getPersonInfo()
        );
    }

    private static Stream<Arguments> providerRequestCardParams() {
        return Stream.of(
            Arguments.of(Arrays.asList(3, 10), Arrays.asList(3, 10, 4)),
            Arguments.of(Arrays.asList(7, 10), Arrays.asList(7, 10))
        );
    }

    @DisplayName("Check if dealer got busted")
    @ParameterizedTest
    @MethodSource("providerIsBustParams")
    void isBust(List<Integer> numbers, boolean expected) {
        Dealer dealer = new Dealer(
            new CardBunch(numbers, Suit.HEARTS)
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
    void getPersonInfo() {
        assertEquals(
            new PersonInfo(
                new NameInfo("딜러"),
                new CardBunch(
                    List.of(1, 7, 10),
                    Suit.HEARTS
                ).getCardBunchInfo()
            ),
            testDealer.getPersonInfo()
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