package BlackJack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CardMachine {
    private CardPack cardPack;
    private List<Card> cards;

    public List<CardShape> createCardShapes() {
        return Arrays.stream(CardShape.values())
                .collect(Collectors.toList());
    }

    public List<CardNumber> createCardNumbers() {
        return Arrays.stream(CardNumber.values())
                .collect(Collectors.toList());
    }

    public CardPack createCards() {
        cards = new ArrayList<>();
        for (CardShape cardShape : createCardShapes()) {
            for (CardNumber cardNumber : createCardNumbers()) {
                cards.add(new Card(cardShape, cardNumber));
            }
        }
        cardPack = new CardPack(cards);
        return cardPack;
    }
}