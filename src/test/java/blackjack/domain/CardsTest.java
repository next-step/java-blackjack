package blackjack.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CardsTest {

    @DisplayName("카드 스코어 가져오기 테스트")
    @ParameterizedTest
    @MethodSource("provideGetScoreTest")
    void getScoreTest(List<Card> cardList, Score expected) {
        Cards cards = new Cards();
        cardList.forEach(cards::addCard);
        assertEquals(cards.getScore(), expected);
    }

    private static Stream<Arguments> provideGetScoreTest() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                new Card(Suit.CLUBS, Denomination.ACE),
                new Card(Suit.DIAMONDS, Denomination.JACK)
            ), new Score(21)),
            Arguments.of(Arrays.asList(
                new Card(Suit.CLUBS, Denomination.JACK),
                new Card(Suit.DIAMONDS, Denomination.JACK)
            ), new Score(20))
        );
    }

}