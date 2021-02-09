package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class DeckTest {
    @DisplayName("Check if Deck returns first item")
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
    
    @DisplayName("Check Card deck return maximum 52 cards")
    @Test
    void deckSizeTest() {
        Deck deck = new Deck();
        IntStream.range(0, 52).forEach(
            i -> deck.drawCard()
        );
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(deck::drawCard);
    }
}