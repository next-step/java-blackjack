package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CardPackTest {

    @Test
    public void 초기_카드팩은_52장의_카드가_생성된다() {
        //given
        CardPack cardPack = CardPack.create();

        //when
        List<Card> cards = cardPack.getCardPack();

        //then
        assertThat(cards.size()).isEqualTo(52);
    }

    @Test
    public void 카드팩에서_한장_빼온뒤에는_카드팩에_남아있는_재고가_하나_감소한다() {
        //given
        CardPack cardPack = CardPack.create();

        //when
        cardPack.pick();

        //then
        assertThat(cardPack.getCardPack().size()).isEqualTo(51);
    }
}
