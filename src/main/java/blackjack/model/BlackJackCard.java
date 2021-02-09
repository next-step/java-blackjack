package blackjack.model;

import java.util.ArrayList;

public class BlackJackCard {
    private final CardBundle cardBundle;

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
}
