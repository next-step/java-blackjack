package blackjack.domain;

import blackjack.dto.NameInfo;
import blackjack.dto.PersonCardsInfo;
import blackjack.dto.ScoreInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DealerTest {
    private Dealer testDealer;

    @BeforeEach
    void setUp() {
        testDealer = new Dealer(
            new CardBunch(
                List.of(1, 7, 10),
                Suit.HEARTS
            )
        );
    }

    @DisplayName("Check Dealer return drawable status well")
    @ParameterizedTest
    @MethodSource("providerCanDrawCardParams")
    void canDrawCard(List<Integer> numbers, boolean canDrawCard) {
        Dealer dealer = new Dealer(
            new CardBunch(
                numbers, Suit.HEARTS
            )
        );

        assertEquals(
            canDrawCard,
            dealer.canDrawCard()
        );
    }

    private static Stream<Arguments> providerCanDrawCardParams() {
        return Stream.of(
            Arguments.of(Arrays.asList(6, 10), true),
            Arguments.of(Arrays.asList(10, 7), false)
        );
    }

    @DisplayName("Check Dealer initialized card from deck well")
    @Test
    void initializeFromDeck() {
        Deck deck = new Deck(
            new ArrayList<>() {{
                add(new Card(Denomination.ACE, Suit.HEARTS));
                add(new Card(Denomination.ACE, Suit.HEARTS));
            }}
        );
        testDealer.initializeFromDeck(deck);

        assertEquals(
            new Dealer(
                new CardBunch(
                    List.of(1, 7, 10, 1, 1),
                    Suit.HEARTS
                )
            ).getScoreInfo(),
            testDealer.getScoreInfo()
        );
    }

    @DisplayName("Check Dealer draw card from deck well")
    @Test
    void drawCardFromDeck() {
        Deck deck = new Deck(
            new ArrayList<>() {{
                add(new Card(Denomination.ACE, Suit.HEARTS));
            }}
        );
        testDealer.drawCardFromDeck(deck);

        assertEquals(
            new Dealer(
                new CardBunch(
                    List.of(1, 7, 10, 1),
                    Suit.HEARTS
                )
            ).getScoreInfo(),
            testDealer.getScoreInfo()
        );
    }

    @DisplayName("Check dealer return correct Dealer name information")
    @Test
    void getNameInfo() {
        assertEquals(
            new NameInfo("딜러"),
            testDealer.getNameInfo()
        );
    }

    @DisplayName("Check dealer return correct Dealer cards information")
    @Test
    void getPersonCardsInfo() {
        assertEquals(
            new PersonCardsInfo("딜러", List.of("A하트", "7하트", "10하트")),
            testDealer.getPersonCardsInfo()
        );
    }

    @DisplayName("Check dealer return correct Dealer score information")
    @Test
    void getScoreInfo() {
        assertEquals(
            new ScoreInfo("딜러", List.of("A하트", "7하트", "10하트"), 18),
            testDealer.getScoreInfo()
        );
    }
}