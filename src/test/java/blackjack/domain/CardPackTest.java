package blackjack.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CardPackTest {

    private static final List<String> symbols = Arrays.asList("스페이드", "다이아몬드", "클로버", "하트");


    @Test
    public void 카드팩에는_모든_심볼의_카드_타입이_있어야_한다() {
        //given
        CardPack cardPack = CardPack.create();

        //when
        Map<String, List<Card>> cardMap = cardPack.getMap();
        List<String> cardMapKeys = new ArrayList<>(cardMap.keySet());

        //then
        Assertions.assertThat(cardMapKeys).contains(symbols.toArray(new String[0]));
    }
}