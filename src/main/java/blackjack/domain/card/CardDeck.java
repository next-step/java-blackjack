package blackjack.domain.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardDeck {

    private static final int FIRST_INDEX = 0;
    private static List<Card> cards;

    static {
        cards = new ArrayList<>();
    }

    public static void makeCardDeck(){
        List<Card> oldCards = new ArrayList<>();
        Arrays.stream(CardNumber.values()).forEach(
            cardNumber -> Arrays.stream(CardPattern.values()).forEach(
                cardPattern -> oldCards.add(new Card(cardNumber, cardPattern))
            )
        );
        Collections.shuffle(oldCards);
        cards = new ArrayList<>(oldCards);
    }

    public static Cards pop(final int count) {
        List<Card> newCards = new ArrayList<>(cards.subList(FIRST_INDEX, count));
        cards = cards.subList(count, cards.size() - count);
        return new Cards(newCards);
    }

    public static Card pop() {
        return cards.remove(FIRST_INDEX);
    }

    public static List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }
}
