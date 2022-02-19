package blackjack.domain.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CardDeck {

    public static final int FIRST_INDEX = 0;

    private final List<Card> cards;

    public CardDeck() {
        cards = createCardDeck();
    }

    private List<Card> createCardDeck() {
        List<Card> cards = new ArrayList<>();
        for(Shape shape : Shape.values()) {
            cards.addAll(DenominationByShape(shape));
        }
        return cards;
    }

    private List<Card> DenominationByShape(Shape shape) {
        return Arrays.stream(Denomination.values())
            .map(denomination -> new Card(shape, denomination))
            .collect(Collectors.toList());
    }

    public Card pickOneCard() {
        Collections.shuffle(cards);
        Card pickedCard = cards.get(FIRST_INDEX);
        cards.remove(FIRST_INDEX);
        return pickedCard;
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }
}
