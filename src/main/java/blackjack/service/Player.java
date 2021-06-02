package blackjack.service;

import java.util.ArrayList;
import java.util.List;

public abstract class Player{
    String name;
    List<Card> cards = new ArrayList<>();
    int score;

    abstract void addDraw(CardDeck cardDeck);
    abstract void result(int score);

    abstract boolean isGamer();

    public void startDraw(CardDeck cardDeck){

        draw(cardDeck);
        draw(cardDeck);

    };

    public void draw(CardDeck cardDeck){
        Card card = cardDeck.getCard();
        cards.add(card);
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Integer getScore() {
        score = cards.stream()
                .map(card -> card.getCardNumber().getScore())
                .reduce(0, Integer::sum);
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
