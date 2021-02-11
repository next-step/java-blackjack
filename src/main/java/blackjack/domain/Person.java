package blackjack.domain;

import blackjack.dto.NameInfo;
import blackjack.dto.PersonCardsInfo;
import blackjack.dto.ScoreInfo;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public abstract class Person {
    protected final CardBunch cardBunch;
    protected final String name;

    protected Person(String name) {
        this.name = name;
        this.cardBunch = new CardBunch();
    }

    protected Person(String name, CardBunch cardBunch) {
        this.name = name;
        this.cardBunch = cardBunch;
    }

    public abstract boolean canDrawCard();

    public void drawCardFromDeck(Deck deck) {
        cardBunch.addCard(
            deck.drawCard()
        );
    }

    public NameInfo getNameInfo() {
        return new NameInfo(name);
    }

    public PersonCardsInfo getPersonCardsInfo() {
        return new PersonCardsInfo(name, cardBunch.getCardsName());
    }

    public ScoreInfo getScoreInfo() {
        return new ScoreInfo(name, cardBunch.getCardsName(), cardBunch.calcScore());
    }
}
