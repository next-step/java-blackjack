package blackjack;

import blackjack.model.Card;
import blackjack.model.Dealer;
import blackjack.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DealerTest {
    Dealer dealer;

    @BeforeEach
    void setUp() {
        dealer = new Dealer();
        dealer.initialCardSetting();
    }

    @DisplayName(value = "딜러가 가지고 있는 카드들 보기")
    @Test
    void show_cards() {
        List<Card> cards = dealer.getCards();
        for(Card card : cards) {
            System.out.println(card.getDenominationName() + " " + card.getSuitName());
        }
    }

    @DisplayName(value = "딜러가 가지고 있는 카드들 점수 보기")
    @Test
    void add_score() {
        List<Card> cards = dealer.getCards();
        for(Card card : cards) {
            System.out.println(card.getDenominationName() + " " + card.getSuitName());
        }
        System.out.println(dealer.score());
    }

    @DisplayName(value = "추가 카드 뽑기")
    @Test
    void additional_card_setting() {
        List<Card> cards = dealer.getCards();
        for(Card card : cards) {
            System.out.println(card.getDenominationName() + " " + card.getSuitName());
        }
        System.out.println();

        dealer.additionalCardSetting();
        cards = dealer.getCards();
        for(Card card : cards) {
            System.out.println(card.getDenominationName() + " " + card.getSuitName());
        }
    }
}
