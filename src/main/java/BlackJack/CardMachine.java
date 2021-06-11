package BlackJack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CardMachine {
    private List<Card> cards = new ArrayList<>();

    public List<CardShape> createCardShapes() {
        return Arrays.stream(CardShape.values())
                .collect(Collectors.toList());
    }

    public List<CardNumber> createCardNumbers() {
        return Arrays.stream(CardNumber.values())
                .collect(Collectors.toList());
    }

    public CardPack createCards() {
        for (CardShape cardShape : createCardShapes()) {
            for (CardNumber cardNumber : createCardNumbers()) {
                cards.add(new Card(cardShape, cardNumber));
            }
        }
        return new CardPack(cards);
    }
}