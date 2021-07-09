package blackjack;

import blackjack.model.Card;
import blackjack.model.Denomination;
import blackjack.model.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {
    Card card;

    @BeforeEach
    void setUp() {
        card = new Card(Denomination.ACE, Suit.CLUBS);
    }

    @DisplayName(value = "denomination 이름 출력하기")
    @Test
    void show_denomination_name() {
        System.out.println("denomination = " + card.getDenomination());
        assertThat(card.getDenominationName()).isEqualTo("ACE");
    }

    @DisplayName(value = "suit 이름 출력하기")
    @Test
    void show_suit_name() {
        System.out.println("suit = " + card.getSuitName());
        assertThat(card.getSuitName()).isEqualTo("CLUBS");
    }
}
