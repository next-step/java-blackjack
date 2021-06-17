package blackjack.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardGenerator {
    private static final int CARD_INITIAL_COUNT = 0;

    private int cardIndex;
    private final List<CardTypes> cards;

    public CardGenerator() {
        this.cardIndex = CARD_INITIAL_COUNT;
        List<CardTypes> newCards = Arrays.asList(CardTypes.values());
        Collections.shuffle(newCards);
        this.cards = newCards;
    }

    public List<Card> getSeveralCard(int cardCount) {
        List<Card> cards = new ArrayList<>();

        for (int i = 0; i < cardCount; i++) {
            cards.add(getOneCard());
        }

        return cards;
    }

    public BunchOfCard getSeveralCard2(int cardCount) {
        BunchOfCard bunchOfCard = new BunchOfCard();

        for (int i = 0; i < cardCount; i++) {
            bunchOfCard.addCard(getOneCard());
        }

        return bunchOfCard;
    }

    public Card getOneCard() {
        int nowIndex = cardIndex;
        cardIndex++;
        return new Card(this.cards.get(nowIndex));
    }

    public int getLeftCardCount() {
        return this.cards.size() - this.cardIndex;
    }

    public void resetCards() {
        Collections.shuffle(cards);
        this.cardIndex = CARD_INITIAL_COUNT;
    }

}
