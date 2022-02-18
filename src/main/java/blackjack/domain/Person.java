package blackjack.domain;

import blackjack.dto.CardInfo;
import blackjack.dto.NameInfo;
import blackjack.dto.ScoreInfo;

public abstract class Person {

    public static final int INIT_CARD_COUNT = 2;

    final String userName;
    final Cards cards;

    public Person(final String userName,final Cards cards) {
        this.userName = userName;
        this.cards = cards;
    }

    public void initializeDeck(final Deck deck) {
        for (int i = 0; i < INIT_CARD_COUNT; i++) {
            cards.add(deck.drawCard());
        }
    }

    public void drawCard(final Deck deck) {
        cards.add(deck.drawCard());
    }

    public int cardSize() {
        return cards.size();
    }

    public NameInfo nameInfo() {
        return new NameInfo(userName);
    }

    public ScoreInfo scoreInfo() {
        return new ScoreInfo(userName, cards.openCardAll(), cards.totalScore());
    }

    public abstract boolean canDrawCard();

    public abstract CardInfo openCards();
}
