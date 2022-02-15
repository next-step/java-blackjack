package blackjack.domain;

import static blackjack.domain.Denomination.ACE;
import static blackjack.domain.Denomination.FIVE;
import static blackjack.domain.Denomination.FOUR;
import static blackjack.domain.Denomination.THREE;
import static blackjack.domain.Denomination.TWO;
import static blackjack.domain.Suit.CLUBS;
import static blackjack.domain.Suit.HEARTS;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardsTest {

    private Cards cards;

    @BeforeEach
    void setUp() {
        cards = new Cards(new ArrayList<>(Arrays.asList(new Card(CLUBS, ACE))));
    }

    @DisplayName("새로운 카드를 추가할 수 있다")
    @Test
    void addCard() {
        Card testCard = new Card(HEARTS, TWO);

        cards.addCard(testCard);

        List<Card> testCards = cards.getCards();

        assertThat(testCards).contains(testCard);
        assertThat(testCards.size()).isEqualTo(2);
    }

    @DisplayName("카드들의 점수 합을 반환한다")
    @Test
    void getScore() {
        List<Card> cards = Arrays.asList(
            new Card(CLUBS, ACE),
            new Card(CLUBS, TWO),
            new Card(CLUBS, THREE),
            new Card(CLUBS, FOUR),
            new Card(CLUBS, FIVE)
        );

        Cards testCards = new Cards(cards);
        assertThat(testCards.getScore()).isEqualTo(15);
    }
}
