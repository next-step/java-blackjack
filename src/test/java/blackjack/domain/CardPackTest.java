package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardPack;
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

//    @Test
//    public void 각_심볼별_카드에는_12개의_카드가_존재한다() {
//        //given
//        List<String> cardMapKeys = new ArrayList<>(cardMap.keySet());
//
//        //when
//        //then
//        for (String symbol : cardMapKeys) {
//            final int cardQuantity = cardMap.get(symbol).size();
//            assertThat(cardQuantity).isEqualTo(12);
//        }
//    }
//
//    @Test
//    public void 각_심볼별_카드의_종류는_Enum_CardType을_모두_포함한다() {
//        //given
//        List<String> cardMapKeys = new ArrayList<>(cardMap.keySet());
//
//        //when
//        //then
//        for (String symbol : cardMapKeys) {
//            final List<Card> cards = cardMap.get(symbol);
//
//            List<String> cardNames = cards.stream()
//                .map(Card::getName)
//                .collect(Collectors.toList());
//
//            List<String> expectedCards = Arrays.stream(CardType.values())
//                .map(x -> new Card(symbol, x.getName(), x.getPoint()))
//                .map(Card::getName)
//                .collect(Collectors.toList());
//
//            assertThat(cardNames).contains(expectedCards.toArray(new String[0]));
//        }
//    }
}