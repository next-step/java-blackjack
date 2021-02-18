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

    @DisplayName("Check if dealer can draw card")
    @ParameterizedTest
    @MethodSource("providerCanDrawCardParams")
    void canDrawCard(List<Integer> numbers, boolean expected) {
        Dealer dealer = new Dealer(new CardBunch(numbers, Suit.HEARTS));
        assertEquals(
                expected,
                dealer.canDraw()
        );
    }

    private static Stream<Arguments> providerCanDrawCardParams() {
        return Stream.of(
                Arguments.of(Arrays.asList(6, 10), true),
                Arguments.of(Arrays.asList(10, 7), false)
        );
    }

    @DisplayName("Check if the Dealer gets correct initial card bunch")
    @Test
    void initCardTest() {
        Deck deck = new Deck(
                new ArrayList<>() {{
                    add(new Card(Denomination.ACE, Suit.HEARTS));
                    add(new Card(Denomination.FIVE, Suit.SPADES));
                }}
        );

        Dealer dealer = new Dealer();
        dealer.initialCard(deck);

        assertEquals(
                new CardBunch(
                        new ArrayList<>() {{
                            add(new Card(Denomination.ACE, Suit.HEARTS));
                            add(new Card(Denomination.FIVE, Suit.SPADES));
                        }}
                ),
                dealer.cardBunch
        );
    }
}