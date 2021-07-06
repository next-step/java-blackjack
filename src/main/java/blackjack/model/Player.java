package blackjack.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private final String name;
    private List<Card> cards = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public int score() {
        int score = 0;
        for (Card card : cards) {
            score += card.getDenomination().getValue();
        }
        return score;
    }

    public void initialCardSetting() {
        List<Card> cardList = Cards.getCards();
        Collections.shuffle(cardList);
        this.cards.add(cardList.remove(0));
        this.cards.add(cardList.remove(0));
    }

    public void additionalCardSetting() {
        List<Card> cardList = Cards.getCards();
        Collections.shuffle(cardList);
        this.cards.add(cardList.remove(0));
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }
}
