package blackjack.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
}