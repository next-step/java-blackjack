package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CardPackTest {

    @Test
    public void 초기_카드팩은_52장의_카드가_생성된다() {
        //given
        CardPack cardPack = new CardPack();

        //when
        List<Card> cards = cardPack.getCards();

        //then
        assertThat(cards.size()).isEqualTo(52);
    }

    @Test
    public void 카드팩에서_한장_빼온뒤에는_카드팩에_남아있는_재고가_하나_감소한다() {
        //given
        CardPack cardPack = new CardPack();

        //when
        cardPack.pick();

        //then
        assertThat(cardPack.getCards().size()).isEqualTo(51);
    }

    @Test
    public void 카드팩_생성초기_카드팩은_셔플되어지지_않은_상태다() {
        //given
        CardPack cardPack = new CardPack();
        List<Card> originCards = cardPack.getCards();

        //when
        final List<Card> cards = new ArrayList<>();
        for (final CardSymbol symbol : CardSymbol.values()) {
            Arrays.stream(CardType.values())
                .forEach(type -> cards.add(new Card(symbol, type)));
        }

        //then
        assertThat(originCards).containsExactly(cards.toArray(new Card[0]));
    }

    @Test
    public void 카드가_정상적으로_셔플되어진다() {
        //given
        CardPack cardPack = new CardPack();

        //when
        List<Card> originCards = cardPack.getCards();
        cardPack.shuffle();
        List<Card> shuffleCards = cardPack.getCards();

        //then
        assertThat(originCards).doesNotContainSequence(shuffleCards.toArray(new Card[0]));
    }
}
