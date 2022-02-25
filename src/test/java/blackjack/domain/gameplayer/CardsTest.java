package blackjack.domain.gameplayer;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardSymbol;
import blackjack.domain.card.CardType;
import blackjack.domain.card.Cards;
import org.junit.jupiter.api.Test;

class CardsTest {

    @Test
    public void ACE가_포함되지않는_카드리스트는_모두_합산하여_계산한다() {
        //given
        Cards cards = new Cards();

        //when
        cards.receiveCard(new Card(CardSymbol.DIAMOND, CardType.FIVE));
        cards.receiveCard(new Card(CardSymbol.DIAMOND, CardType.FIVE));
        cards.receiveCard(new Card(CardSymbol.DIAMOND, CardType.FIVE));

        //then
        assertThat(cards.calculateCards()).isEqualTo(15);
    }

    @Test
    public void ACE가_포함된_카드리스트는_자체적으로_최선의합으로_계산한다() {
        //given
        Cards cards = new Cards();

        //when
        cards.receiveCard(new Card(CardSymbol.DIAMOND, CardType.ACE));
        cards.receiveCard(new Card(CardSymbol.DIAMOND, CardType.TEN));
        cards.receiveCard(new Card(CardSymbol.DIAMOND, CardType.NINE));

        //then
        assertThat(cards.calculateCards()).isEqualTo(20);
    }
}
