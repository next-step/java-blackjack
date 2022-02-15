package blackjack.domain.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardDeck {

    List<Card> cards;

    public CardDeck() {
        cards = createCardDeck();
    }

    public static List<Card> createCardDeck() {
        List<Card> cards = new ArrayList<>();

        for (Shape shape : Shape.values()) {
            Arrays.stream(Denomination.values())
                .map(denomination -> new Card(shape, denomination))
                .forEach(cards::add);
        }
        return cards;
    }

    public List<Card> getCards() {
        return cards;
    }
}
