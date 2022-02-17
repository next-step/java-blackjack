package blackjack;

import static org.assertj.core.api.Assertions.*;

import blackjack.domain.Card;
import blackjack.domain.CardNumber;
import blackjack.domain.Deck;
import blackjack.domain.Suit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class DeckTest {

    @Test
    void 덱의_사이즈는_52개이다() {
        Deck deck = Deck.create();

        assertThat(deck.deckSize()).isEqualTo(52);
    }

    @Test
    void 덱에서_한장의_카드를_뽑을_수_있다() {
        Card clubEight = new Card(CardNumber.EIGHT, Suit.CLUB);
        Card clubSeven = new Card(CardNumber.SEVEN, Suit.CLUB);

        List<Card> cards = new ArrayList<>(Arrays.asList(clubEight, clubSeven));

        Deck deck = new Deck(cards);

        Card card = deck.drawCard();
        Card expected = new Card(CardNumber.EIGHT, Suit.CLUB);

        assertThat(card).isEqualTo(expected);
    }

    @Test
    void 덱이_비어있을_때는_런타임_예외가_발생한다() {
        List<Card> cards = new ArrayList<>();
        Deck deck = new Deck(cards);

        assertThatThrownBy(deck::drawCard)
            .isInstanceOf(RuntimeException.class)
            .hasMessage("더 이상 카드를 뽑을 수 없습니다.");
    }
}
