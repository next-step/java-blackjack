package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CardBunchTest {
    @DisplayName("Check card was added to cardBunch well")
    @Test
    void addCard() {
        CardBunch cardBunch = new CardBunch(
            List.of(1, 7), Suit.HEARTS
        );

        cardBunch.addCard(
            new Card(Denomination.FIVE, Suit.HEARTS)
        );

        assertEquals(
            new CardBunch(
                List.of(1, 7, 5), Suit.HEARTS
            ).getCardsName(),
            cardBunch.getCardsName()
        );
    }

    @DisplayName("Check cardBunch return blackjack status well")
    @ParameterizedTest
    @MethodSource("providerIsBlackJackParams")
    void isBlackJack(List<Integer> numbers, boolean isBlackJack) {
        CardBunch cardBunch = new CardBunch(numbers, Suit.HEARTS);
        assertEquals(
            isBlackJack,
            cardBunch.isBlackJack()
        );
    }

    private static Stream<Arguments> providerIsBlackJackParams() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 10), true),
            Arguments.of(Arrays.asList(5, 6, 10), true),
            Arguments.of(Arrays.asList(10, 10), false)
        );
    }

    @DisplayName("Check cardBunch return bust status well")
    @ParameterizedTest
    @MethodSource("providerIsBustParams")
    void isBust(List<Integer> numbers, boolean isBust) {
        CardBunch cardBunch = new CardBunch(numbers, Suit.HEARTS);
        assertEquals(
            isBust,
            cardBunch.isBust()
        );
    }

    private static Stream<Arguments> providerIsBustParams() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 10), false),
            Arguments.of(Arrays.asList(10, 10, 2), true)
        );
    }

    @DisplayName("Check cardBunch calculate score well")
    @ParameterizedTest
    @MethodSource("providerCalcScoreParams")
    void calcScore(List<Integer> numbers, int score) {
        CardBunch cardBunch = new CardBunch(numbers, Suit.HEARTS);
        assertEquals(
            score,
            cardBunch.calcScore()
        );
    }

    private static Stream<Arguments> providerCalcScoreParams() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 10), 21),
            Arguments.of(Arrays.asList(1, 7, 10), 18),
            Arguments.of(Arrays.asList(10, 10, 2), 22)
        );
    }

    @DisplayName("Check cardBunch return correct cards name information")
    @Test
    void getFirstCardName() {
        assertEquals(
            List.of("A하트"),
            new CardBunch(
                List.of(1, 7, 10),
                Suit.HEARTS
            ).getFirstCardName()
        );
    }

    @DisplayName("Check cardBunch throw error if not exist first card")
    @Test
    void getFirstCardNameWithoutFirstCard() {
        assertThrows(
            RuntimeException.class,
            () -> new CardBunch().getFirstCardName()
        );
    }

    @DisplayName("Check cardBunch return correct cards name information")
    @Test
    void getCardsName() {
        assertEquals(
            List.of("A하트", "7하트", "10하트"),
            new CardBunch(
                List.of(1, 7, 10),
                Suit.HEARTS
            ).getCardsName()
        );
    }
}