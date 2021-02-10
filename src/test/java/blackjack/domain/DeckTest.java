package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rent.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class DeckTest {
    @DisplayName("Check deck returns first card well")
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
    
    @DisplayName("Check deck is composed with different 52 cards")
    @Test
    void deckSizeTest() {
        Deck deck = new Deck();

        Set<Card> deckSet = IntStream.range(0, 52).mapToObj(
            i -> deck.drawCard()
        ).collect(
            Collectors.toSet()
        );

        assertEquals(
            52,
            deckSet.size()
        );
    }
}