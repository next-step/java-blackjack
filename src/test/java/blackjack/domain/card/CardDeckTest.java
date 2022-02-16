package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Test;

class CardDeckTest {

    @Test
    void 인스턴스를_생성하면_52가지_카드를_가진다() {
        CardDeck cardDeck = new CardDeck();
        assertThat(cardDeck.getCards()).hasSize(52);
    }

    @Test
    void 전달받은_개수만큼_카드를_뽑아서_반환한다() {
        CardDeck cardDeck = new CardDeck();
        List<Card> initialCards = cardDeck.getCards();
        List<Card> pickedCards = cardDeck.pickCards(5);

        assertAll(
            () -> assertThat(pickedCards).hasSize(5),
            () -> assertThat(cardDeck.getCards()).hasSize(initialCards.size() - 5)
        );
    }
}
