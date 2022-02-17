package blackjack.domain;

import static org.assertj.core.api.Assertions.*;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardPack;
import blackjack.domain.card.CardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class CardPackTest {

    private static final List<String> symbols = Arrays.asList("스페이드", "다이아몬드", "클로버", "하트");
    CardPack cardPack = CardPack.create();
    Map<String, List<Card>> cardMap = cardPack.getMap();

    @Test
    public void 카드팩에는_모든_심볼의_카드_타입이_있어야_한다() {
        //given
        //when
        List<String> cardMapKeys = new ArrayList<>(cardMap.keySet());

        //then
        assertThat(cardMapKeys).contains(symbols.toArray(new String[0]));
    }

    @Test
    public void 각_심볼별_카드에는_12개의_카드가_존재한다() {
        //given
        List<String> cardMapKeys = new ArrayList<>(cardMap.keySet());

        //when
        //then
        for (String symbol : cardMapKeys) {
            final int cardQuantity = cardMap.get(symbol).size();
            assertThat(cardQuantity).isEqualTo(12);
        }
    }

    @Test
    public void 각_심볼별_카드의_종류는_Enum_CardType을_모두_포함한다() {
        //given
        List<String> cardMapKeys = new ArrayList<>(cardMap.keySet());

        //when
        //then
        for (String symbol : cardMapKeys) {
            final List<Card> cards = cardMap.get(symbol);

            List<String> cardNames = cards.stream()
                .map(Card::getName)
                .collect(Collectors.toList());

            List<String> expectedCards = Arrays.stream(CardType.values())
                .map(x -> new Card(symbol, x.getName(), x.getPoint()))
                .map(Card::getName)
                .collect(Collectors.toList());

            assertThat(cardNames).contains(expectedCards.toArray(new String[0]));
        }
    }
}