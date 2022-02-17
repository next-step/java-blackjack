package blackjack.domain;

import static blackjack.domain.Denomination.ACE;
import static blackjack.domain.Denomination.FIVE;
import static blackjack.domain.Denomination.KING;
import static blackjack.domain.Denomination.QUEEN;
import static blackjack.domain.Suit.CLUBS;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DealerTest {

    @DisplayName("카드 점수의 합이 16 이하일 때, 카드를 한 장 더 받는다")
    @Test
    void hitWhenCardsScoreIsUnder17() {
        List<Card> cards = Arrays.asList(
            new Card(CLUBS, ACE),
            new Card(CLUBS, FIVE)
        );

        Cards testCards = new Cards(cards);
        Dealer dealer = new Dealer(testCards);

        assertThat(dealer.checkHitOrNot()).isTrue();
    }

    @DisplayName("카드 점수의 합이 17을 넘으면, 카드를 받을 수 없다")
    @Test
    void noHitWhenCardsScoreIsOver17() {
        List<Card> cards = Arrays.asList(
            new Card(CLUBS, KING),
            new Card(CLUBS, QUEEN)
        );

        Cards testCards = new Cards(cards);
        Dealer dealer = new Dealer(testCards);

        assertThat(dealer.checkHitOrNot()).isFalse();
    }

    @DisplayName("딜러가 받은 카드 한 장을 출력한다")
    @Test
    void printCardAfterFirstDeal() {
        List<Card> cards = Arrays.asList(
            new Card(CLUBS, KING),
            new Card(CLUBS, QUEEN)
        );

        Cards testCards = new Cards(cards);
        Dealer dealer = new Dealer(testCards);

        assertThat(dealer.openOneCard()).isEqualTo("K클로버");
    }
}
