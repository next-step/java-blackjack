package blackjack.domain.card;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Test;

class CardDeckTest {

    @Test
    void 카드덱은_52가지_카드를_생성해야_한다() {
        List<Card> cards = CardDeck.createCardDeck();
        assertThat(cards.size()).isEqualTo(52);
    }

    @Test
    void 인스턴스를_생성하면_52가지_카드를_가진다() {
        CardDeck cardDeck = new CardDeck();
        assertThat(cardDeck.getCards().size()).isEqualTo(52);
    }

    @Test
    void 전달받은_개수만큼_카드를_뽑아서_반환한다() {
        CardDeck cardDeck = new CardDeck();
        int initialSize = cardDeck.getCards().size();
        List<Card> pickedCards = cardDeck.pickCards(5);

        assertAll(
            () -> assertThat(pickedCards.size()).isEqualTo(5),
            () -> assertThat(cardDeck.getCards().size()).isEqualTo(initialSize - 5)
        );
    }
}
