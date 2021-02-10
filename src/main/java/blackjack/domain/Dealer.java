package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer implements GameParticipant {
    private final String name = "딜러";
    private final List<Card> cards = new ArrayList<>();
    private final int CRITERIA = 17;

    @Override
    public void addCard(Card card) {
        this.cards.add(card);
    }

    @Override
    public List<Card> getCardsBeforeGameStart() {
        return Collections.singletonList(this.cards.get(0));
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Card> getCards() {
        return this.cards;
    }

    @Override
    public int getResult() {
        return this.cards.stream()
                .mapToInt(card -> card.getDenomination().getNumber())
                .sum();
    }

    public boolean isActive() {
        return getResult() < CRITERIA;
    }
}
