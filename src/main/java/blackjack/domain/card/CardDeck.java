package blackjack.domain.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardDeck {

    public static final int FIRST_INDEX = 0;

    private List<Card> cards;

    public CardDeck() {
        cards = createCardDeck();
    }

    private List<Card> createCardDeck() {
        List<Card> cards = new ArrayList<>();

        for (Shape shape : Shape.values()) {
            Arrays.stream(Denomination.values())
                .map(denomination -> new Card(shape, denomination))
                .forEach(cards::add);
        }
        return cards;
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
