package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.Card.CardType;
import blackjack.domain.Card.CardValue;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DealerTest {

    @DisplayName("현재 딜러의 카드 점수가 17 을 넘을 때 카드 뽑기")
    @Test
    void dealerDrawCardWhenSumCardScoreOver17() {
        // given
        List<CardType> types = Arrays.asList(CardType.CLOVER);
        List<CardValue> values = Arrays.asList(CardValue.KING, CardValue.KING, CardValue.KING);
        Deck deck = new Deck(types, values);

        Participant dealer = new Dealer("dealer");
        dealer.drawCardContinue(deck);
        dealer.drawCardContinue(deck);
        dealer.drawCardContinue(deck);

        // when
        int result = dealer.sumCardScore();

        // then
        assertThat(result).isEqualTo(20);
    }

    @DisplayName("현재 딜러의 카드 점수가 17 이하 일 때 카드 뽑기")
    @Test
    void dealerDrawCardWhenSumCardScoreUnder17() {
        // given
        List<CardType> types = Arrays.asList(CardType.CLOVER);
        List<CardValue> values = Arrays.asList(CardValue.THREE, CardValue.FOUR, CardValue.KING);
        Deck deck = new Deck(types, values);

        Participant dealer = new Dealer("dealer");
        dealer.drawCardContinue(deck);
        dealer.drawCardContinue(deck);
        dealer.drawCardContinue(deck);

        // when
        int result = dealer.sumCardScore();

        // then
        assertThat(result).isEqualTo(17);
    }
}