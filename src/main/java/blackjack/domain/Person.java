package blackjack.domain;

import blackjack.dto.CardInfo;
import blackjack.dto.MatchInfo;
import blackjack.dto.NameInfo;
import blackjack.dto.ScoreInfo;

public abstract class Person {

    public static final int INIT_CARD_COUNT = 2;

    protected final String userName;
    protected final Cards cards;

    public Person(String userName, Cards cards) {
        this.userName = userName;
        this.cards = cards;
    }

    public void drawCard(Deck deck) {
        cards.add(deck.drawCard());
    }

    public abstract boolean canDrawCard();

    public abstract CardInfo openCards();

    public ScoreInfo getScoreInfo() {
        return new ScoreInfo(userName, cards.openCardAll(), cards.totalScore());
    }

    public int cardSize() {
        return cards.size();
    }

    public void initializeDeck(Deck deck) {
        for (int i = 0; i < INIT_CARD_COUNT; i++) {
            cards.add(deck.drawCard());
        }
    }

    public NameInfo mapToNameInfo() {
        return new NameInfo(userName);
    }
}
