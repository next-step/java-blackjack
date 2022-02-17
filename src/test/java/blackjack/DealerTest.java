package blackjack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import blackjack.domain.Card;
import blackjack.domain.CardNumber;
import blackjack.domain.Cards;
import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.Suit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DealerTest {

    static Stream<Arguments> cardSetCases() {
        return Stream.of(
            Arguments.of(new Cards(getCards(
                new Card(CardNumber.THREE, Suit.DIAMOND),
                new Card(CardNumber.NINE, Suit.CLUB)
            )), true),
            Arguments.of(new Cards(getCards(
                new Card(CardNumber.EIGHT, Suit.DIAMOND),
                new Card(CardNumber.TEN, Suit.CLUB)
            )), false)
        );
    }

    @ParameterizedTest
    @MethodSource("cardSetCases")
    void 총합_16이하일경우_한장_새로_뽑기(Cards cards, boolean expected) {
        Dealer dealer = new Dealer("딜러", cards);

        assertEquals(dealer.canDrawCard(), expected);
    }

    @Test
    void 새로_뽑은_카드_보유_여부_검증() {
        Deck deck = Deck.create();
        Dealer dealer = new Dealer("딜러", new Cards(new ArrayList<>()));
        dealer.initializeDeck(deck);
        dealer.drawCard(deck);

        assertEquals(dealer.cardSize(), 3);
    }

    private static List<Card> getCards(Card ...cards) {
        return Stream.of(cards).collect(Collectors.toList());
    }
}
