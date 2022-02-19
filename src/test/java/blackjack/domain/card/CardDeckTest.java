package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import blackjack.domain.cards.CardDeck;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CardDeckTest {

    @Test
    void 인스턴스를_생성하면_52가지_카드를_가진다() {
        CardDeck cardDeck = new CardDeck();
        assertThat(cardDeck.getCards()).hasSize(52);
    }

    @Test
    void 카드를_뽑으면_카드_목록에서_제거된다() {
        //given
        CardDeck cardDeck = new CardDeck();
        //when
        Card pickedCard = cardDeck.pickOneCard();
        //then
        assertThat(cardDeck.getCards().contains(pickedCard)).isFalse();
    }

    @Test
    void 카드덱이_비면_카드를_뽑을_수_없다() {
        //given
        CardDeck cardDeck = new CardDeck() {
            @Override
            public List<Card> createCardDeck() {
                return new ArrayList<>();
            }
        };
        //when, then
        assertThatThrownBy(cardDeck::pickOneCard)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 카드덱이 비어 카드를 뽑을 수 없습니다.");
    }
}
