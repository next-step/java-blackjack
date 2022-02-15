package blackjack.domain;

import blackjack.util.CardShuffler;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CardPack {

    private static final List<String> symbols = Arrays.asList("스페이드", "다이아몬드", "클로버", "하트");
    private static final int SYMBOL_SIZE = symbols.size();
    private static final String ACE = "A";

    private final Map<String, List<Card>> map;

    public CardPack(Map<String, List<Card>> map) {
        this.map = map;
    }

    public static CardPack create() {
        Map<String, List<Card>> map = new HashMap<>();
        for (String symbol : symbols) {
            List<Card> cards = Arrays.stream(CardType.values())
                .map(card -> {
                    if (card.getName().equals(ACE)) {
                        return new Card(symbol, card.getName(), card.getPoint(), card.getLowerAcePoint());
                    }
                    return new Card(symbol, card.getName(), card.getPoint());
                })
                .collect(Collectors.toList());

            map.put(symbol, cards);
        }

        return new CardPack(map);
    }

    public Card pickCard() {
        int symbolIndex = CardShuffler.pickIndexIn(SYMBOL_SIZE);
        String symbol = symbols.get(symbolIndex);
        List<Card> cards = map.get(symbol);

        int cardIndex = CardShuffler.pickIndexIn(cards.size());
        return map.get(symbol).remove(cardIndex);
    }

    public Map<String, List<Card>> getMap() {
        return map;
    }
}
