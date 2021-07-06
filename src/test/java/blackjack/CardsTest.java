package blackjack;

import blackjack.model.Card;
import blackjack.model.Cards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CardsTest {
    @DisplayName(value = "카드 52장 출력해보기")
    @Test
    void show_cards() {
        List<Card> cards = Cards.getCards();
        for(Card card : cards) {
            System.out.println(card.getDenominationName() + " " + card.getSuitName());
        }
    }
}
