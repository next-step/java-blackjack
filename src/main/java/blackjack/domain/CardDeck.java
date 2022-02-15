package blackjack.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardDeck {

    private static final List<Card> cards = new ArrayList<>();

    static {
        Arrays.stream(CardNumber.values()).forEach(
            cardNumber -> Arrays.stream(CardPattern.values()).forEach(
                cardPattern -> cards.add(new Card(cardNumber, cardPattern))
            )
        );
        Collections.shuffle(cards);
    }

    public CardDeck() {
    }

    public static List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }
}
