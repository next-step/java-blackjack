package blackjack.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DeckTest {

    private static Deck deck;

    @BeforeAll
    static void init() {
        deck = new Deck(true);
    }

    @DisplayName("카드 뽑기 테스트")
    @ParameterizedTest
    @MethodSource("providePopCardTest")
    void popCardTest(Card expected) {
        assertEquals(deck.popCard(), expected);
    }

    private static Stream<Arguments> providePopCardTest() {

        return Stream.of(
            Arguments.of(
                new Card(Suit.SPADES, Denomination.KING)
            ),
            Arguments.of(
                new Card(Suit.SPADES, Denomination.QUEEN)
            )
        );
    }

    @DisplayName("카드 추가 테스트")
    @ParameterizedTest
    @MethodSource("provideAddCardTest")
    void addCardTest(Card expected) {
        deck.addCard(expected);
        assertEquals(deck.popCard(), expected);
    }

    private static Stream<Arguments> provideAddCardTest() {

        return Stream.of(
            Arguments.of(
                new Card(Suit.SPADES, Denomination.KING)
            ),
            Arguments.of(
                new Card(Suit.DIAMONDS, Denomination.KING)
            )
        );
    }
}
