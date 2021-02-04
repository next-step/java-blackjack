package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class DeckTest {
    @DisplayName("첫번째 카드를 잘 뽑는지 확인한다.")
    @Test
    void drawCard() {
        Deck deck = new Deck(
            new ArrayList<>() {{
                add(new Card(Denomination.ACE, Suit.HEARTS));
                add(new Card(Denomination.FIVE, Suit.SPADES));
            }}
        );

        assertEquals(
            new Card(Denomination.ACE, Suit.HEARTS),
            deck.drawCard()
        );
    }
    
    @DisplayName("카드덱에서 총 52장의 카드를 뽑을수 있는지 확인한다.")
    @Test
    void deckSizeTest() {
        Deck deck = new Deck();
        IntStream.range(0, 52).forEach(
            i -> deck.drawCard()
        );
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(deck::drawCard);
    }
}