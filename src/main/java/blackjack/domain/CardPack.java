package blackjack.domain;

import blackjack.util.CardShuffler;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CardPack {

    private static final List<String> symbols = Arrays.asList("스페이드", "다이아몬드", "클로버", "하트");

    private final Map<String, List<Card>> map;

    public CardPack(Map<String, List<Card>> map) {
        this.map = map;
    }

    public static CardPack create() {
        Map<String, List<Card>> map = new HashMap<>();
        for (String symbol : symbols) {
            List<Card> cards = Arrays.stream(CardType.values())
                .map(x -> new Card(symbol, x.getName(), x.getPoint()))
                .collect(Collectors.toList());

            map.put(symbol, cards);
        }

        return new CardPack(map);
    }

    public void removeCard(List<Player> players) {
        for (Player player : players) {
            for (int i = 0; i < 2; i++) {
                int symbolIndex = CardShuffler.pickIndexIn(4);
                String symbol = symbols.get(symbolIndex);
                List<Card> cards = map.get(symbol);

                int cardIndex = CardShuffler.pickIndexIn(cards.size());
                Card pickedCard = map.get(symbol).remove(cardIndex);
                player.addCard(pickedCard);
            }
        }
    }

    public void removeCard(Dealer dealer) {
        for (int i = 0; i < 2; i++) {
            int symbolIndex = CardShuffler.pickIndexIn(4);
            List<Card> cards = map.get(symbols.get(symbolIndex));
            int cardIndex = CardShuffler.pickIndexIn(cards.size());

            dealer.addCard(cards.remove(cardIndex));
        }
    }

    public Map<String, List<Card>> getMap() {
        return map;
    }
}
