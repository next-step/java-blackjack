package blackjack.model.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlackJackCard {
    private final CardBundle cardBundle;
    private static final Random random = new Random();

    private BlackJackCard() {
        cardBundle = CardBundle.of(new ArrayList<>());
        for (Type type : Type.values()) {
            cardBundle.generateOneTypeCards(type);
        }
    }

    public static BlackJackCard of() {
        return new BlackJackCard();
    }

    public CardBundle getCardBundle() {
        return cardBundle;
    }

    public Card pickOneCard() {
        List<Card> cards = cardBundle.getCards();
        int pickNumber = random.nextInt(cards.size());
        Card pickedCard = cards.get(pickNumber);
        cards.remove(pickedCard);
        return pickedCard;
    }
}
