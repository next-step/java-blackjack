package blackjack.domain;

import static blackjack.domain.Denomination.ACE;
import static blackjack.domain.Denomination.FIVE;
import static blackjack.domain.Denomination.JACK;
import static blackjack.domain.Denomination.KING;
import static blackjack.domain.Denomination.QUEEN;
import static blackjack.domain.Suit.CLUBS;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    private Player player;
    private CardDeck cardDeck;

    @BeforeEach
    void setUp() {
        player = new Player(new Cards(new ArrayList<>(Arrays.asList(new Card(CLUBS, ACE)))));
        cardDeck = new CardDeck();
    }

    @DisplayName("카드 숫자의 총합이 21이상이면 player는 bust한다")
    @Test
    void bustWhenCardsScoreIsOver21() {
        List<Card> cards = Arrays.asList(
            new Card(CLUBS, KING),
            new Card(CLUBS, QUEEN),
            new Card(CLUBS, JACK)
        );

        Cards testCards = new Cards(cards);
        Player player = new Player(testCards);

        assertThat(player.isBusted()).isTrue();
    }

}
