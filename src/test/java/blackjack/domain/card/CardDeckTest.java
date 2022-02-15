package blackjack.domain.card;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

}
