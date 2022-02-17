package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckTest {

    private Deck deck;

    @BeforeEach
    void 덱_만들기() {
        deck = Deck.createDeck();
    }

    @Test
    void 게임에_사용할_덱_만들기() {
        Set<Card> cards = IntStream.range(0, 52)
            .mapToObj(card -> deck.cardDraw())
            .collect(Collectors.toSet());

        assertThat(cards.size()).isEqualTo(52);
    }
}
