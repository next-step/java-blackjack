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

    @DisplayName("카드 숫자의 총합이 21이상이면 player는 bust한다")
    @Test
    void bustWhenCardsScoreIsOver21() {
        List<Card> cards = Arrays.asList(
            new Card(CLUBS, KING),
            new Card(CLUBS, QUEEN),
            new Card(CLUBS, JACK)
        );

        Cards testCards = new Cards(cards);
        Player player = new Player(testCards, "james");

        assertThat(player.isBusted()).isTrue();
    }

    @DisplayName("플레이어가 받은 카드 한 장을 출력한다")
    @Test
    void printCardAfterFirstDeal() {
        List<Card> cards = Arrays.asList(
            new Card(CLUBS, KING),
            new Card(CLUBS, QUEEN)
        );

        Cards testCards = new Cards(cards);
        Player player = new Player(testCards, "test");

        assertThat(player.openCard()).isEqualTo("test카드: K클로버, Q클로버");
    }


}
